package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import sun.management.*;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;


/**
 * Created by Emile on 3/8/16.
 * This class is resposonible for retriving submitting and processing data from the database
 * Result set data will be built into objects and returned while data sent IN will be deconstructed into
 * appropriate SQL statements.
 */
public class Factory
{
    private final String  SELECT = "SELECT * FROM ";
    private final String INSERT = "INSERT INTO ";
    private final String UPDATE = "UPDATE ";
    private final String DELETE = "DELETE FROM ";
    private final String WHERE = " WHERE ";
    private final String AND = " AND";
    private final String VALUES = " VALUES";
    private final String TableName = "TableName";
    private final String SET = " SET ";
    private final String IGNORE = "IGNORE";
    private Vector<HashMap> resultData;
    private Class dataClass;
    private String SQL;

    public Factory(Class c)
    {
        this.dataClass = c;
    }
    public Factory(){}
    /**
    These methods deal with building the SQL string that will be sent to the database.
    TODO evaluate the placement of them in this class
    */

    /**
     * This method deconstructs the input parameter object into an SQL INSERT parameterized statement and an
     * array containing its data. The string is then sent to the Database object for submission
     * @param dataObject the Object to be deconstructed
     * @return int, 1 if the add was successful 0 otherwise
     */
    public int Deconstruct(Object dataObject){
        int result=0;
        try {
            dataClass = dataObject.getClass();
            Database database = new Database();
            Field[] fields = dataObject.getClass().getDeclaredFields();
            Object[] data = new Object[fields.length];
            Field table = dataClass.getDeclaredField(TableName);
            SQL = INSERT + table.get(table) + "(";
            for (int i = 1; i < fields.length; i++){
                if (fields[i].getName().equals(TableName)){
                    SQL += fields[i].getName() + ", ";
                    fields[i].setAccessible(true);
                    data[i] = (fields[i].get(dataObject));
                }
            }
            SQL = SQL.replaceAll(", $", "");
            SQL += ") ";
            SQL += VALUES+"(";
            for (int i = 0; i < fields.length-1; i++){
                SQL += "?, ";
            }
            SQL = SQL.replaceAll(", $", ")");
            result = database.Create(SQL,data);
        }
        catch(NoSuchFieldException | IllegalAccessException | SQLException e){ e.printStackTrace(); }
        return result;
    }

    public boolean delete(Object trash){
    Boolean result = null;
        try{
            Database database = new Database();
            dataClass = trash.getClass();
            SQL = DELETE + dataClass.getDeclaredField(TableName).get(trash) + WHERE;
            for (Field field : dataClass.getDeclaredFields()){
                if (field.isAnnotationPresent(Ignore.class)){
                    field.setAccessible(true);
                    SQL += field.getName()+" = "+field.get(trash);
                }
            }
            result = database.Delete(SQL);
        }
        catch (NoSuchFieldException | IllegalAccessException e){ e.printStackTrace(); }
        return result;
    }

    public int update(Object oldBusted,Object newHotness){
        int result=0;
        try{
            Database database = new Database();
            Field[] fields = dataClass.getDeclaredFields();
            Object[] newData = new Object[fields.length];
            Object[] oldData = new Object[fields.length];
            String whereClause = new String();
            dataClass = newHotness.getClass();
            Field table = dataClass.getDeclaredField(TableName);
            SQL = UPDATE + table.get(newHotness) + SET;
            for (int i = 1; i < fields.length; i++)
            {
                fields[i].setAccessible(true);

                if(fields[i].isAnnotationPresent(Ignore.class))
                    newData[i] = Model.Ignore.class;
                else {
                    SQL += fields[i].getName() + "=?,";
                    newData[i] = (fields[i].get(newHotness));
                }
                if((fields[i].get(oldBusted)) == null){
                    whereClause += fields[i].getName() + " is null" + AND;
                }
                else{
                    whereClause += fields[i].getName() + "=?" + AND;
                    oldData[i] = (fields[i].get(oldBusted));
                }
            }
            SQL = SQL.replaceAll(",$", " ");
            SQL += WHERE;
            SQL += whereClause;
            SQL = SQL.replaceAll("AND $", "");
            result = database.Update(SQL,oldData,newData);
        }
        catch (IllegalAccessException | NoSuchFieldException | SQLException e) {e.printStackTrace();}
        return result;
    }

    public void getSelectAll()
    {
        SQL = SELECT;
        try{
            Field f = dataClass.getDeclaredField(TableName);
            String table = new String();
            table = (String) f.get(table);
            SQL += table;
        }
        catch (NoSuchFieldException | IllegalAccessException e){ e.printStackTrace(); }
    }

    //Adds a where clause to the active SQL statement
    public String getSelectWhere(HashMap where){
        String Where = where.toString().replace("{" , "").replace("}" , "").replace("," , AND);
        getSelectAll();
        SQL += WHERE + Where;
        return SQL;
    }

    /**
    These methods deal with building objects. for this to work, the class being instantiated must have a
    set of fields that correspond directly to the table in the database they represent. Classes that do not follow
    this structure will be instantiated but will break this code when their fields are set.
     */
    public Vector makeEntity(){
        Database database = new Database();
        Vector<Object> objects = new Vector();

        try {
            resultData = database.Select(SQL);//submit the SQL
            if (resultData.isEmpty())//No results, return empty list
                return objects;
            ArrayList<Field> fields = getFields();//Retrieve references to all fields of the currently selected class
            for (HashMap map : resultData){//iterate one row of data
                Object myObj = dataClass.newInstance();
                for (Field field : fields) {
                    String fieldName = field.getName();//get the name on the field
                    field.set(myObj, map.get(fieldName));//set the field to the appropriate value in the Data HashMap
                }
                objects.add(myObj);
            }
        }
        catch (IllegalAccessException | InstantiationException | SQLException e) { e.printStackTrace(); }
        return objects;
    }
    //retrieves each field of the assigned Class and returns the accessible version of each in an array.
    private ArrayList<Field> getFields(){
        ArrayList<Field> fields = new ArrayList();
        for (Object k : resultData.get(0).keySet()){
            try{
                Field f = dataClass.getDeclaredField(k.toString());
                f.setAccessible(true);
                fields.add(f);
            }
            catch (NoSuchFieldException e){ e.printStackTrace();}
        }
        return fields;
    }
}

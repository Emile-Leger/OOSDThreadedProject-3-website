package Model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.Vector;


/**
 * Created by Emile.
 */
public class Database {
    private String connectionString = "jdbc:mysql://localhost:3306/travelexperts?generateSimpleParameterMetadata=true";
    private Connection mariaConn;

    public Database() {
        this.mariaConn = getConnection();
    }

    /**
     * Fetches a connection to MySQL
     */
    public Connection getConnection() {
        try {
            Connection mariaConn = DriverManager.getConnection(connectionString, "root", "");
            return mariaConn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * submits a SELECT SQL statement and returns a disconnected set of result data.
     */
    public Vector<HashMap> Select(String SQL) throws SQLException {
        Vector<HashMap> tableData = new Vector<>();
        try {
            Statement statement = mariaConn.createStatement();
            System.out.println(SQL);
            ResultSet result = statement.executeQuery(SQL);
            ResultSetMetaData metaData = result.getMetaData();
            while (result.next()) {
                HashMap rowData = new HashMap();
                //constructs Key Values for the current row
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    result.getObject(i);
                    if (result.wasNull()) {
                        rowData.put(metaData.getColumnLabel(i), null);
                    } else if (result.getObject(i).getClass() == BigDecimal.class) {
                        double cell = ((BigDecimal) result.getObject(i)).doubleValue();
                        rowData.put(metaData.getColumnLabel(i), cell);
                    } else if (result.getObject(i).getClass() == Double.class) {
                        int cell = ((Double) result.getObject(i)).intValue();
                        rowData.put(metaData.getColumnLabel(i), cell);
                    } else {
                        rowData.put(metaData.getColumnLabel(i), result.getObject(i));
                    }
                }
                tableData.add(rowData);
            }
        } catch (SQLException e) { e.printStackTrace();}
        mariaConn.close();
        return tableData;
    }

    /**
     * Recieves a parameterized SQL data manipulation query along with corresponding data. Sets the parameters and
     * submits the SQL. returns 1 for success 0 for failure.
     *
     * @param SQL
     * @param data
     * @return
     * @throws SQLException
     */
    public int Create(String SQL, Object[] data) throws SQLException //maybe not the way to do this, need the data
    {
        Integer result = 0;
        PreparedStatement statement = mariaConn.prepareStatement(SQL);
        for (int i = 1; i < data.length; i++) {
            statement.setObject(i, data[i]);
        }
        result = statement.executeUpdate();
        return result;
    }

    public int Update(String SQL, Object[] oldData, Object[] newData) throws SQLException {
        Integer paramCount = 1;
        PreparedStatement statement = mariaConn.prepareStatement(SQL);
        for (int i = 1; i <= newData.length-1; i++) {
            if(newData[i].getClass() == Ignore.class){
                statement.setObject(paramCount, newData[i]);
                paramCount++;
            }
        }
        for (int i = 1; i <= oldData.length-1; i++) {
            if (oldData[i] != null) {
                statement.setObject(paramCount, oldData[i]);
                paramCount++;
            }
        }
        paramCount = statement.executeUpdate();
        return paramCount;
    }

    public Boolean Delete(String SQL){
        Boolean result = null;
        try
        {
            Statement statement = mariaConn.createStatement();
            result = statement.execute(SQL);

        } catch (SQLException e) { e.printStackTrace(); }
        return result;
    }
}

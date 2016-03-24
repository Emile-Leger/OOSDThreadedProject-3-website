package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Emile
 */
public class Supplier
{
    public static final String TableName = "suppliers";

    /**
    Constructors
     */
    public Supplier(String supName, Integer supplierId) {
        SupName = supName;
        SupplierId = supplierId;
    }

    public Supplier() { }

    /**
    Data Access Methods
     */

    public static int add(Supplier supplier){
        Factory factory = new Factory(Supplier.class);
        return factory.Deconstruct(supplier);
    }

    public static int update(Supplier oldSupp,Supplier newSupp){
        Factory factory = new Factory(Supplier.class);
        return factory.update(oldSupp,newSupp);
    }

    public static boolean delete(Supplier trash){
        Factory factory = new Factory();
        return factory.delete(trash);
    }

    public static Supplier getById(int supplierId){
        HashMap join = new HashMap();
        join.put("SupplierId",supplierId);
        Factory factory = new Factory(Supplier.class);
        factory.getSelectWhere(join);
        Supplier supplier = (Supplier) factory.makeEntity().firstElement();
        return supplier;
    }

    public static Vector<Supplier> getAll(){
        Factory factory = new Factory(Supplier.class);
        System.out.println(Supplier.class);
        factory.getSelectAll();
        Vector suppliers = factory.makeEntity();
        return suppliers;
    }

    /**
    Fields with get set Methods, Ignore attribute indicates the field corresponding to the Primary Key
     */

    @Ignore
    private Integer SupplierId;
    public int getSupplierId() { return SupplierId; }
    public void setSupplierId(Integer supplierId) { SupplierId = supplierId; }

    private String SupName;
    public String getSupName() { return SupName; }
    public void setSupName(String supName) { SupName = supName; }
}

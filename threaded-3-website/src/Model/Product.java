package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.lang.*;
import java.util.HashMap;
import java.util.Vector;

/**
Created by Emile
 */
public class Product implements Cloneable
{

    public static final String TableName = "products";

    /**
    Constructors
     */
    public Product(String productDesc, int productId, String productName,
                   double productRate, double productTotal, int productTypeId, int supplierId) {
        ProductDesc = productDesc;
        ProductId = productId;
        ProductName = productName;
        ProductRate = productRate;
        ProductTotal = productTotal;
        ProductTypeId = productTypeId;
        SupplierId = supplierId;
    }
    public Product() { }

    /**
    Data Access Methods
     */
    public static Product getById(int ProductId)
    {
        HashMap join = new HashMap();
        join.put("ProductId",ProductId);
        Factory factory = new Factory(Product.class);
        factory.getSelectWhere(join);
        Product product = (Product) factory.makeEntity().firstElement();
        return product;
    }

    public static int update(Product oldProduct, Product newProduct){
        Factory factory = new Factory(Product.class);
        return factory.update(oldProduct,newProduct);
    }

    public static Vector<Product> getByPackageId(int packageId)
    {
        HashMap join = new HashMap();
        join.put("packageId", packageId);
        Factory factory = new Factory(Product.class);
        factory.getSelectWhere(join);
        Vector products = factory.makeEntity();
        return products;
    }

    public static void getByPackageid(Package pack)
    {
        getByPackageId(pack.getPackageId());
    }

    public static Vector<Product> getAll()
    {
        Factory factory = new Factory(Product.class);
        factory.getSelectAll();
        Vector products = factory.makeEntity();
        return products;
    }

    public Product clone(){
        try
        {
            return (Product) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
    Fields with Get Set methods
     */

    private String ProductDesc;
    public String getProductDesc() { return ProductDesc; }
    public void setProductDesc(String productDesc) { ProductDesc = productDesc; }
    @Ignore
    private int ProductId;
    public int getProductId() { return ProductId; }
    public void setProductId(int productId) { ProductId = productId; }

    private String ProductName;
    public String getProductName() { return ProductName; }
    public void setProductName(String productName) { ProductName = productName; }

    private double ProductRate;
    public double getProductRate() { return ProductRate; }
    public void setProductRate(double productRate) { ProductRate = productRate; }

    private double ProductTotal;
    public double getProductTotal() { return ProductTotal; }
    public void setProductTotal(double productTotal) { ProductTotal = productTotal; }

    private int ProductTypeId;
    public int getProductTypeId() { return ProductTypeId; }
    public void setProductTypeId(int productTypeId) { ProductTypeId = productTypeId; }

    private int SupplierId;
    public int getSupplierId() { return SupplierId; }
    public void setSupplierId(int supplierId) { SupplierId = supplierId; }
}

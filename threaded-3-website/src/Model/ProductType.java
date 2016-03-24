package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Emile
 */
public class ProductType
{
    public static final String TableName = "producttypes";

    /**
    Constructors
     */
    public ProductType(String prodTypeName, int productTypeId) {
        ProdTypeName = prodTypeName;
        ProductTypeId = productTypeId;
    }

    public ProductType() { }

    /**
    Data Access methods
     */
    public static ProductType getById(int ProductTypeId){
        HashMap join = new HashMap();
        join.put("ProductTypeId",ProductTypeId);
        Factory factory = new Factory(ProductType.class);
        factory.getSelectWhere(join);
        ProductType prodType = (ProductType) factory.makeEntity().firstElement();
        return prodType;
    }

    public static Integer add(ProductType newProdType){
        Factory factory = new Factory(ProductType.class);
        return factory.Deconstruct(newProdType);
    }

    public static Vector<ProductType> getAll(){
        Factory factory = new Factory(ProductType.class);
        factory.getSelectAll();
        Vector prodTypes = factory.makeEntity();
        return prodTypes;
    }

    /**
    Fields with get set methods
     */
    @Ignore
    private int ProductTypeId;
    public int getProductTypeId() { return ProductTypeId; }
    public void setProductTypeId(int productTypeId) { ProductTypeId = productTypeId; }

    private String ProdTypeName;
    public String getProdTypeName() { return ProdTypeName; }
    public void setProdTypeName(String prodTypeName) { ProdTypeName = prodTypeName; }


}

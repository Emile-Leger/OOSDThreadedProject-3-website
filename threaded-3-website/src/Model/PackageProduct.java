package Model;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by user1 on 3/9/16.
 */
public class PackageProduct
{
    public static final String TableName = "packages_products";

    public PackageProduct(int packageId, int productId)
    {
        PackageId = packageId;
        ProductId = productId;
    }
    public PackageProduct() { }
    //TODO deal with the bidirectionality of this table
    public static PackageProduct getByPackageId(int id)
    {
        HashMap join = new HashMap();
        join.put(TableName + "." + "PackageId",id);
        //this is RIDICULOUS... Figure out join
        join.put(Product.TableName + "." + "ProductId",TableName+"."+"ProductId");
        Factory factory = new Factory(PackageProduct.class);
        factory.getSelectWhere(join);
        PackageProduct packprod = (PackageProduct) factory.makeEntity().firstElement();
        return packprod;
    }

    public static PackageProduct getByProductId(int id)
    {
        HashMap join = new HashMap();
        join.put("ProductId",id);
        Factory factory = new Factory(PackageProduct.class);
        factory.getSelectWhere(join);
        PackageProduct packprod = (PackageProduct) factory.makeEntity().firstElement();
        return packprod;
    }

    private int PackageId;
    public int getPackageId() { return PackageId; }
    public void setPackageId(int packageId) { PackageId = packageId; }

    private int ProductId;
    public int getProductId() { return ProductId; }
    public void setProductId(int productId) { ProductId = productId; }


}

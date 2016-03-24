package Model;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class Package
{
    public static final String TableName = "packages";


    /**
    Constructors
     */
    public Package() {}
    public Package(int packageId, double pkgAgencyCommission, double pkgBasePrice,
                   String pkgDesc, Date pkgEndDate, Date pkgStartDate, String pkgName)
    {
        PackageId = packageId;
        PkgAgencyCommission = pkgAgencyCommission;
        PkgBasePrice = pkgBasePrice;
        PkgDesc = pkgDesc;
        PkgEndDate = pkgEndDate;
        PkgStartDate = pkgStartDate;
        PkgName = pkgName;
    }
    /**
    Data Access Methods
     */

    public static int add(Agent agent)
    {
        Factory factory = new Factory(Agent.class);
        return factory.Deconstruct(agent);
    }
    public static Package getById(int PackageId)
    {
        HashMap join = new HashMap();
        Factory factory = new Factory(Package.class);
        join.put("PackageId",PackageId);
        factory.getSelectWhere(join);
        Package pack = (Package) factory.makeEntity().firstElement();
        return pack;
    }

    public Vector<Product> getProducts()

    {
        Vector<Product> products = new Vector();
        Factory packageProductfactory = new Factory(PackageProduct.class);
        HashMap join = new HashMap();
        join.put("PackageId",this.getPackageId());
        packageProductfactory.getSelectWhere(join);
        Vector<PackageProduct> packprods = packageProductfactory.makeEntity();
        if(packprods.isEmpty())
        {
            return products;
        }
        for (PackageProduct packprod : packprods)
        {
            products.add(Product.getById(packprod.getProductId()));
        }
        return products;
    }

    public static Vector<Package> getAll()
    {
        Factory factory = new Factory(Package.class);
        factory.getSelectAll();
        Vector packages = factory.makeEntity();
        return packages;
    }

    /**
    Fields with Get Set Methods
     */
    private int PackageId;
    public int getPackageId() { return PackageId; }
    public void setPackageId(int packageId) { PackageId = packageId; }

    private double PkgAgencyCommission;
    public double getPkgAgencyCommission() { return PkgAgencyCommission; }
    public void setPkgAgencyCommission(double pkgAgencyCommission) { PkgAgencyCommission = pkgAgencyCommission; }

    private double PkgBasePrice;
    public double getPkgBasePrice() { return PkgBasePrice; }
    public void setPkgBasePrice(double pkgBasePrice) { PkgBasePrice = pkgBasePrice; }

    private String PkgDesc;
    public String getPkgDesc() { return PkgDesc; }
    public void setPkgDesc(String pkgDesc) { PkgDesc = pkgDesc; }

    private Date PkgEndDate;
    public Date getPkgEndDate() { return PkgEndDate; }
    public void setPkgEndDate(Date pkgEndDate) { PkgEndDate = pkgEndDate; }

    private Date PkgStartDate;
    public Date getPkgStartDate() { return PkgStartDate; }
    public void setPkgStartDate(Date pkgStartDate) { PkgStartDate = pkgStartDate; }

    private String PkgName;
    public String getPkgName() { return PkgName; }
    public void setPkgName(String pkgName) { PkgName = pkgName; }

}

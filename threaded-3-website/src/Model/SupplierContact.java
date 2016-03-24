package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Emile
 */
public class SupplierContact
{
    public static final String TableName = "suppliercontacts";
    /**
    Constructors
     */

    public SupplierContact(String affiliationId, String supConAddress, String supConBusPhone, String supConCity,
                           String supConCompany, String supConCountry, String supConEmail, String supConFax, String supConFirstName,
                           String supConLastName, String supConPostal, String supConProv, String supConURL, Integer supplierContactId, Integer supplierId)
    {
        AffiliationId = affiliationId;
        SupConAddress = supConAddress;
        SupConBusPhone = supConBusPhone;
        SupConCity = supConCity;
        SupConCompany = supConCompany;
        SupConCountry = supConCountry;
        SupConEmail = supConEmail;
        SupConFax = supConFax;
        SupConFirstName = supConFirstName;
        SupConLastName = supConLastName;
        SupConPostal = supConPostal;
        SupConProv = supConProv;
        SupConURL = supConURL;
        SupplierContactId = supplierContactId;
        SupplierId = supplierId;
    }
    public SupplierContact(){

    }
    /**
    Data Access Methods
     */
    public static SupplierContact getById(int SupplierContactId)
    {
        HashMap join = new HashMap();
        join.put("SupplierContactId",SupplierContactId);
        Factory factory = new Factory(SupplierContact.class);
        factory.getSelectWhere(join);
        SupplierContact supplierContact = (SupplierContact) factory.makeEntity().firstElement();
        return supplierContact;
    }

    public static Vector<SupplierContact> getAll()
    {
        Factory factory = new Factory(SupplierContact.class);
        factory.getSelectAll();
        Vector supplierContacts = factory.makeEntity();
        return supplierContacts;
    }

    public static int add(SupplierContact supplierContact)
    {
        Factory factory = new Factory(SupplierContact.class);
        return factory.Deconstruct(supplierContact);
    }
    public static int update(SupplierContact oldSupCon,SupplierContact newSupCon)
    {
        Factory factory = new Factory(SupplierContact.class);
        return factory.update(oldSupCon,newSupCon);
    }
    /**
    Fields with Get Set Methods Ignore attribute indicates the Primary key
     */

    @Ignore
    private Integer SupplierContactId;
    public int getSupplierContactId() { return SupplierContactId; }
    public void setSupplierContactId(Integer supplierContactId) { SupplierContactId = supplierContactId; }

    private String AffiliationId;
    public String getAffiliationId() { return AffiliationId; }
    public void setAffiliationId(String affiliationId) { AffiliationId = affiliationId; }

    private String SupConAddress;
    public String getSupConAddress() { return SupConAddress; }
    public void setSupConAddress(String supConAddress) { SupConAddress = supConAddress; }

    private String SupConBusPhone;
    public String getSupConBusPhone() { return SupConBusPhone; }
    public void setSupConBusPhone(String supConBusPhone) { SupConBusPhone = supConBusPhone; }

    private String SupConCity;
    public String getSupConCity() { return SupConCity; }
    public void setSupConCity(String supConCity) { SupConCity = supConCity; }

    private String SupConCompany;
    public String getSupConCompany() { return SupConCompany; }
    public void setSupConCompany(String supConCompany) { SupConCompany = supConCompany; }

    private String SupConCountry;
    public String getSupConCountry() { return SupConCountry; }
    public void setSupConCountry(String supConCountry) { SupConCountry = supConCountry; }

    private String SupConEmail;
    public String getSupConEmail() { return SupConEmail; }
    public void setSupConEmail(String supConEmail) { SupConEmail = supConEmail; }

    private String SupConFax;
    public String getSupConFax() { return SupConFax; }
    public void setSupConFax(String supConFax) { SupConFax = supConFax; }

    private String SupConFirstName;
    public String getSupConFirstName() { return SupConFirstName; }
    public void setSupConFirstName(String supConFirstName) { SupConFirstName = supConFirstName; }

    private String SupConLastName;
    public String getSupConLastName() { return SupConLastName; }
    public void setSupConLastName(String supConLastName) { SupConLastName = supConLastName; }

    private String SupConPostal;
    public String getSupConPostal() { return SupConPostal; }
    public void setSupConPostal(String supConPostal) { SupConPostal = supConPostal; }

    private String SupConProv;
    public String getSupConProv() { return SupConProv; }
    public void setSupConProv(String supConProv) { SupConProv = supConProv; }

    private String SupConURL;
    public String getSupConURL() { return SupConURL; }
    public void setSupConURL(String supConURL) { SupConURL = supConURL; }

    private Integer SupplierId;
    public int getSupplierId() { return SupplierId; }
    public void setSupplierId(Integer supplierId) { SupplierId = supplierId; }
}

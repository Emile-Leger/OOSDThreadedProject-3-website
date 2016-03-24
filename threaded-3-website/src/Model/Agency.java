package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Vector;

/**
Created by Emile.
 */
public class Agency
{
    public static final String TableName = "agencies";

    /**
    Constructors
     */

    public Agency(int agencyId, String agncyAddress, String agncyCity, String agncyCountry,
                  String agncyFax, String agncyPhone, String agncyPostal, String agncyProv)
    {
        AgencyId = agencyId;
        AgncyAddress = agncyAddress;
        AgncyCity = agncyCity;
        AgncyCountry = agncyCountry;
        AgncyFax = agncyFax;
        AgncyPhone = agncyPhone;
        AgncyPostal = agncyPostal;
        AgncyProv = agncyProv;
    }

    public Agency() { }

    /**
    Data Access Methods
     */

    public static Agency getById(int AgencyId){
        HashMap join = new HashMap();
        join.put("AgencyId",AgencyId);
        Factory factory = new Factory(Agency.class);
        factory.getSelectWhere(join);
        Agency agency = (Agency) factory.makeEntity().firstElement();
        return agency;
    }

    public static Vector<Agency> getAll(){
        Factory factory = new Factory(Agency.class);
        factory.getSelectAll();
        return factory.makeEntity();
    }

    public static Integer add(Agency newAgency){
        Factory factory = new Factory(Agency.class);
        return factory.Deconstruct(newAgency);
    }

    public static Integer update(Agency oldAgency, Agency newAgency){
        Factory factory = new Factory(Agency.class);
        return factory.update(oldAgency,newAgency);
    }

    /**
    Fields, each with Get Set methods attached
     */
    @Ignore
    private int AgencyId;
    public int getAgencyId() { return AgencyId; }
    public void setAgencyId(int agencyId) { AgencyId = agencyId; }

    private String AgncyAddress;
    public String getAgncyAddress() { return AgncyAddress; }
    public void setAgncyAddress(String agncyAddress) { AgncyAddress = agncyAddress; }

    private String AgncyCity;
    public String getAgncyCity() { return AgncyCity; }
    public void setAgncyCity(String agncyCity) { AgncyCity = agncyCity; }

    private String AgncyCountry;
    public String getAgncyCountry() { return AgncyCountry; }
    public void setAgncyCountry(String agncyCountry) { AgncyCountry = agncyCountry; }

    private String AgncyFax;
    public String getAgncyFax() { return AgncyFax; }
    public void setAgncyFax(String agncyFax) { AgncyFax = agncyFax; }

    private String AgncyPhone;
    public String getAgncyPhone() { return AgncyPhone; }
    public void setAgncyPhone(String agncyPhone) { AgncyPhone = agncyPhone; }

    private String AgncyPostal;
    public String getAgncyPostal() { return AgncyPostal; }
    public void setAgncyPostal(String agncyPostal) { AgncyPostal = agncyPostal; }

    private String AgncyProv;
    public String getAgncyProv() { return AgncyProv; }
    public void setAgncyProv(String agncyProv) { AgncyProv = agncyProv; }

}

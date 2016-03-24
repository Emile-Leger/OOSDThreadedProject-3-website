package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Vector;

public class Customer implements Cloneable{

    public final static String TableName = "customers";

    /**
    Constructors
    */

    public Customer(int customerId, String custFirstName, String custLastName, String custEmail,
                    String custHomePhone, String custBusPhone, String custAddress,String custPostal, String custCity,
                    String custCountry, String custProv, Integer agentId, String password, String userName)
        {
            CustomerId = customerId;
            CustFirstName = custFirstName;
            CustLastName = custLastName;
            CustEmail = custEmail;
            CustHomePhone = custHomePhone;
            CustBusPhone = custBusPhone;
            CustAddress = custAddress;
            CustPostal = custPostal;
            CustCity = custCity;
            CustCountry = custCountry;
            CustProv = custProv;
            AgentId = agentId;
            Password = password;
            UserName = userName;
        }

    public Customer() { }

    /**
    Data Access Methods
     */

    public static Customer getById(Integer CustomerId){
        HashMap join = new HashMap();
        join.put("CustomerId",CustomerId);
        Factory factory = new Factory(Customer.class);
        factory.getSelectWhere(join);
        Customer myCust = (Customer) factory.makeEntity().firstElement();
        return myCust;
    }

    /*
    Use this method to get all customers assigned to the specified agent.
     */
    public static Vector<Customer> getByAgentId(Integer agentId){
        HashMap join = new HashMap();
        Factory factory = new Factory(Customer.class);
        join.put("AgentId",agentId);
        factory.getSelectWhere(join);
        return factory.makeEntity();
    }

    public static Customer login(String username, String password)
    {
        HashMap<String,String> authentication = new HashMap();
        Factory factory =  new Factory(Customer.class);
        authentication.put("UserName", "'"+username+"'" );
        authentication.put("Password","'"+password+"'");
        factory.getSelectWhere(authentication);
        Vector <Customer> result = factory.makeEntity();
        if (result.isEmpty()){ return new Customer(); }
        else{ return result.firstElement(); }
    }

    public static Vector<Customer> getAll(){
        Factory factory = new Factory(Customer.class);
        factory.getSelectAll();
        Vector customers = factory.makeEntity();
        return customers;
    }

    public static Integer add(Customer newCust){
        Factory factory = new Factory(Customer.class);
        return factory.Deconstruct(newCust);
    }

    public static Integer update(Customer oldBusted, Customer newHotness){
        Factory factory = new Factory(Customer.class);
        return factory.update(oldBusted,newHotness);
    }

    public Customer Clone()
    {
        try
        {
            return (Customer) super.clone();
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
    @Ignore
    private int CustomerId;
    public int getCustomerId() { return CustomerId; }
    public void setCustomerId(Integer customerId) { CustomerId = customerId; }

    private String CustFirstName;
    public String getCustFirstName() { return CustFirstName; }
    public void setCustFirstName(String custFirstName) { CustFirstName = custFirstName; }

    private String CustLastName;
    public String getCustLastName() { return CustLastName; }
    public void setCustLastName(String custLastName) { CustLastName = custLastName; }

    private String CustEmail;
    public String getCustEmail() { return CustEmail; }
    public void setCustEmail(String custEmail) { CustEmail = custEmail; }

    private String CustHomePhone;
    public String getCustHomePhone() { return CustHomePhone; }
    public void setCustHomePhone(String custHomePhone) { CustHomePhone = custHomePhone; }

    private String CustBusPhone;
    public String getCustBusPhone() { return CustBusPhone; }
    public void setCustBusPhone(String custBusPhone) { CustBusPhone = custBusPhone; }

    private String CustAddress;
    public String getCustAddress() { return CustAddress; }
    public void setCustAddress(String custAddress) { CustAddress = custAddress; }

    private String CustPostal;
    public String getCustPostal() { return CustPostal; }
    public void setCustPostal(String custPostal){ CustPostal = custPostal; }

    private String CustCity;
    public String getCustCity() { return CustCity; }
    public void setCustCity(String custCity) { CustCity = custCity; }

    private String CustCountry;
    public String getCustCountry() { return CustCountry; }
    public void setCustCountry(String custCountry) { CustCountry = custCountry; }

    private String CustProv;
    public String getCustProv() { return CustProv; }
    public void setCustProv(String custProv) { CustProv = custProv; }

    private int AgentId;
    public int getAgentId() { return AgentId; }
    public void setAgentId(Integer agentId) { AgentId = agentId; }
    //TODO deal with authentication
    private String Password;
    public String getPassword() { return Password; }
    public void setPassword(String password) { Password = password; }

    private String UserName;
    public String getUserName() { return UserName; }
    public void setUserName(String userName) { UserName = userName; }

}

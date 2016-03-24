package Model;

/**
 * Created by user1 on 3/9/16.
 */
public class Employee
{
    public static final String TableName = "employees";
    /*
    Constructors
     */
    public Employee(String empBusPhone, String empEmail, String empFirstName,
                    String empLastName, String empMiddleInitial, String empPosition) {
        EmpBusPhone = empBusPhone;
        EmpEmail = empEmail;
        EmpFirstName = empFirstName;
        EmpLastName = empLastName;
        EmpMiddleInitial = empMiddleInitial;
        EmpPosition = empPosition;
    }
    public Employee() { }

    /*
    Data Access Methods
     */
    //TODO Code...
    /*
    Fields with GetSet Methods
     */
    private String EmpBusPhone;
    public String getEmpBusPhone() { return EmpBusPhone; }
    public void setEmpBusPhone(String empBusPhone) { EmpBusPhone = empBusPhone; }

    private String EmpEmail;
    public String getEmpEmail() { return EmpEmail; }
    public void setEmpEmail(String empEmail) { EmpEmail = empEmail; }

    private String EmpFirstName;
    public String getEmpFirstName() { return EmpFirstName; }
    public void setEmpFirstName(String empFirstName) { EmpFirstName = empFirstName; }

    private String EmpLastName;
    public String getEmpLastName() { return EmpLastName; }
    public void setEmpLastName(String empLastName) { EmpLastName = empLastName; }

    private String EmpMiddleInitial;
    public String getEmpMiddleInitial() { return EmpMiddleInitial; }
    public void setEmpMiddleInitial(String empMiddleInitial) { EmpMiddleInitial = empMiddleInitial; }

    private String EmpPosition;
    public String getEmpPosition() { return EmpPosition; }
    public void setEmpPosition(String empPosition) { EmpPosition = empPosition; }
}

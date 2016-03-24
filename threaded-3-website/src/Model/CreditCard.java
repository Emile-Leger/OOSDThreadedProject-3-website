package Model;

import java.util.Date;

/**
 * Created by user1 on 3/9/16.
 */
public class CreditCard
{
    public static final String TableName = "creditcards";
    /*
    Constructor
     */
    public CreditCard(Date CCExpiry, String CCName, int creditCardId, int customerId)
    {
        this.CCExpiry = CCExpiry;
        this.CCName = CCName;
        CreditCardId = creditCardId;
        CustomerId = customerId;
    }
    public CreditCard() { }

    /*
    Data Access Methods
     */
    //TODO Code...
    /*
    Fields with Get Set Methods
     */
    private Date CCExpiry;
    public Date getCCExpiry() { return CCExpiry; }
    public void setCCExpiry(Date CCExpiry) { this.CCExpiry = CCExpiry; }

    private String CCName;
    public String getCCName() { return CCName; }
    public void setCCName(String CCName) { this.CCName = CCName; }

    private int CreditCardId;
    public int getCreditCardId() { return CreditCardId; }
    public void setCreditCardId(int creditCardId) { CreditCardId = creditCardId; }

    private int CustomerId;
    public int getCustomerId() { return CustomerId; }
    public void setCustomerId(int customerId) { CustomerId = customerId; }
}

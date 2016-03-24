package Model;

/**
 * Created by user1 on 3/9/16.
 */
public class Fee
{
    public static final String TableName = "fees";
    /*
    Constructors
     */
    public Fee(double feeAmt, String feeDesc, String feeId, String feeName) {
        FeeAmt = feeAmt;
        FeeDesc = feeDesc;
        FeeId = feeId;
        FeeName = feeName;
    }
    public Fee() { }
    /*
    Data Access Methods
     */
    //TODO Code...
    /*
    Fields with Get Set Methods
     */
    private double FeeAmt;
    public double getFeeAmt() { return FeeAmt; }
    public void setFeeAmt(double feeAmt) { FeeAmt = feeAmt; }

    private String FeeDesc;
    public String getFeeDesc() { return FeeDesc; }
    public void setFeeDesc(String feeDesc) { FeeDesc = feeDesc; }
    @Ignore
    private String FeeId;
    public String getFeeId() { return FeeId; }
    public void setFeeId(String feeId) { FeeId = feeId; }

    private String FeeName;
    public String getFeeName() { return FeeName; }
    public void setFeeName(String feeName) { FeeName = feeName; }
}

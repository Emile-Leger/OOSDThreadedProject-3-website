package Model;

/**
 * Created by user1 on 3/9/16.
 */
public class TripType
{
    public static final String TableName = "triptypes";

    /*
    Constructors
     */
    public TripType(String tripTypeId, String TTName) {
        TripTypeId = tripTypeId;
        this.TTName = TTName;
    }
    public TripType() { }

    /*
    Data Access Methods
     */
    //TODO Code...

    /*
    Fields with Get Set Methods
     */
    private String TripTypeId;
    public String getTripTypeId() { return TripTypeId; }
    public void setTripTypeId(String tripTypeId) { TripTypeId = tripTypeId; }

    private String TTName;
    public String getTTName() { return TTName; }
    public void setTTName(String TTName) { this.TTName = TTName; }

}

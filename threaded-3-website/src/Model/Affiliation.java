package Model;

/**
 * Created by Emile
 */
public class Affiliation
{
    public static final String TableName = "affiliations";
    /**
    Constructors
     */
    public Affiliation(String affDesc, String affilitationId, String affName) {
        AffDesc = affDesc;
        AffilitationId = affilitationId;
        AffName = affName;
    }
    public Affiliation() { }
    /**
    Data Access Methods
     */
    //TODO Code...
    /**
    Fields with Get Set methods
     */
    private String AffDesc;
    public String getAffDesc() { return AffDesc; }
    public void setAffDesc(String affDesc) { AffDesc = affDesc; }

    private String AffilitationId;
    public String getAffilitationId() { return AffilitationId; }
    public void setAffilitationId(String affilitationId) { AffilitationId = affilitationId; }

    private String AffName;
    public String getAffName() { return AffName; }
    public void setAffName(String affName) { AffName = affName; }
}

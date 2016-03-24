package Model;

/**
 * Created by user1 on 3/9/16.
 */
public class Region
{
    public static final String TableName = "regions";
    /*
    Constructors
     */

    public Region(String regionId, String regionName) {
        RegionId = regionId;
        RegionName = regionName;
    }
    public Region() { }
    /*
    Data Access Methods
     */
    //TODO Code...

    /*
    Fields with Get Set Methods
     */
    private String RegionId;
    public String getRegionId() { return RegionId; }
    public void setRegionId(String regionId) { RegionId = regionId; }

    private String RegionName;
    public String getRegionName() { return RegionName; }
    public void setRegionName(String regionName) { RegionName = regionName; }

}

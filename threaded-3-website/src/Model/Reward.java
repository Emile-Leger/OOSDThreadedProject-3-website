package Model;

/**
Created by Emile
 */
public class Reward{

    public static final String TableName = "rewards";
    /**
    Constructors
     */

    public Reward(int rewardId, String rwdDesc, String rwdName) {
        RewardId = rewardId;
        RwdDesc = rwdDesc;
        RwdName = rwdName;
    }
    public Reward() { }
    /**
    Data Access Methods
     */
    //TODO Code..
    /**
    Fields with Get Set Methods
     */
    private int RewardId;
    public int getRewardId() { return RewardId; }
    public void setRewardId(int rewardId) { RewardId = rewardId; }

    private String RwdDesc;
    public String getRwdDesc() { return RwdDesc; }
    public void setRwdDesc(String rwdDesc) { RwdDesc = rwdDesc; }

    private String RwdName;
    public String getRwdName() { return RwdName; }
    public void setRwdName(String rwdName) { RwdName = rwdName; }
}

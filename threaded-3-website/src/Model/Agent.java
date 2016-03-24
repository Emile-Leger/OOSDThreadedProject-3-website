package Model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Emile on 3/7/16.
 */
public class Agent implements Cloneable
{

    public static final String TableName = "agents";

    /**
    Constructor with each field provided
    */
    public Agent(Integer agentId, String agtFirstName, String agtMiddleInitial, String agtLastName,
                 String agtBusPhone, String agtEmail, String agtPosition, Integer agencyId)
    {
        this.AgentId = agentId;
        this.AgtFirstName = agtFirstName;
        this.AgtLastName = agtLastName;
        this.AgtMiddleInitial = agtMiddleInitial;
        this.AgtBusPhone = agtBusPhone;
        this.AgtEmail = agtEmail;
        this.AgtPosition = agtPosition;
        this.AgencyId = agencyId;
    }
    public Agent() { }

    /**
    Data Access methods
    */

    public static Agent getById(int AgentId)
    {
        HashMap join = new HashMap();
        join.put("AgentId",AgentId);
        Factory factory = new Factory(Agent.class);
        factory.getSelectWhere(join);
        Agent agent = (Agent) factory.makeEntity().firstElement();
        return agent;
    }

    public static Vector<Agent> getAll()
    {
        Factory factory = new Factory(Agent.class);
        factory.getSelectAll();
        Vector agents = factory.makeEntity();
        return agents;
    }

    public static Integer update(Agent oldBusted, Agent newHotness)
    {
        Factory factory = new Factory(Agent.class);
        return factory.update(oldBusted,newHotness);
    }

    public static int add(Agent agent)
    {
        Factory factory = new Factory(Agent.class);
        return factory.Deconstruct(agent);
    }

    public Agent clone(){
        try
        {
            return (Agent) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
    Agent fields, with Get Set methods
     */
    @Ignore
    private Integer AgentId;
    public void setAgentId(Integer agentId) { AgentId = agentId; }
    public int getAgentId() { return AgentId; }

    private String AgtFirstName;
    public String getAgtFirstName() { return AgtFirstName; }
    public void setAgtFirstName(String agtFirstName) { AgtFirstName = agtFirstName; }

    private String AgtMiddleInitial;
    public String getAgtMiddleInitial() { return AgtMiddleInitial; }
    public void setAgtMiddleInitial(String agtMiddleInitial) { AgtMiddleInitial = agtMiddleInitial; }

    private String AgtLastName;
    public String getAgtLastName() { return AgtLastName; }
    public void setAgtLastName(String agtLastName) { AgtLastName = agtLastName; }

    private String AgtBusPhone;
    public String getAgtBusPhone() { return AgtBusPhone; }
    public void setAgtBusPhone(String agtBusPhone) { AgtBusPhone = agtBusPhone; }


    private String AgtEmail;
    public String getAgtEmail() { return AgtEmail; }
    public void setAgtEmail(String agtEmail) { AgtEmail = agtEmail; }

    private String AgtPosition;
    public String getAgtPosition() { return AgtPosition; }
    public void setAgtPosition(String agtPosition) { AgtPosition = agtPosition; }

    private Integer AgencyId;
    public int getAgencyId() { return AgencyId; }
    public void setAgencyId(Integer agencyId) { AgencyId = agencyId; }

    private Boolean isActive;
    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }
}
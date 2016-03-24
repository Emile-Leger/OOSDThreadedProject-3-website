package Model;


import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by user1 on 3/9/16.
 */
public class Booking
{
    public static final String TableName = "bookings";
    /*
    Constructors
     */
    public Booking(Integer agentID, Date bookingDate, Integer bookingId, String bookingNo,
                   Integer customerId, String feeId, Integer packageId, Integer travelerCount, String tripTypeId)
    {
        AgentID = agentID;
        BookingDate = bookingDate;
        BookingId = bookingId;
        BookingNo = bookingNo;
        CustomerId = customerId;
        FeeId = feeId;
        PackageId = packageId;
        TravelerCount = travelerCount;
        TripTypeId = tripTypeId;
    }
    public Booking() { }

    /*
    Data Access Methods
     */

    public static Booking getById(int BookingId)
    {
        HashMap join = new HashMap();
        join.put("BookingId",BookingId);
        Factory factory = new Factory(Booking.class);
        factory.getSelectWhere(join);
        Booking booking = (Booking) factory.makeEntity().firstElement();
        return booking;
    }

    public static int add(Booking booking)
    {
        Factory factory = new Factory(Booking.class);
        return factory.Deconstruct(booking);
    }

    public static Vector<Booking> getAll()
    {
        Factory factory = new Factory(Booking.class);
        factory.getSelectAll();
        Vector bookings = factory.makeEntity();
        return bookings;
    }
    /**
    Fields with Get Set Methods
     */
    private int AgentID;
    public int getAgentID() { return AgentID; }
    public void setAgentID(int agentID) { AgentID = agentID; }

    private Date BookingDate;
    public Date getBookingDate() { return BookingDate; }
    public void setBookingDate(Date bookingDate) { BookingDate = bookingDate; }
    @Ignore
    private int BookingId;
    public int getBookingId() { return BookingId; }
    public void setBookingId(int bookingId) { BookingId = bookingId; }

    private String BookingNo;
    public String getBookingNo() { return BookingNo; }
    public void setBookingNo(String bookingNo) { BookingNo = bookingNo; }

    private int CustomerId;
    public int getCustomerId() { return CustomerId; }
    public void setCustomerId(int customerId) { CustomerId = customerId; }

    private String FeeId;
    public String getFeeId() { return FeeId; }
    public void setFeeId(String feeId) { FeeId = feeId; }

    private int PackageId;
    public int getPackageId() { return PackageId; }
    public void setPackageId(int packageId) { PackageId = packageId; }

    private int TravelerCount;
    public int getTravelerCount() { return TravelerCount; }
    public void setTravelerCount(int travelerCount) { TravelerCount = travelerCount; }

    private String TripTypeId;
    public String getTripTypeId() { return TripTypeId; }
    public void setTripTypeId(String trypTypeId) { TripTypeId = TripTypeId; }



















}

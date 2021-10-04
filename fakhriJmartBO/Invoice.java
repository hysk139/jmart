package fakhriJmartBO;
import java.util.Date;
import java.util.ArrayList;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public enum Status{
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
        
    }
    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
        
    }
    
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = 1;
    }
    public class Record{
        public Status status;
        public Date date;
        public String message;
        
        public ArrayList<Record> history;
    }
    @Override
    public boolean read(String content){
        return false;
    }
    
    public abstract double getTotalPay();
}

package fakhriJmartBO;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Transaction implements FileParser
{
    // instance variables - replace the example below with your own
    public int paymentId;
    public String desc;

    public Complaint(int id, Payment payment, String desc)
    {
        super(id, 0, 0);
        this.desc = desc;
        
    }
    
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc){
        super(id, buyerId, storeId);
        this.desc = desc;
        this.paymentId = paymentId;
    }
    @Override
    public boolean read(String content){
        return false;
    }
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Transaction perform() {
        return null;
    }

    
}

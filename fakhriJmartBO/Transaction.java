package fakhriJmartBO;


/**
 * Abstract class Transaction - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Transaction extends Recognizable
{
    public enum Rating
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;
    
    protected Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    protected Transaction(int id, Account buyer, int storeId){
        super(id);
        this.storeId = storeId;
    }
    
    public abstract boolean validate();
    public abstract Transaction perform();
}

package fakhriJmartBO;
import java.util.Date;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{


    public static void main(String[] args) 
    {
        System.out.println(Shipment.Duration.SAME_DAY.getEstimatedArrival(new Date()));
        Store store = new Store(69, "Mechanical Keyboard", "Jalan Asia Afrika", "0812696969");
        System.out.println(store.validate());
    }
    
    
    public static Product createProduct()
    {
        return null;
    }
    public static Coupon createCoupun()
    {
        return null;
    }
    public static Duration createDuration()
    {
        return null;
    }


}

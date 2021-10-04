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
        Account account = new Account(1, "Fakhri", "ahmad.fakhri91@ui.ac.id", "Csgo1234");
        System.out.println(account.validate());
        Complaint complaint = new Complaint(7, "Kena delay");
        System.out.println(complaint.toString());
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

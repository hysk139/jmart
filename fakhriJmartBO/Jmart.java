package fakhriJmartBO;


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
         
        
    }
    
    public static int getPromo()
    {
        return 0;
    }
    
    public static String getCustomer()
    {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after)
    {
        
        if (before < after){
            return 0.0f;
        }
        float castedBefore = (float) before;
        float castedAfter = (float) after;
        return ((castedBefore-castedAfter)/castedBefore)*100;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {
        if (discountPercentage > 100.0f){
            return 0;
        }
        return (int) (price * (100-discountPercentage) / 100);
    }
    
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        return (int) (discountedPrice/((100-discountPercentage)/100));
    }
    
    public static  float getCommissionMultiplier()
    {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price)
    {
       return (int) (price * 1.05f); 
    }
    
    public static int getAdminFee(int price) 
    {
        return (int) (price * 0.05f);
    }
    
    public static Product create(){
       return null;
    }
    
    public static Product createProduct()
    {
        
        return null;
    }
    public static Coupon createCoupun()
    {
        return null;
    }
    public static ShipmentDuration createShipmentDuration()
    {
        return new ShipmentDuration(ShipmentDuration.INSTANT, ShipmentDuration.SAME_DAY);
    }


}

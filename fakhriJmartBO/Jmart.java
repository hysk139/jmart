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
        
        System.out.println("Promo = "+ getPromo());
        System.out.println("Customer = " + getCustomer());
        System.out.println("Discount percentage for 1000 to 900 = "+ getDiscountPercentage(1000,900));
        System.out.println("Discounted price for 1000 at 10% = "+ getDiscountedPrice(1000, 10.0f));
        System.out.println("Get Original Price for 900 at 10% = " + getOriginalPrice(900,10.0f));
        System.out.println("Commission multiplier = "+ getCommissionMultiplier());
        System.out.println("Adjusted price for 1000 = " + getAdjustedPrice(1000));
        System.out.println("Admin fee for 1000 = " + getAdminFee(1000));
        
        Product RTX3090 = create();
        System.out.println("Product ID = " + RTX3090.id);
        System.out.println("Product name = " + RTX3090.name);
        System.out.println("Product weight = " + RTX3090.weight);
        System.out.println("Product Used? = " + RTX3090.conditionUsed);
        System.out.println("Product price = " + String.format("%.2f", RTX3090.priceTag.price));
        System.out.println("Product discount = " + RTX3090.priceTag.discount);
        System.out.println("Product category = " + RTX3090.category);
        System.out.println("Product rating = " + RTX3090.rating.getAverage());
        
        
        
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
        Product newProd = new Product("RTX 3090", 2, false, (new PriceTag(25000000L)), ProductCategory.GAMING);
        return newProd;
    }
    


}

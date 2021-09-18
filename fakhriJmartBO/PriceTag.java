package fakhriJmartBO;



public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
    public PriceTag(double price){
        this.price = price;
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
        return (getDiscountedPrice()+getAdminFee());
    }
    
    private double getDiscountedPrice(){
        if (discount >= 100){
            return 0;
        }
        
        return (this.price * (1-discount));
    }
    
    public double getAdminFee(){
        if (getDiscountedPrice() < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        return (getDiscountedPrice() * (1-COMMISSION_MULTIPLIER));
    }
}

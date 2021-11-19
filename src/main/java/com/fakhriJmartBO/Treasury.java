package com.fakhriJmartBO;



public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
   
    
    public static double getAdjustedPrice(double price, double discount){
    	return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
    
    private static double getDiscountedPrice(double price, double discount){
        if (discount >= 100){
            return 0;
        }
        
        return (price * (1-discount));
    }
    
    public static double getAdminFee (double price, double discount){
        if (getDiscountedPrice(price, discount) < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        return (getDiscountedPrice(price, discount) * (1-COMMISSION_MULTIPLIER));
    }
}

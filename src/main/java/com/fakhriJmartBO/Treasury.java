package com.fakhriJmartBO;


/**
 * Class Treasury which is the class for using discounts and admin prices
 *
 * @author Ahmad Fakhri
 * 
 */
public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
   
    
    /**
     * @param price
     * @param discount
     * @return the adjusted price
     */
    public static double getAdjustedPrice(double price, double discount){
    	return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
    
    /**
     * @param price
     * @param discount
     * @return the discounted price
     */
    private static double getDiscountedPrice(double price, double discount){
        if (discount >= 100){
            return 0;
        }
        
        return (price * (1-discount));
    }
    
    /**
     * @param price
     * @param discount
     * @return the admin fees
     */
    public static double getAdminFee (double price, double discount){
        if (getDiscountedPrice(price, discount) < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        return (getDiscountedPrice(price, discount) * (1-COMMISSION_MULTIPLIER));
    }
}

package com.fakhriJmartBO;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.Calendar;

/**
 * Class Shipment which is the class for creating shipment plans for each product
 *
 * @author Ahmad Fakhri
 * 
 */

public class Shipment
{
    public String address ;
    public int cost;
    public String receipt;
    public byte plan;
    public static final Plan INSTANT = new Plan ((byte) (1<<0));
    public static final Plan SAME_DAY = new Plan ((byte)(1<<1));
    public static final Plan NEXT_DAY = new Plan ((byte)(1<<2));
    public static final Plan REGULER =  new Plan ((byte)(1<<3));
    public static final Plan KARGO =  new Plan ((byte) (1<< 4));
    public static final SimpleDateFormat ESTIMATION_FORMAT 
    = new SimpleDateFormat("E MMMM dd yyyy");
    
    /**
     * @param address
     * @param cost
     * @param plan
     * @param receipt
     * Constructor
     */
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }
    
    /**
     * @author Ahmad Fakhri
     *	Inner class plan
     */
    static class Plan{
        public final byte bit;
        private Plan(byte bit)
        {
            this.bit = bit;
        }
    }
    
    /**
     * @param reference
     * @return the estimated time of arrival for invoice
     */
    public String getEstimatedArrival (Date reference){
        if (this.plan == INSTANT.bit || this.plan == SAME_DAY.bit){
            return ESTIMATION_FORMAT.format(reference);
        }
        
        else if (this.plan == NEXT_DAY.bit){
            return ESTIMATION_FORMAT.format(reference.getDay() + 1);
        }
        
        else if (this.plan == REGULER.bit){
            return ESTIMATION_FORMAT.format(reference.getDay() + 2);
        }
        else{
            return ESTIMATION_FORMAT.format(reference.getDay() + 5); 
        }
    }
    
    /**
     * @param reference
     * @return checking duration
     */
    public boolean isDuration(Plan reference){
        if((plan & reference.bit) != 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * @param object
     * @param reference
     * @return checking duration
     */
    public static boolean isDuration(byte object, Plan reference){
        if((object & reference.bit) != 0){
            return true;
        }
        else{
            return false;
        }
    
    }
}



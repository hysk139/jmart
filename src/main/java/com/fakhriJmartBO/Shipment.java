package com.fakhriJmartBO;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment 
{
    public String address;
    public int cost;
    public String receipt;
    public byte plan;
    public SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1<<0)); //0000 0001
    public static final Plan SAME_DAY = new Plan((byte)(1<<1)); //0000 0010
    public static final Plan NEXT_DAY = new Plan((byte)(1<<2)); //0000 0100
    public static final Plan REGULER = new Plan((byte)(1<<3)); //0000 1000
    public static final Plan KARGO = new Plan((byte)(1<<4)); //0001 0000
    
    
    static class Plan
    {
        public final byte bit;
        private Plan(byte bit)
        {
            this.bit = bit;
        }
    }
    
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }
    
    public String getEstimatedArrival(Date reference){
        if (plan == INSTANT.bit || plan == SAME_DAY.bit){
            return ESTIMATION_FORMAT.format(reference);
        }
        else if (plan == NEXT_DAY.bit){
            return ESTIMATION_FORMAT.format(reference.getDay() + 1);
        }
        else if (plan == REGULER.bit){
            return ESTIMATION_FORMAT.format(reference.getDay() + 2);
        }
        else {
            return ESTIMATION_FORMAT.format(reference.getDay() + 3);
        }
    }
    
    public boolean isDuration(Plan reference)
    {
        if((plan & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuration(byte object, Plan reference)
    {
        if((object & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }

    

    

    
    
}
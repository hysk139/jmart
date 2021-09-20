package fakhriJmartBO;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration (1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration (1 << 1);
    public static final ShipmentDuration NEXT_DAY= new ShipmentDuration (1 << 2);
    public static final ShipmentDuration REGULER= new ShipmentDuration (1 << 3);
    public static final ShipmentDuration KARGO= new ShipmentDuration (1 << 4);
    private final int bit;
    
    private ShipmentDuration(int bit){
        this.bit = bit;
    }
    
    public ShipmentDuration(int... args){
        int flag = 0;
        for (int i:args){
            flag = flag|i;
        };
        
        this.bit = flag;
    }
    
    public boolean isDuration(ShipmentDuration reference){
        return false;
    }
    
    
    
    

}
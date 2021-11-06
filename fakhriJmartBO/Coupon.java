package fakhriJmartBO;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon extends Serializable 
{
    public enum Type{
        DISCOUNT,
        REBATE
    }
    
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum){
        
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed(){
        return false;
    }
    
    public boolean canApply(double price, double discount){
        if (Treasury.getAdjustedPrice(price, discount)>= minimum && this.used==false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(double price, double discount){
        this.used = true;
        if (type == Type.DISCOUNT){
            if (cut >= 100){
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * (100 / 100));
            }
            else if (cut <= 0){
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * (0 / 100)); 
            }
            else{
                return (Treasury.getAdjustedPrice(price, discount) - Treasury.getAdjustedPrice(price, discount) * (cut / 100));
            }
        }
        else {
            return (Treasury.getAdjustedPrice(price, discount) * this.cut / 100);
        }
    }
    
    
    
}

package fakhriJmartBO;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;

    public class MultiDuration{
        public byte bit;
        public MultiDuration(Duration... args){
            byte bits = 0;
            for(Duration arg : args){
                bits |= arg.bit;
            }
            this.bit = bits;
        }
        public boolean isDuration(Duration reference)
        {
            if((bit & reference.bit) != 0){
                return true;
            }else{
                return false;
            }
        }
    }

    public static class Duration
    {
        public static final Duration INSTANT = new Duration((byte)(1<<0)); //0000 0001
        public static final Duration SAME_DAY = new Duration((byte)(1<<1)); //0000 0010
        public static final Duration NEXT_DAY = new Duration((byte)(1<<2)); //0000 0100
        public static final Duration REGULER = new Duration((byte)(1<<3)); //0000 1000
        public static final Duration KARGO = new Duration((byte)(1<<4)); //0001 0000
        public byte bit;
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E dd MMM yyyy");
        

        private Duration(byte bit)
        {
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference){
            if (this.bit == INSTANT.bit || this.bit == SAME_DAY.bit){
                return ESTIMATION_FORMAT.format(reference);
            }
            else if (this.bit == NEXT_DAY.bit){
                return ESTIMATION_FORMAT.format(reference.getDay() + 1);
            }
            else if (this.bit == REGULER.bit){
                return ESTIMATION_FORMAT.format(reference.getDay() + 2);
            }
            else {
                return ESTIMATION_FORMAT.format(reference.getDay() + 3);
            }
        }
    }

    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }

    @Override
    public boolean read(String content) {
        return false;
    }
}
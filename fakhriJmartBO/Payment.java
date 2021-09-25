package fakhriJmartBO;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Transaction implements FileParser
{
    // instance variables - replace the example below with your own
    public int paymentId;
    public ShipmentDuration shipmentDuration;
    
    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration){
        
    }
    
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration){
        
    }
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Transaction perform() {
        return null;
    }
    
}

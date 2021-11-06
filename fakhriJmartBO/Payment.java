package fakhriJmartBO;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice 
{
    // instance variables - replace the example below with your own
    public int productCount;
    public Shipment shipment;
    

    public Payment(int buyerId, int storeId, int productCount, Shipment shipment){
        super(buyerId, storeId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    

	@Override
    public double getTotalPay(){
        return 0.0;
    }
    
}

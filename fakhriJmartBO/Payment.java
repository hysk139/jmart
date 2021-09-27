package fakhriJmartBO;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice implements Transactor
{
    // instance variables - replace the example below with your own
    public int productCount;
    public Shipment shipment;
    

    public Payment(int id, int buyerId, int storeId, int productCount, Shipment shipment){
        super(id, buyerId, storeId);
        this.productCount = productCount;
    }
    @Override
    public boolean validate() {
        return false;
    }
    @Override
    public Transactor perform() {
        return null;
    }
    public double getTotalPay(){
        return 0;
    }
    
}

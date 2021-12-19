package com.fakhriJmartBO;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class Payment which is the class for users payments and its methods
 *
 * @author Ahmad Fakhri
 * 
 */
public class Payment extends Invoice
{
    public int productCount;
    public Shipment shipment;
    public ArrayList<Record> history = new ArrayList<>();
    
    /**
     * @param buyerId
     * @param productId
     * @param productCount
     * @param shipment
     */
    public Payment(int buyerId, int productId, int productCount,Shipment shipment){
        super(buyerId, productId);
        this.shipment = shipment;
        this.productCount = productCount;
    }
    
    /**
     * @author Ahmad Fakhri
     * Class record for status and message
     */
    public  static class Record {
        public final Date date;
        public String massage;
        public Status status;


        public Record( Status status, String massage) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = status;
            this.massage = massage;
        }

    }
    
    /**
     *for getting total pay
     */
    @Override
    public double getTotalPay(Product product){
        return (productCount * Treasury.getAdjustedPrice(product.price, product.discount));
    }

}
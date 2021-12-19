package com.fakhriJmartBO;
import java.util.Date;

import com.fakhriJmartBO.dbjson.Serializable;

import java.util.ArrayList;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

/**
 * Class Invoice that users use to have the invoice of its transaction history
 *
 * @author Ahmad Fakhri
 * 
 */
public abstract class Invoice extends Serializable
{
   
   public int buyerId;
   public int complaintId;
   public final Date date;
   public int productId;
   public Rating rating;
   
   public enum Rating {
        NONE,
        GOOD,
        BAD,
        NEUTRAL;       
    }

   public enum Status {
        CANCELLED,
        COMPLAINT,
        DELIVERED,
        FAILED,
        FINISHED,
        ON_DELIVERY,
        ON_PROGRESS,
        WAITING_CONFIRMATION; 
   }
    
   /**
 * @param buyerId
 * @param productId
 * Constructor for Invoice
 */
protected Invoice(int buyerId, int productId){
	   this.buyerId = buyerId;
       this.productId = productId;
       this.date = new Date();
       this.rating = Rating.NONE;
       this.complaintId = -1;
    }
    
   public abstract double getTotalPay(Product product);
}

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
public abstract class Invoice extends Serializable
{
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public final Date date;

    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED,
        DELIVERED
    }

    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public abstract double getTotalPay(Product product);

}

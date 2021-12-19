package com.fakhriJmartBO;
import java.util.Date;

import com.fakhriJmartBO.dbjson.Serializable;

import java.text.SimpleDateFormat;


/**
 * Class Complaint that users use to describe the complaint
 *
 * @author Ahmad Fakhri
 * 
 */
public class Complaint extends Serializable 
{
    // instance variables - replace the example below with your own
    public String desc;
    public final Date date;
    /**
     * @param id
     * @param desc
     * Constructor for complaint
     */
    public Complaint(int id, String desc)
    {
        
        this.desc = desc;
        this.date = new Date();
    }
    
    
   
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Complaint :\nDate: " + this.date + "\nDesc: " + this.desc;
    }
}
    


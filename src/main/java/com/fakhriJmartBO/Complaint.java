package com.fakhriJmartBO;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable 
{
    // instance variables - replace the example below with your own
    public String desc;
    public final Date date;
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
    


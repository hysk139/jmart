package fakhriJmartBO;
import java.util.Date;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    // instance variables - replace the example below with your own
    public String desc;
    public Date date;
    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        this.date = new Date();
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    

    
}

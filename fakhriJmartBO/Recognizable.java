package fakhriJmartBO;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable <Recognizable>
{
    public final int id;
    protected Recognizable(int id)
    {
        // initialise instance variables
        this.id = id;
    }
    
    @Override 
    public int compareTo(Recognizable other) {
    	return Integer.compare(id, other.id);
    }
    
    public boolean equals(Object i)
    {
        if (i instanceof Recognizable){
            Recognizable upcasted = (Recognizable) i;
            if(upcasted.id == this.id)
            {
                return true;
            }
            else{
                return false;
            }
        } 
        else{
            return false;
        }
    }
    
    public boolean equals(Recognizable r){
        if (r.id == this.id){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static<T extends Recognizable> int setClosingId(Class<T> clazz, int id) {
    	return 0;
    }
    public static<T extends Recognizable> int getClosingId(Class<T> clazz) {
    	return 0;
    }

    
}

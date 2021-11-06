package fakhriJmartBO;
import java.util.HashMap;
import javax.print.attribute.standard.MediaSize.Other;

/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serializable implements Comparable <Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    protected Serializable()
    {
        // initialise instance variables
    	Class x = getClass();
        if(mapCounter.get(x) == null){
            mapCounter.put(x,0);
        }else {
            mapCounter.put(x, mapCounter.get(x) + 1);
        }
        this.id =mapCounter.get(x);
    }
    
    @Override 
    public int compareTo(Serializable other) {
    	return Integer.compare(id, other.id);
    }
    
    public boolean equals(Object i)
    {
        if (i instanceof Serializable){
        	Serializable upcasted = (Serializable) i;
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
    
    public boolean equals(Serializable r){
        if (r.id == this.id){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) {
    	return mapCounter.put(clazz, id);
    }
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) {
    	return mapCounter.get(clazz.getClass());
    }

    
}

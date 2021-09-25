package fakhriJmartBO;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Recognizable
{
    public final int id;
    protected Recognizable(int id)
    {
        // initialise instance variables
        this.id = id;
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

    
}

package fakhriJmartBO;


/**
 * Write a description of interface FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{
    default Object write(){
        return null;
    }
    public boolean read(String content);
    public static Object newInstance(String content){
        return null;
    }
}

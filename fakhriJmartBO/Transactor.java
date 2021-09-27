package fakhriJmartBO;


/**
 * Abstract class Transaction - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public interface Transactor
{
    
    public boolean validate();
    public Transactor perform();
}

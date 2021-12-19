package com.fakhriJmartBO;
import java.util.regex.*;

/**
 * Class Store which is the class for stores inside accounts in jmart
 *
 * @author Ahmad Fakhri
 * 
 */
public class Store
{
    // instance variables - replace the example below with your own
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public static final String REGEX_NAME = "^[A-Z]((?!\\s{2}).)*.{4,20}$";
    
    /**
     * @param name
     * @param address
     * @param phoneNumber
     * @param balance
     * Constructor for store
     */
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.balance = balance;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * @param account
     * @param name
     * @param address
     * @param phoneNumber
     *
     * Constructor for store
     */
    public Store(Account account, String name, String address, String phoneNumber)
    {
        
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * @return true or false for validaring phone number and name pattern
     */
    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);
        Matcher matcherName = patternName.matcher(this.name);
        if (matcherPhone.find() && matcherName.find()){
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    @Override
    public String toString(){
        return "name: " + this.name + "\naddress: " + this.address + "\nphoneNumber: " + this.phoneNumber;
    }

    
}

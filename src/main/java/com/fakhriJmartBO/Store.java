package com.fakhriJmartBO;
import java.util.regex.*;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.balance = balance;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber)
    {
        
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
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

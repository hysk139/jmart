package com.fakhriJmartBO;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fakhriJmartBO.dbjson.Serializable;

/**
 * Class Account that users use to login to the app and use the applications functionalities
 *
 * @author Ahmad Fakhri
 * 
 */
public class Account extends Serializable 
{
    // instance variables - replace the example below with your own
	public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;
    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    
    /**
     * @param name
     * @param email
     * @param password
     * @param balance
     * Constructor for account
     */
    public Account(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    /**
     * @return true or false to validate the validity of the email or password pattern
     */
    public boolean validate() {
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher emailMatcher = emailPattern.matcher(this.email);
        Matcher passwordMatcher = passwordPattern.matcher(this.password);
        if(emailMatcher.find() && passwordMatcher.find()) {
            return true;
        }
        else {
            return false;
        }
    }

    
    @Override
    public String toString() {
        return "name: " + this.name + 
            "\nemail: " + this.email + 
            "\npassword: " + this.password;
    }
   
}

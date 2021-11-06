package fakhriJmartBO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable 
{
    // instance variables - replace the example below with your own
    public String name;
    public String email;
    public String password;
    public double balance;
    public static final String REGEX_EMAIL = "([A-Za-z0-9+&_*~]+(?:\\.[a-zA-Z0-9&_*~]+)*@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public Account(String name, String email, String password, double balance)
    {
        
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
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
    public String toString(){
        return "name: " + this.name + "\nemail: " + this.email + "\npassword: " + this.password;
    }
   
}

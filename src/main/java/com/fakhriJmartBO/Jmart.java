package com.fakhriJmartBO;

import java.util.List;

import com.fakhriJmartBO.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





/**
 * Class Jmart which is the main class for driving the application
 *
 * @author Ahmad Fakhri
 * 
 */
@SpringBootApplication
public class Jmart
{
	
    public static long DELIVERED_LIMIT_MS = 1;
    public static long ON_DELIVERY_LIMIT_MS = 1;
    public static long ON_PROGRESS_LIMIT_MS = 1;
    public static long WAITING_CONF_LIMIT_MS = 1;
	
	class Country{
		public String name;
		public int population;
		public List<String> listOfStates;
	}
	
	
    /**
     * @param args
     * Main function in this project
     */
    public static void main(String[] args) 
    {
        
    	
    	JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

       
    }
}
    
    
    




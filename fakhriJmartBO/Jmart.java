package fakhriJmartBO;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;




/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{

	class Country{
		public String name;
		public int population;
		public List<String> listOfStates;
	}
	
	
    public static void main(String[] args) 
    {
        
       
    	try{
    		   String filepath = "C:/Users/Ahmad Fakhri/Documents/Kuliah/SMT 5/Praktikum OOP/Praktikum/jmart/account.json" ;

    		   JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
    		   tableAccount.add(new Account("nama", "email", "password", 100));
    		   tableAccount.writeJson();
    		   
    		   //tableAccount = new JsonTable<>(Account.class, filepath);
    		   tableAccount.forEach(account -> System.out.println(account.toString()));
    		  }

    		  catch (Throwable t)
    		  {
    		   t.printStackTrace();
    		  }
        
        
    }
    
    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
    
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
    	List<Product> filtered = new ArrayList<>();
    	for (int c = 0; c < list.size(); c++) {
    		if(list.get(c).category == category) {
    			filtered.add(list.get(c));
    		}
    	}
    	return filtered;
    }
    
    
    
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> filtered = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(minPrice <= 0.0){
                if(list.get(i).price <= maxPrice){
                	filtered.add(list.get(i));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(i).price >= minPrice){
                	filtered.add(list.get(i));
                }
            }else{
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                	filtered.add(list.get(i));
                }
            }
        }
        return filtered;    
    }
    
    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        return list.stream().filter(q -> pred.predicate(q)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = q -> (q.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = q -> (q.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }
    
    
    
    


}

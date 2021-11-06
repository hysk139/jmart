package fakhriJmartBO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
            // sesuaikan argument method read sesuai dengan lokasi resource
            List<Product> list = read("C:/Users/Ahmad Fakhri/Documents/Kuliah/SMT 5/Praktikum OOP/Praktikum/jmart/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 98000.0, 0.0);
            filtered.forEach(product -> System.out.println(product.price));
        }catch (Throwable t)
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
    
    


}

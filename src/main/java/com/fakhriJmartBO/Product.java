package com.fakhriJmartBO;

import com.fakhriJmartBO.dbjson.Serializable;

/**
 * Class Product which is the class for each product in jmart 
 *
 * @author Ahmad Fakhri
 * 
 */

public class Product extends Serializable 
{
    //private static int idCounter;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public double discount;
    public ProductCategory category;
    public double price;
    public int accountId;
    public byte shipmentPlans;
    
    
    /**
     * @param accountId
     * @param name
     * @param weight
     * @param conditionUsed
     * @param price
     * @param discount
     * @param category
     * @param shipmentPlans
     * Constructor for product
     */
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount,ProductCategory category, byte shipmentPlans){
        
    	this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;;
        
        
    }
    
  
    
    
    @Override
    public String toString(){
        return("Name: " + name + "\nWeight: " + weight + "\nconditionUsed: " + conditionUsed + 
               "\nprice: " + price + "\ncategory: " + category + "\ndiscount: " + discount + "\naccountId: " + accountId);
    }
    

    
}

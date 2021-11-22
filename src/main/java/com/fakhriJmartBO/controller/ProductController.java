package com.fakhriJmartBO.controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.Account;
import com.fakhriJmartBO.Algorithm;
import com.fakhriJmartBO.Product;
import com.fakhriJmartBO.ProductCategory;
import com.fakhriJmartBO.dbjson.JsonAutowired;
import com.fakhriJmartBO.dbjson.JsonTable;




@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
	
    @JsonAutowired(filepath = "C:\\Users\\Ahmad Fakhri\\Documents\\Kuliah\\SMT 5\\Praktikum OOP\\Praktikum\\jmart\\src\\main\\java\\com\\randomProductList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	
	@Override
	public JsonTable<Product> getJsonTable() {
		// TODO Auto-generated method stub
		return productTable;
	}
	
	
	@PostMapping("/create")
	Product create
	(
		@RequestParam int accountId,
		@RequestParam String name,
		@RequestParam int weight,
		@RequestParam boolean conditionUsed,
		@RequestParam double price,
		@RequestParam double discount,
		@RequestParam ProductCategory category,
		@RequestParam byte shipmentPlans
		
	)
	{
		AccountController control1 = new AccountController();
		JsonTable<Account> accountTable = control1.getJsonTable();
		for(Account account : accountTable){
            if(account.id == accountId && account.store != null){
            	productTable.add(new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans));
                return new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
            }
        }
        return null;
	}
	

    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }
    
    @GetMapping("/getFiltered")
    @ResponseBody
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        List<Product> filtered = null;
        for (Product each : productTable) {
            if (each.accountId == accountId)
                if (each.name.contains(search))
                    if (minPrice <= each.price)
                        if (maxPrice >= each.price)
                            if (each.category == category)
                            	filtered.add(each);
        }
        return filtered;
    }




}

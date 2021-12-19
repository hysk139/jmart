package com.fakhriJmartBO.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.Account;
import com.fakhriJmartBO.Algorithm;
import com.fakhriJmartBO.Payment;
import com.fakhriJmartBO.Predicate;
import com.fakhriJmartBO.Product;
import com.fakhriJmartBO.ProductCategory;
import com.fakhriJmartBO.dbjson.JsonAutowired;
import com.fakhriJmartBO.dbjson.JsonTable;




/**
 * @author Ahmad Fakhri
 * This class is used as an API to use products functionalities 
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
	
    @JsonAutowired(filepath = "C:\\Users\\Ahmad Fakhri\\Documents\\Kuliah\\SMT 5\\Praktikum OOP\\Praktikum\\jmart\\src\\main\\java\\com\\productList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	
	/**
	 *@return product table
	 */
	@Override
	public JsonTable<Product> getJsonTable() {
		// TODO Auto-generated method stub
		return productTable;
	}
	
	
	/**
	 * @param accountId
	 * @param name
	 * @param weight
	 * @param conditionUsed
	 * @param price
	 * @param discount
	 * @param category
	 * @param shipmentPlans
	 * @return
	 */
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
	

	
    /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }
    
    /**
     * @param page
     * @param pageSize
     * @param search
     * @param minPrice
     * @param maxPrice
     * @param category
     * @return
     */
    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam(defaultValue="0")  int page, @RequestParam(defaultValue="5")  int pageSize,
                                     @RequestParam  String search,
                                     @RequestParam  int minPrice, @RequestParam  int maxPrice,
                                     @RequestParam  ProductCategory category)
    {
        Predicate<Product> pred = p -> ((p.name.toLowerCase().contains(search.toLowerCase())) && (p.price >= minPrice && p.price <= maxPrice) && (p.category == category));
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, pred);
    }
    

    /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Product> getMyProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Product> productList = new ArrayList<>();
        List<Payment> paymentList = Algorithm.<Payment>paginate(PaymentController.paymentTable, page, pageSize, p -> p.buyerId == id);
        for(Product product : getJsonTable()){
            for(Payment payment : paymentList){
                if(payment.productId == product.id){
                    productList.add(product);
                }
            }
        }
        return Algorithm.<Product>paginate(productList, page, pageSize, e -> true);
    }
    
    /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/page")
    @ResponseBody List<Product> getProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
		List<Product> productList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Product product : ProductController.productTable){
                for(Payment payment : PaymentController.paymentTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        productList.add(product);
                    }
                }
            }
        }
        return Algorithm.paginate(productList, page, pageSize, e->true);
    }




}

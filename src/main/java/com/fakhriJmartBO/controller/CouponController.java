package com.fakhriJmartBO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.Algorithm;
import com.fakhriJmartBO.Coupon;
import com.fakhriJmartBO.Predicate;
import com.fakhriJmartBO.dbjson.JsonAutowired;
import com.fakhriJmartBO.dbjson.JsonTable;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
	@JsonAutowired(value = Coupon.class, filepath = "C:\\Users\\Ahmad Fakhri\\Documents\\Kuliah\\SMT 5\\Praktikum OOP\\Praktikum\\jmart\\src\\main\\java\\com\\account.json")
    public static JsonTable<Coupon> couponTable;

    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @PathVariable int id
    ){
        Coupon coup = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        return coup.isUsed();
    }

    @GetMapping("/{id}/canApply")
    public boolean canApply(
    		@PathVariable int id, 
    		@PathVariable double price, 
    		@PathVariable double discount)
    {
        for(Coupon coupon : couponTable){
            if(coupon.id == id){
                return coupon.canApply(price, discount);
            }
        }
        return false;
    }
    
    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(
    		@PathVariable int page, 
    		@PathVariable int pageSize){
        Predicate<Coupon> pred = coupon -> !coupon.isUsed();
        return Algorithm.paginate(couponTable, page, pageSize, pred);
    }

    @Override
    public JsonTable<Coupon> getJsonTable() { return couponTable; }
}

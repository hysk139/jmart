package com.fakhriJmartBO.controller;

import com.fakhriJmartBO.dbjson.JsonTable;
import com.fakhriJmartBO.dbjson.Serializable;
import com.fakhriJmartBO.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface BasicGetController<T extends Serializable> {
    
	@GetMapping("/page")
    public default @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
		return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e -> true);
		
    }
	
	
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
    	return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable();
    
    
}
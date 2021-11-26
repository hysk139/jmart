package com.fakhriJmartBO.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.Algorithm;
import com.fakhriJmartBO.dbjson.JsonTable;
import com.fakhriJmartBO.dbjson.Serializable;

@RestController

public interface BasicGetController<T extends Serializable> {
    
    @GetMapping("/{id")
    public default T getById(@RequestParam("id") int id) {
        return Algorithm.<T>find(getJsonTable(), (i) -> i.id == id);
    }
    public abstract JsonTable<T> getJsonTable();
    
    @GetMapping("/page")
    public @ResponseBody default List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, i -> true);
    }
    
}
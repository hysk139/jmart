package com.fakhriJmartBO.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.ObjectPoolThread;
import com.fakhriJmartBO.Payment;
import com.fakhriJmartBO.dbjson.JsonAutowired;
import com.fakhriJmartBO.dbjson.JsonTable;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
	public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERIY_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;
    public static JsonTable<Payment> paymentTable;
    /*@JsonAutowired(filepath = "C:\\Users\\Ahmad Fakhri\\Documents\\Kuliah\\SMT 5\\Praktikum OOP\\Praktikum\\jmart\\src\\main\\java\\com\\randomPaymentList.json", value = Payment.class)
    public static ObjectPoolThread<Payment> poolThread;*/
    public static ObjectPoolThread<Payment> poolThread;
    
	@Override
	public JsonTable<Payment> getJsonTable() {
		// TODO Auto-generated method stub
		return null;
	}
	@PostMapping("/{id}/accept")
    boolean accept(int id){
        return false;
    }
    @PostMapping("/{id}/cancel")
    boolean cancel(int id){
        return false;
    }
    @PostMapping("/{id}/submit")
    boolean submit(int id){
        return false;
    }
    @PostMapping("/create")
    Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan){
        return null;
    }
    
    private static boolean timekeeper(Payment payment) {
        return false;
    }
    

}

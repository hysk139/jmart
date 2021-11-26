package com.fakhriJmartBO.controller;
import com.fakhriJmartBO.*;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.ObjectPoolThread;
import com.fakhriJmartBO.Payment;
import com.fakhriJmartBO.dbjson.JsonAutowired;
import com.fakhriJmartBO.dbjson.JsonTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
	public static final long DELIVERED_LIMIT_MS = 1;
	public static final long ON_DELIVERY_LIMIT_MS = 1;
	public static final long ON_PROGRESS_LIMIT_MS = 1;
	public static final long WAITING_CONF_LIMIT_MS = 1;
	
	@JsonAutowired(filepath = "C:\\Users\\Flex\\Documents\\Semester 5\\jmart\\src\\main\\java\\com\\randomPaymentList.json", value = Payment.class)
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>(PaymentController::timekeeper);

	
	@PostMapping("/{id}/accept")
	public boolean accept(@RequestParam int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "ON_PROGRESS"));
                    return true;
                }
            }
        }
		return false;
	}
	
	@PostMapping("/{id}/cancel")
	public boolean cancel(@PathVariable int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "CANCELLED"));
                    return true;
                }
            }
        }
		return false;
	}
	
	@PostMapping("/{id}/create")  
	public Payment create(
			@RequestParam int buyerId, 
			@RequestParam int productId, 
			@RequestParam int productCount, 
			@RequestParam String shipmentAddress, 
			@RequestParam byte shipmentPlan
	) {
        for(Account account : AccountController.accountTable){
            if(account.id == buyerId){
                for(Product product : ProductController.productTable){
                    if(product.accountId == productId){
                        Payment newPayment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        double totalPay = newPayment.getTotalPay(product);
                        if(account.balance >= totalPay){
                            account.balance -= totalPay;
                            newPayment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(newPayment);
                            poolThread.add(newPayment);
                            return newPayment;
                        }
                    }
                }
            }
        }
		return null;
	}
	    
	@PostMapping("/{id}/submit")  
	public boolean submit(@PathVariable int id, String receipt) {
		for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.ON_PROGRESS){
                    if(!payment.shipment.receipt.isBlank()){
                        payment.shipment.receipt = receipt;
                        payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
                        return true;
                    }
                }
            }
        }
        return false;
	}
	    
	private static boolean timekeeper(Payment payment) {
		if (payment.history.size() == 0) {
            return true;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();
            if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.DELIVERED;
                return true;
            } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
                record.status = Invoice.Status.FINISHED;
                return true;
            } else {
                return false;
            }
        }
    }

	@Override
	public JsonTable<Payment> getJsonTable() {
		// TODO Auto-generated method stub
		return paymentTable;
	}
	
	
}
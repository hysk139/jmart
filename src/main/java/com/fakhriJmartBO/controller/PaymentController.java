package com.fakhriJmartBO.controller;
import com.fakhriJmartBO.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fakhriJmartBO.ObjectPoolThread;
import com.fakhriJmartBO.Payment;
import com.fakhriJmartBO.dbjson.JsonAutowired;
import com.fakhriJmartBO.dbjson.JsonTable;

/**
 * @author Ahmad Fakhri
 * This class is used as an API to use payments functionalities 
 *
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 1000;
    public static final long ON_DELIVERY_LIMIT_MS = 1000;
    public static final long ON_PROGRESS_LIMIT_MS = 1000;
    public static final long WAITING_CONF_LIMIT_MS = 1000;
    public static @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\Ahmad Fakhri\\Documents\\Kuliah\\SMT 5\\Praktikum OOP\\Praktikum\\jmart\\src\\main\\java\\com\\payment.json")
    JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>(PaymentController::timekeeper);

    /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/page")
    @ResponseBody List<Payment> getInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Payment> paymentList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Payment payment : paymentTable){
                for(Product product : ProductController.productTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        paymentList.add(payment);
                    }
                }
            }
        }
        return Algorithm.paginate(paymentList, page, pageSize, e->true);
    }

    /**
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Payment> getMyInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        return Algorithm.<Payment>paginate(getJsonTable(), page, pageSize, p -> p.buyerId == id);
    }
    
    
    /**
     * @param id
     * @return
     */
    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id) {
        for(Payment paymentSingular : paymentTable){
            if(paymentSingular.id == id){
                if(paymentSingular.history.get(paymentSingular.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                	paymentSingular.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "ON_PROGRESS"));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param id
     * @return
     */
    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id) {
        for(Payment paymentSingular : paymentTable){
            if(paymentSingular.id == id){
                if(paymentSingular.history.get(paymentSingular.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                	paymentSingular.history.add(new Payment.Record(Invoice.Status.CANCELLED, "CANCELLED"));
                    return true;
                }
            }
        }
         return false;
    }

    /**
     * @param buyerId
     * @param productId
     * @param productCount
     * @param shipmentAddress
     * @param shipmentPlan
     * @return
     */
    @PostMapping("/create")
    Payment create(@RequestParam int buyerId, 
    				@RequestParam int productId, 
    				@RequestParam int productCount, 
    				@RequestParam String shipmentAddress, 
    				@RequestParam byte shipmentPlan) {
        for(Account account : AccountController.accountTable){
            if(account.id == buyerId){
                for(Product productSingular : ProductController.productTable){
                    if(productSingular.id == productId){
                        Payment newPayment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        double totalPay = newPayment.getTotalPay(productSingular);
                        if(account.balance >= totalPay){
                            account.balance -= totalPay;
                            newPayment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(newPayment);
                            poolThread.add(newPayment);
							/*
							 * System.out.println(productSingular.accountId); System.out.println(productId);
							 */
                            return newPayment;
                        }
                    }
                }
            }
        }
        return null;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * @param id
     * @param receipt
     * @return
     */
    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, String receipt) {
        for(Payment paymentSingular : paymentTable){
            if(paymentSingular.id == id){
                if(paymentSingular.history.get(paymentSingular.history.size() - 1).status == Invoice.Status.ON_PROGRESS){
                    if(!receipt.isBlank()){
                    	paymentSingular.shipment.receipt = receipt;
                    	paymentSingular.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param payment
     * @return
     */
    private static Boolean timekeeper(Payment payment) {
        if (payment.history.isEmpty()) {
            return false;
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
}
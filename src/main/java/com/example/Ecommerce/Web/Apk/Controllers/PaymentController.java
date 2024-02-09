package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Payment;
import com.example.Ecommerce.Web.Apk.Services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentServices paymentServices;
    public PaymentController(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }

    @PostMapping("/save")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentServices.savePayment(payment), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public List<Payment> getAllPayments(){
        return new ArrayList<Payment>(paymentServices.getAllPayments());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id")long id){
        return  new ResponseEntity<Payment>(paymentServices.getPaymentById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Payment> updatePaymentById(@PathVariable("id")long id,
                                                     @RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentServices.updatePaymentById(payment,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Payment> deletePaymentById(@PathVariable("id")long id){
        paymentServices.deletePaymentById(id);
        return new ResponseEntity<Payment>(HttpStatus.OK);
    }
}

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


    @PostMapping("/save")
    public ResponseEntity<Payment>savePayment(@RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentServices.save(payment),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Payment>getall(){
        return new ArrayList<>(paymentServices.getall());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Payment>getById(@PathVariable("id")int id){
        return new ResponseEntity<Payment>(paymentServices.getById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Payment>updateById(@PathVariable("id")int id,
                                             @RequestBody Payment payment){
        return new ResponseEntity<Payment>(paymentServices.updateById(payment,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Payment>deleteById(@PathVariable("id")int id){
        paymentServices.deleteById(id);
        return new ResponseEntity<Payment>(HttpStatus.OK);
    }
}

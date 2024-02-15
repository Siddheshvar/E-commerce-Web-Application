package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.OrderItems;
import com.example.Ecommerce.Web.Apk.Services.OrderItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/orderitems")
public class OrderItemsController {
    @Autowired
    private OrderItemServices orderItemServices;

    @PostMapping("/save")
    public ResponseEntity<OrderItems> save(@RequestBody OrderItems orderItems){
        return new ResponseEntity<OrderItems>(orderItemServices.save(orderItems), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<OrderItems>getall(){
        return new ArrayList<OrderItems>(orderItemServices.getall());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderItems>getById(@PathVariable("id")long id){
        return new ResponseEntity<OrderItems>(orderItemServices.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<OrderItems>updateById(@PathVariable("id")long id,
                                                @RequestBody OrderItems items){
        return new ResponseEntity<>(orderItemServices.updateById(items,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderItems> deleteById(@PathVariable("id")long id){
        orderItemServices.deleteById(id);
        return new ResponseEntity<OrderItems>(HttpStatus.OK);
    }
}

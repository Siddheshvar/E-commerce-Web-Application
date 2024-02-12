package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Order;
import com.example.Ecommerce.Web.Apk.Services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping("/save")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderServices.saveOrder(order), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Order> getAll(){
        return new ArrayList<>(orderServices.getAllOrder());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Order> getOrderByOd(@PathVariable("id")int id){
        return new ResponseEntity<>(orderServices.getOderById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateById(@PathVariable("id")int id,@RequestBody Order order){
        return new ResponseEntity<Order>(orderServices.updateOrderById(order,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable("id")int id){
        orderServices.deleteOrderById(id);
        return new ResponseEntity<Order>(HttpStatus.OK);
    }

}

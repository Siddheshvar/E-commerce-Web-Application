package com.example.Ecommerce.Web.Apk.Controllers;


import com.example.Ecommerce.Web.Apk.Modules.Order;
import com.example.Ecommerce.Web.Apk.Services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @PostMapping("/save")
    public ResponseEntity<Order> saveOrder(Order order){
        return  new ResponseEntity<Order>(orderServices.saveOrder(order),HttpStatus.OK);
    }

    @GetMapping("/allOrders")
    public List<Order> allOrders(){
        return orderServices.getAllOrders();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id){
        return  new ResponseEntity<>(orderServices.getOrderById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrderById(@PathVariable("id") long id,
                                            @RequestBody Order order){
        return new ResponseEntity<>(orderServices.updateOrderById(order,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable("id") long id){
        orderServices.deleteOrderById(id);
        return new ResponseEntity<Order>(HttpStatus.OK);
    }
}

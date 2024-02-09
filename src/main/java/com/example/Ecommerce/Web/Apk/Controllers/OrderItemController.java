package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.OrderItems;
import com.example.Ecommerce.Web.Apk.Services.OrderItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemsServices orderItemsServices;
    public OrderItemController(OrderItemsServices orderItemsServices) {
        this.orderItemsServices = orderItemsServices;
    }

    @PostMapping("/save")
    public ResponseEntity<OrderItems> saveOrderItems(@RequestBody OrderItems items){
        return  new ResponseEntity<OrderItems>(orderItemsServices.saveOrderItems(items), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<OrderItems> getOrderItems(){
        return new ArrayList<>(orderItemsServices.getOrderItems());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderItems> getOrderItemById(@PathVariable("id")long id){
        return new ResponseEntity<OrderItems>(orderItemsServices.getOrderItemById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderItems> updateOrderItemById(@PathVariable("id")long id,
                                                          @RequestBody OrderItems orderItems){
        return new ResponseEntity<OrderItems>(orderItemsServices.updateOrderItemById(orderItems,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderItems> deleteOrderItemById(@PathVariable("id")long id){
        orderItemsServices.deleteOrderItemById(id);
        return new ResponseEntity<OrderItems>(HttpStatus.OK);
    }
}

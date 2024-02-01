package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.DTO.OrderRequest;
import com.example.Ecommerce.Web.Apk.Modules.Customer;
import com.example.Ecommerce.Web.Apk.Repositories.CustomerRepository;
import com.example.Ecommerce.Web.Apk.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/allOrders")
    public List<Customer> allOrders(){
        return customerRepository.findAll();
    }

}

package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Customer;
import com.example.Ecommerce.Web.Apk.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer){
        return new ResponseEntity<>(this.customerServices.createCustomer(customer),HttpStatus.OK);
    }

    @GetMapping("/getCustomers")
    public List<Customer> getUsers(){
        return customerServices.getCustomers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable("id") long id){
        return new ResponseEntity<Customer>(this.customerServices.getCustomerById(id),HttpStatus.OK);
    }

    @PutMapping(("/update/{id}"))
    public ResponseEntity<Customer> updateUserById(@PathVariable("id") long id,
                                                   @RequestBody Customer customer){
        return new ResponseEntity<>(this.customerServices.updateCustomerById(customer,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteUserById(@PathVariable("id") long id){
        customerServices.deleteCustomerById(id);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

}

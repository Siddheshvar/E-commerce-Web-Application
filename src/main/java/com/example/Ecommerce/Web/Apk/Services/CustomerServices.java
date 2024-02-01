package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerServices {
    Customer createCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer getCustomerById(long id);
    Customer updateCustomerById(Customer customer, long id);
    void deleteCustomerById(long id);
}

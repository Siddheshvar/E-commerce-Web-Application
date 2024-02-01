package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Customer;
import com.example.Ecommerce.Web.Apk.Repositories.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices {
//    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServicesImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        return this.customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));
    }

    @Override
    public Customer updateCustomerById(@NotNull Customer customer, long id) {
        Customer oldUser = customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));

        oldUser.setFullName(customer.getFullName());
        oldUser.setPhoneNo(customer.getPhoneNo());
        oldUser.setEmailId(customer.getEmailId());
        oldUser.setCreatePassword(customer.getCreatePassword());

        return  this.customerRepository.save(oldUser);
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));
        customerRepository.deleteById(id);
    }
}

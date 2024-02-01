package com.example.Ecommerce.Web.Apk.Repositories;

import com.example.Ecommerce.Web.Apk.Modules.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

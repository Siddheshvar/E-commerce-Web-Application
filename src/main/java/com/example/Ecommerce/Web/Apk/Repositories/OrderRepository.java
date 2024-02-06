package com.example.Ecommerce.Web.Apk.Repositories;

import com.example.Ecommerce.Web.Apk.Modules.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}

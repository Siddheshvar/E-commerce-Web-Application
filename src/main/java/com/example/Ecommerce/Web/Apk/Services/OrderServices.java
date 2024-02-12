package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServices {
    Order saveOrder(Order order);
    List<Order> getAllOrder();
    Order getOderById(int id);
    Order updateOrderById(Order order,int id);
    void deleteOrderById(int id);
}

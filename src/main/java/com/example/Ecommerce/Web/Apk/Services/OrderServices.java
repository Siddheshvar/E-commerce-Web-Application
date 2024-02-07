package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServices {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(long id);
    Order updateOrderById(Order order, long id);
    void deleteOrderById(long id);
}

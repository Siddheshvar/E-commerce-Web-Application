package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Order;
import com.example.Ecommerce.Web.Apk.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicesImpl implements OrderServices{
    @Autowired
    private OrderRepository orderRepository;
    public OrderServicesImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrderItem(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return this.orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Order not found!"));
    }

    @Override
    public Order updateOrderById(Order order, long id) {
        return null;
    }

    @Override
    public void deleteOrderById(long id) {
        orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Order not found!"));
        orderRepository.deleteById(id);
    }
}

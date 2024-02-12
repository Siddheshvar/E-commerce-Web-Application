package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Order;
import com.example.Ecommerce.Web.Apk.Repositories.OrderRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicesImpl implements OrderServices{
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order getOderById(int id) {
        return this.orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Order not found!"));
    }

    @Override
    public Order updateOrderById(@NotNull Order order, int id) {
        Order oldOrder = orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Order not found!"));
        oldOrder.setDateTime(order.getDateTime());
        oldOrder.setTotalAmount(order.getTotalAmount());

        return this.orderRepository.save(oldOrder);
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.findById(id).orElseThrow(()->
                new RuntimeException("Order not found!"));
        orderRepository.deleteById(id);
    }
}

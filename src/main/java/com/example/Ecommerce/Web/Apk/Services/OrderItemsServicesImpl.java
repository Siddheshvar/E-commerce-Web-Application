package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.OrderItems;
import com.example.Ecommerce.Web.Apk.Repositories.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServicesImpl implements OrderItemsServices{
    @Autowired
    private OrderItemsRepository orderItemsRepository;


    @Override
    public OrderItems saveOrderItems(OrderItems item) {
        return this.orderItemsRepository.save(item);
    }

    @Override
    public List<OrderItems> getOrderItems() {
        return this.orderItemsRepository.findAll();
    }

    @Override
    public OrderItems getOrderItemById(long id) {
        return this.orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("OrderItems not found!"));
    }

    @Override
    public OrderItems updateOrderItemById(OrderItems orderItems, long id) {
        OrderItems existingItem = orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("OrderItem not found!"));
        existingItem.setItemQty(orderItems.getItemQty());
        existingItem.setSubTotal(orderItems.getSubTotal());

        return this.orderItemsRepository.save(existingItem);
    }

    @Override
    public void deleteOrderItemById(long id) {
        orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("OrderItems not found!"));
        orderItemsRepository.deleteById(id);
    }
}

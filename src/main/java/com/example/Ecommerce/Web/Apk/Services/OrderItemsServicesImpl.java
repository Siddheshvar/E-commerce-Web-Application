package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.OrderItems;
import com.example.Ecommerce.Web.Apk.Repositories.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServicesImpl implements OrderItemServices{
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    public OrderItemsServicesImpl(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public OrderItems save(OrderItems items) {
        return this.orderItemsRepository.save(items);
    }

    @Override
    public List<OrderItems> getall() {
        return this.orderItemsRepository.findAll();
    }

    @Override
    public OrderItems getById(long id) {
        return this.orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("No item found!"));
    }

    @Override
    public OrderItems updateById(OrderItems items, long id) {
        OrderItems oldItems = orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("No item found!"));

        oldItems.setItemQty(items.getItemQty());
        oldItems.setItemsSubTotal(items.getItemsSubTotal());

        return this.orderItemsRepository.save(oldItems);
    }

    @Override
    public void deleteById(long id) {
        orderItemsRepository.findById(id).orElseThrow(()->
                new RuntimeException("No item found!"));
        orderItemsRepository.deleteById(id);
    }
}

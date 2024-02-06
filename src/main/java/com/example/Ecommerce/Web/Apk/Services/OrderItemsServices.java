package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.OrderItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemsServices {
    OrderItems saveOrderItems(OrderItems item);

    List<OrderItems> getOrderItems();

    OrderItems getOrderItemById(long id);

    OrderItems updateOrderItemById(OrderItems orderItems, long id);

    void deleteOrderItemById(long id);
}

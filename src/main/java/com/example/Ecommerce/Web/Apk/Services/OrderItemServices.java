package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.OrderItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemServices {
    OrderItems save(OrderItems items);
    List<OrderItems> getall();
    OrderItems getById(long id);
    OrderItems updateById(OrderItems items,long id);
    void deleteById(long id);

}

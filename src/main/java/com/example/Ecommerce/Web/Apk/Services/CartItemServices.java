package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.CartItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemServices {
    CartItems saveItems(CartItems item);
    List<CartItems> getCartItems();
    CartItems getCartItemsById(long id);
    CartItems updateCartItemById(CartItems item, long id);
    void deleteCartItemById(long is);
}

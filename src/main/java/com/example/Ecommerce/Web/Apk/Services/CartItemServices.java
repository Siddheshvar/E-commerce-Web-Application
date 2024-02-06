package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemServices {
    CartItem saveItems(CartItem item);
    List<CartItem> getCartItems();
    CartItem getCartItemsById(long id);
    CartItem updateCartItemById(CartItem item, long id);
    void deleteCartItemById(long is);
}

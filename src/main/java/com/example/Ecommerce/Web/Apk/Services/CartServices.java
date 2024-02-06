package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartServices {
    Cart saveCart(Cart cart);
    List<Cart> getAllCart();
    Cart getCartById(long id);
    Cart updateCartById(Cart cart,long id);
    void deleteCartById(long id);
}

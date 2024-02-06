package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Cart;
import com.example.Ecommerce.Web.Apk.Repositories.CartRepository;
import org.intellij.lang.annotations.JdkConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServicesImpl implements CartServices{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCart() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getCartById(long id) {
        return this.cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Cart not found!"));
    }

    @Override
    public Cart updateCartById(Cart cart, long id) {
        Cart existingCart = cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Cart not found!"));
        existingCart.setCartItems(cart.getCartItems());

        return this.cartRepository.save(existingCart);
    }

    @Override
    public void deleteCartById(long id) {
        cartRepository.findById(id).orElseThrow(()->
                new RuntimeException("Cart not found!"));
        cartRepository.deleteById(id);
    }
}

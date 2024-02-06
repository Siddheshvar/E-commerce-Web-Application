package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.CartItem;
import com.example.Ecommerce.Web.Apk.Repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServicesImpl implements CartItemServices{
    @Autowired
    private CartItemRepository cartItemRepository;
    public CartItemServicesImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem saveItems(CartItem item) {
        return this.cartItemRepository.save(item);
    }

    @Override
    public List<CartItem> getCartItems() {
        return this.cartItemRepository.findAll();
    }

    @Override
    public CartItem getCartItemsById(long id) {
        return this.cartItemRepository.findById(id).orElseThrow(()->
                new RuntimeException("CartRepository item not found!"));
    }

    @Override
    public CartItem updateCartItemById(CartItem item, long id) {
        CartItem existingItems = cartItemRepository.findById(id).orElseThrow(()->
                new RuntimeException("CartRepository item not found!"));
        existingItems.setItemQty(item.getItemQty());

        return this.cartItemRepository.save(existingItems);
    }

    @Override
    public void deleteCartItemById(long id) {
        cartItemRepository.findById(id).orElseThrow(()->
                new RuntimeException("CartRepository item not found!"));
        cartItemRepository.deleteById(id);
    }
}

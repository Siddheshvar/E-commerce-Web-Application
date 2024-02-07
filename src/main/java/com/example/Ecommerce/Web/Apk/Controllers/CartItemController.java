package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.CartItems;
import com.example.Ecommerce.Web.Apk.Services.CartItemServices;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
    @Autowired
    private CartItemServices cartItemServices;
    public CartItemController(CartItemServices cartItemServices) {
        this.cartItemServices = cartItemServices;
    }

    @PostMapping("/saveItems")
    public ResponseEntity<CartItems> saveItems(CartItems item){
        return new ResponseEntity<CartItems>(cartItemServices.saveItems(item), HttpStatus.OK);
    }
    @GetMapping("getItems")
    public List<CartItems> getCartItems(){
        return new ArrayList<CartItems>(cartItemServices.getCartItems());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartItems> getCartItemsById(@PathVariable("id")long id){
        return new ResponseEntity<CartItems>(cartItemServices.getCartItemsById(id),HttpStatus.OK);
    }

    @PutMapping("/get/{id}")
    public ResponseEntity<CartItems> updateCartItemById(@PathVariable("id")long id,
                                                        @RequestBody CartItems cartItems){
        return  new ResponseEntity<CartItems>(cartItemServices.updateCartItemById(cartItems,id),HttpStatus.OK);
    }

    @DeleteMapping("/get/{id}")
    public ResponseEntity<CartItems> deleteCartItemById(@PathVariable("id")long id){
        cartItemServices.deleteCartItemById(id);
        return new ResponseEntity<CartItems>(HttpStatus.OK);
    }

}

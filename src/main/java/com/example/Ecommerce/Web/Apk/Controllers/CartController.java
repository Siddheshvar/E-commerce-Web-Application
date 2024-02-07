package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Cart;
import com.example.Ecommerce.Web.Apk.Services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServices cartServices;

    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @PostMapping("/save")
    public ResponseEntity<Cart> saveCart(Cart cart){
        return  new ResponseEntity<Cart>(cartServices.saveCart(cart), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Cart> getAllCart(){
        return new ArrayList<Cart>(cartServices.getAllCart());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id")long id){
        return new ResponseEntity<Cart>(cartServices.getCartById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cart> updateCartById(@PathVariable("id")long id,
                                               @RequestBody Cart cart){
        return new ResponseEntity<Cart>(cartServices.updateCartById(cart,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cart> deleteCartById(@PathVariable("id")long id){
        cartServices.deleteCartById(id);
        return new ResponseEntity<Cart>(HttpStatus.OK);
    }
}

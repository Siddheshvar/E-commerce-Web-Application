package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Products;
import com.example.Ecommerce.Web.Apk.Services.ProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsServices productsServices;
    public ProductsController(ProductsServices productsServices) {
        this.productsServices = productsServices;
    }

    @PostMapping("/save")
    public ResponseEntity<Products> saveProduct(@RequestBody Products products){
        return new ResponseEntity<>(productsServices.saveProduct(products), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public List<Products> getAllProducts(){
        return  new ArrayList<Products>(productsServices.getAllProducts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") long id){
        return new ResponseEntity<Products>(productsServices.getProductById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProductById(@RequestBody Products products,
                                                      @PathVariable("id") long id){
        return new ResponseEntity<Products>(productsServices.updateProductById(products,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Products> deleteProductById(@PathVariable("id")long id){
        productsServices.deleteProductById(id);
        return new ResponseEntity<Products>(HttpStatus.OK);
    }
}

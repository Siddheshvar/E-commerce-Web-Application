package com.example.Ecommerce.Web.Apk.Services;
import com.example.Ecommerce.Web.Apk.Modules.Products;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface ProductsServices {
    Products saveProduct(Products products);
    List<Products> getAllProducts();
    Products getProductById(long id);
    Products updateProductById(Products products,long id);
    void deleteProductById(long id);
}

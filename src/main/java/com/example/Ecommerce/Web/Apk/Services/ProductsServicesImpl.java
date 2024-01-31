package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Products;
import com.example.Ecommerce.Web.Apk.Repositories.ProductsRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class ProductsServicesImpl implements ProductsServices{

    @Autowired
    private ProductsRepository productsRepository;
    public ProductsServicesImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    @Override
    public Products saveProduct(Products products) {
        return this.productsRepository.save(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return this.productsRepository.findAll();
    }

    @Override
    public Products getProductById(long id) {
        return this.productsRepository.findById(id).orElseThrow(()->
                new ResolutionException("Product not found!"));
    }

    @Override
    public Products updateProductById(@NotNull Products products, long id) {
        Products existingProduct = productsRepository.findById(id).orElseThrow(()->
                new ResolutionException("Product not found!"));

        existingProduct.setPrName(products.getPrName());
        existingProduct.setPrPrice(products.getPrPrice());
        existingProduct.setPrURL(products.getPrURL());

        return this.productsRepository.save(existingProduct);
    }

    @Override
    public void deleteProductById(@NotNull long id) {
        productsRepository.findById(id).orElseThrow(()->
                new ResolutionException("Product not found!"));
        productsRepository.deleteById(id);
    }
}

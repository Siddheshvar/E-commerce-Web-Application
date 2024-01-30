package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import com.example.Ecommerce.Web.Apk.Services.CategoryServices;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping("/save")
    public ResponseEntity<Category> createCat(@RequestBody Category category){
        return new ResponseEntity<>(categoryServices.createCat(category), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public List<Category> getAllCategory(){
        return new ArrayList<Category>(categoryServices.getAllCategory());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCatById(@PathVariable("id")Integer id){
        return new ResponseEntity<Category>(categoryServices.getCatById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCatById(@RequestBody Category category,
                                                  @PathVariable("id")Integer id){
        return new ResponseEntity<Category>(categoryServices.updateCatById(category,id),HttpStatus.OK);
    }

    public ResponseEntity<Category> deleteCatById(@PathVariable("id")Integer id){
        categoryServices.deleteCatById(id);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }
}

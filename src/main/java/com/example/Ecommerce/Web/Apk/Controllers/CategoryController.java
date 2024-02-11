package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import com.example.Ecommerce.Web.Apk.Services.CategoryServices;
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

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryServices.saveCategory(category), HttpStatus.OK);
    }
    @GetMapping("/getall")
    public List<Category> getAllCategory(){
        return new ArrayList<Category>(categoryServices.getAllCategory());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        return new ResponseEntity<Category>(categoryServices.getCategoryById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable("id")int id,
                                                       @RequestBody Category category){
        return new ResponseEntity<Category>(categoryServices.updateCategoryById(category,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable("id") int id){
        categoryServices.deleteCategoryById(id);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }

}

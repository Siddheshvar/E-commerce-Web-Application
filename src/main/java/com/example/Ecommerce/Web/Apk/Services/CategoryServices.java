package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServices {
    Category createCat(Category category);
    List<Category> getAllCategory();
    Category getCatById(Integer id);
    Category updateCatById(Category category, Integer id);
    void deleteCatById(Integer id);
}

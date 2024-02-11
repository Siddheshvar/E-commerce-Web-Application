package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import com.example.Ecommerce.Web.Apk.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServices {

    Category saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(int id);
    Category updateCategoryById(Category category,int id);
    void deleteCategoryById(int id);

}

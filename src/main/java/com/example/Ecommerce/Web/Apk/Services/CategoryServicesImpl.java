package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import com.example.Ecommerce.Web.Apk.Repositories.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return this.categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found!"));
    }

    @Override
    public Category updateCategoryById(@NotNull Category category, int id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found!"));

        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setCategoryURL(category.getCategoryURL());

        return this.categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found!"));
        categoryRepository.deleteById(id);
    }
}

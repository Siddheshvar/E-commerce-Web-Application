package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import com.example.Ecommerce.Web.Apk.Repositories.CategoryRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServicesImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCat(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCatById(Integer id) {
        return this.categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found!"));
    }

    @Override
    public Category updateCatById(@NotNull Category category, Integer id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found!"));

        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setCategoryURL(category.getCategoryURL());

        return this.categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCatById(@NotNull Integer id) {
        categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found!"));
        categoryRepository.deleteById(id);
    }
}

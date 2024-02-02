package com.firstproject.FirstProject.Service;

import com.firstproject.FirstProject.Entity.Category;
import com.firstproject.FirstProject.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}

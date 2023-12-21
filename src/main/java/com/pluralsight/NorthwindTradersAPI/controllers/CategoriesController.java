package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.Category;
import com.pluralsight.NorthwindTradersAPI.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    private final CategoryDao categoryDao;
    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }
    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId) {
        return categoryDao.getById(categoryId);
    }
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }
    @PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable Long categoryId, @RequestBody Category updatedCategory) {
        categoryDao.update(categoryId, updatedCategory);
        return updatedCategory;
    }
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryDao.delete(categoryId);
    }
}
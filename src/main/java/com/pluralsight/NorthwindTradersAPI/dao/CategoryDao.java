package com.pluralsight.NorthwindTradersAPI.dao;
import com.pluralsight.NorthwindTradersAPI.Category;
import java.util.List;
public interface CategoryDao {
    List<Category> getAll();
    Category getById(Long id);
    Category create(Category category);
    Category update(Long categoryId, Category updatedCategory);
    void delete(Long categoryId);
    Category insert(Category category);
}
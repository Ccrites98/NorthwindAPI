package com.pluralsight.NorthwindTradersAPI.dao;
import com.pluralsight.NorthwindTradersAPI.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;
@Component
public abstract class JdbcCategoryDao implements CategoryDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Category> getAll() {
        String query = "SELECT * FROM categories";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Category.class));
    }
    @Override
    public Category getById(Long id) {
        String query = "SELECT * FROM categories WHERE categoryId = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, BeanPropertyRowMapper.newInstance(Category.class));
    }
    @Override
    public Category create(Category category) {
        return null;
    }
    @Override
    public Category update(Long id, Category updatedCategory) {
        String query = "UPDATE categories SET categoryName = ? WHERE categoryId = ?";
        jdbcTemplate.update(query, updatedCategory.getCategoryName(), id);
        return updatedCategory;
    }
    @Override
    public Category insert(Category category){
        String query = "INSERT INTO categories (categoryName) values (?)";
        jdbcTemplate.update(query, category.getCategoryName());
        return category;
    }}
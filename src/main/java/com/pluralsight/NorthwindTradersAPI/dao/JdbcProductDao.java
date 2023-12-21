package com.pluralsight.NorthwindTradersAPI.dao;
import com.pluralsight.NorthwindTradersAPI.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;
@Component
public abstract class JdbcProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Product> getAll() {
        String query = "SELECT * FROM products";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Product.class));
    }
    @Override
    public Product getById(Long id) {
        String query = "SELECT * FROM products WHERE productId = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, BeanPropertyRowMapper.newInstance(Product.class));
    }
    @Override
    public Product insert(Product product) {
        String query = "INSERT INTO products (productName, categoryId, unitPrice) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, product.getProductName(), product.getCategoryId(), product.getUnitPrice());
        return product;
    }
    public Product update(Long id, Product updatedProduct) {
        String query = "UPDATE products SET productName = ?, categoryId = ?, unitPrice = ? WHERE productId = ?";
        jdbcTemplate.update(query, updatedProduct.getProductName(), updatedProduct.getCategoryId(), updatedProduct.getUnitPrice(), id);
        return updatedProduct;
    }
}
package com.pluralsight.NorthwindTradersAPI.dao;
import com.pluralsight.NorthwindTradersAPI.Product;
import java.util.List;
public interface ProductDao {
    List<Product> getAll();
    Product getById(Long id);
    Product create(Product product);
    Product update(Long productId, Product updatedProduct);
    void delete(Long productId);
    Product insert(Product product);
}
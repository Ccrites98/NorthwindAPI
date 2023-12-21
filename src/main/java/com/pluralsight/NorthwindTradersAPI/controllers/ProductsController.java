package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.Product;
import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductDao productDao;
    @Autowired
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productDao.getById(productId);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        productDao.update(productId, updatedProduct);
        return updatedProduct;
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productDao.delete(productId);
    }}
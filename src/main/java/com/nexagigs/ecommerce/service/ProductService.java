package com.nexagigs.ecommerce.service;

import com.nexagigs.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);
    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();

    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}

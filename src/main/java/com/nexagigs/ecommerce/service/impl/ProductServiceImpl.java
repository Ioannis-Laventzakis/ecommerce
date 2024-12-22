package com.nexagigs.ecommerce.service.impl;

import com.nexagigs.ecommerce.model.Product;
import com.nexagigs.ecommerce.repository.ProductRepository;
import com.nexagigs.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

}

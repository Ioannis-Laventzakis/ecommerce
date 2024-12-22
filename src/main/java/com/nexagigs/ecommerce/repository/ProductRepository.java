package com.nexagigs.ecommerce.repository;

import com.nexagigs.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

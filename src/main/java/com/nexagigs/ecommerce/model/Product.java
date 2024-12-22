package com.nexagigs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Product entity class representing a product in the system.
 *
 * Annotations used:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table(name = "products"): Specifies the name of the database table to be used for mapping.
 * - @Data: Lombok annotation that generates getter and setter methods, toString, equals, and hashCode methods.
 * - @NoArgsConstructor and @AllArgsConstructor: Lombok annotations that generate a no-argument constructor and an all-argument constructor, respectively.
 *
 * Validation constraints:
 * - @NotBlank: Ensures the field is not null or empty.
 * - @Size: Ensures the field meets the specified size constraints.
 * - @PositiveOrZero: Ensures the field is a positive number or zero.
 *
 * Fields:
 * - id: The unique identifier for the product.
 * - orders: The list of orders that include this product.
 * - name: The name of the product.
 * - description: The description of the product.
 * - price: The price of the product.
 * - quantity: The available quantity of the product.
 * - image: The URL of the product image.
 * - status: The availability status of the product.
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * The unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The list of orders that include this product.
     */
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    /**
     * The name of the product.
     */
    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * The description of the product.
     */
    @Size(max = 255)
    @Column(length = 255)
    private String description;

    /**
     * The price of the product.
     */
    @PositiveOrZero
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * The available quantity of the product.
     */
    @PositiveOrZero
    @Column(nullable = false)
    private int quantity;

    /**
     * The URL of the product image.
     */
    @Size(max = 255)
    @Column(length = 255)
    private String image;

    /**
     * Represents the product's status:
     * true - Available
     * false - Unavailable
     */
    @Column(nullable = false)
    private boolean status;
}
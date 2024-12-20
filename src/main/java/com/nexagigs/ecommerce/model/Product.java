package com.nexagigs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product")
    private List<Order> orderProducts;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Size(max = 255)
    @Column(length = 255)
    private String description;

    @PositiveOrZero
    @Column(nullable = false)
    private double price;

    @PositiveOrZero
    @Column(nullable = false)
    private int quantity;

    @Size(max = 255)
    @Column(length = 255)
    private String image;

    @Column(nullable = false)
    private boolean status;
}

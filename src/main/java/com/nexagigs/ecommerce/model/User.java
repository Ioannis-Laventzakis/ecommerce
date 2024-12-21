package com.nexagigs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 8)
    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false)
    private String role;

    @Size(max = 255)
    private String address;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,15}$")
    private String phone;

    // Custom setter for password to include hashing
    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    // Method to hash the password
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }
}
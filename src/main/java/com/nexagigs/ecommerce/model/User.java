package com.nexagigs.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

/** * User entity class representing a user in the system.
 *
 * Annotations used:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table(name = "users"): Specifies the name of the database table to be used for mapping.
 * - @Getter and @Setter: Lombok annotations that automatically generate getter and setter methods for all fields.
 * - @NoArgsConstructor and @AllArgsConstructor: Lombok annotations that generate a no-argument constructor and an all-argument constructor, respectively.
 *
 * Validation constraints:
 * - @NotBlank: Ensures the field is not null or empty.
 * - @Email: Ensures the field contains a valid email address.
 * - @Size: Ensures the field meets the specified size constraints.
 * - @Pattern: Ensures the field matches the specified regular expression.
 *
 * Custom methods:
 * - setPassword: Custom setter for password to include hashing using BCrypt.
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @NotBlank(message = "Name is required")
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 8)
    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Role is required")
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
}
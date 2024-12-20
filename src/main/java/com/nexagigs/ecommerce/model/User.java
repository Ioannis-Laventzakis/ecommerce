package com.nexagigs.ecommerce.model;


import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    @jakarta.validation.constraints.NotBlank
    private String name;

    @Column(nullable = false, unique = true)
    @jakarta.validation.constraints.Email
    private String email;

    @Column(nullable = false)
    @jakarta.validation.constraints.Size(min = 8)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(length = 255)
    private String address;

    @Column(length = 15)
    @jakarta.validation.constraints.Pattern(regexp = "\\d{10,15}")
    private String phone;

    public User() {
    }

    public User(Long id, String name, String email, String password, String role, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String hashpassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setPassword(String password) {
        this.password = hashpassword(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

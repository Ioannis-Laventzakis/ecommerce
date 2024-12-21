package com.nexagigs.ecommerce.service;

import com.nexagigs.ecommerce.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);

    User registerUser(User user);

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> findAllUsers();

    Long getId(User user);

    String getEmail(User user);
}
package com.nexagigs.ecommerce.service;

import com.nexagigs.ecommerce.model.User;
import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findUserId(String username);

    User registerUser(User user);

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);
    User UpdateUser(User user);

    User updateUser(User user);

    Void deleteUser(Long id);
}

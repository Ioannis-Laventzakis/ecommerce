package com.nexagigs.ecommerce.service.impl;

import com.nexagigs.ecommerce.exception.UserNotFoundException;
import com.nexagigs.ecommerce.model.User;
import com.nexagigs.ecommerce.repository.UserRepository;
import com.nexagigs.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already registered");
        }
        return userRepository.save(user);
    }

    @Override
    public User registerUser(User user) {
        return register(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new UserNotFoundException("User not found");
        }
        return userRepository.save(user);
    }


    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Long getId(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        return user.getId();
    }

    @Override
    public String getEmail(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        return user.getEmail();
    }
}

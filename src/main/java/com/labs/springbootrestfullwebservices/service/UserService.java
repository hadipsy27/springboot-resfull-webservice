package com.labs.springbootrestfullwebservices.service;

import com.labs.springbootrestfullwebservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();
}

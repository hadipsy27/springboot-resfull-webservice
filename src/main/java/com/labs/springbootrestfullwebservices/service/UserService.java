package com.labs.springbootrestfullwebservices.service;

import com.labs.springbootrestfullwebservices.dto.UserDto;
import com.labs.springbootrestfullwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}

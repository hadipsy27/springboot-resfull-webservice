package com.labs.springbootrestfullwebservices.service.impl;

import com.labs.springbootrestfullwebservices.dto.UserDto;
import com.labs.springbootrestfullwebservices.entity.User;
import com.labs.springbootrestfullwebservices.mapper.UserMapper;
import com.labs.springbootrestfullwebservices.repository.UserRepository;
import com.labs.springbootrestfullwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto into User Entity
        User user = UserMapper.mapToUser(userDto);

        User save = userRepository.save(user);

        // Convert User JPA to UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(save);
        return savedUserDto;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

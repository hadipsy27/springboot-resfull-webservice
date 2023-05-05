package com.labs.springbootrestfullwebservices.service.impl;

import com.labs.springbootrestfullwebservices.dto.UserDto;
import com.labs.springbootrestfullwebservices.entity.User;
import com.labs.springbootrestfullwebservices.mapper.AutoUserMapper;
import com.labs.springbootrestfullwebservices.mapper.UserMapper;
import com.labs.springbootrestfullwebservices.repository.UserRepository;
import com.labs.springbootrestfullwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto into User Entity
        //User user = UserMapper.mapToUser(userDto);

        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        // Convert User JPA to UserDto
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        //return users.stream().map(mapUser -> UserMapper.mapToUserDto(mapUser)).collect(Collectors.toList());
        //return users.stream().map(mapUser -> modelMapper.map(mapUser, UserDto.class)).collect(Collectors.toList());
        return users.stream().map(mapUser -> AutoUserMapper.MAPPER.mapToUserDto(mapUser)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        final User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(save);
        //return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

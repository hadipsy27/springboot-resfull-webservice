package com.labs.springbootrestfullwebservices.controller;

import com.labs.springbootrestfullwebservices.dto.UserDto;
import com.labs.springbootrestfullwebservices.entity.User;
import com.labs.springbootrestfullwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    /* Build create User REST API */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        final UserDto saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }

    /* Build get user id REST API
    * http://localhost:8080/api/users/1
    */
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        final User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /* Build Get All User REST API
    * http://localhost:8080/api/users
    */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        final List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /* Build Update User REST API
    * http://localhost:8080/api/users/1
    */
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId(userId);
        final User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /*
        Build Delete User REST API
        http://localhost:8080/api/users/1
    */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully Deleted!",HttpStatus.OK);
    }

}

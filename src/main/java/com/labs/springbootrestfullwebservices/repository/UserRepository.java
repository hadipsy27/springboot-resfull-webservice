package com.labs.springbootrestfullwebservices.repository;

import com.labs.springbootrestfullwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

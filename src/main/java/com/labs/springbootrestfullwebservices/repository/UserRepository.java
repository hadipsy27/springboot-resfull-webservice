package com.labs.springbootrestfullwebservices.repository;

import com.labs.springbootrestfullwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

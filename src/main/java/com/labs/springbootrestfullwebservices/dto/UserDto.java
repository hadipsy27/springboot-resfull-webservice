package com.labs.springbootrestfullwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    // User first name should not be null or empty
    @NotEmpty(message = "First name should not be null or empty")
    private String firstName;
    // last name should not be null or empty
    @NotEmpty(message = "Last name should not be null or empty")
    private String lastName;

    // email should not be null or empty
    // email address shoud be valid
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;
}

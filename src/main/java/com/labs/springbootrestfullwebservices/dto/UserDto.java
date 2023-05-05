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
    // first name should not be null or empty
    @NotEmpty
    private String firstName;
    // last name should not be null or empty
    @NotEmpty
    private String lastName;

    // email should not be null or empty
    // email address shoud be valid
    @NotEmpty
    @Email
    private String email;
}

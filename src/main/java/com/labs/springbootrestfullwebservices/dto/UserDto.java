package com.labs.springbootrestfullwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "User DTO Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    // User first name should not be null or empty

    @Schema(
            description = "User first name"
    )
    @NotEmpty(message = "First name should not be null or empty")
    private String firstName;
    // last name should not be null or empty

    @Schema(
            description = "User last name"
    )
    @NotEmpty(message = "Last name should not be null or empty")
    private String lastName;

    @Schema(
            description = "User email Address"
    )
    // email should not be null or empty
    // email address shoud be valid
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;
}

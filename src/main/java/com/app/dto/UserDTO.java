package com.app.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserDTO {

    @NotNull(message = "Username cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 10, message = "Password must be at least 10 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*]).{10,}$", message = "Password must contain at least one digit, one symbol, and be 10 characters long")
    private String password;

    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone cannot be null")
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits long")
    private String phone;

    @NotNull(message = "Address cannot be null")
    private String address;
    
    private Role role;

    
    
	
    
    // Getters and Setters
}

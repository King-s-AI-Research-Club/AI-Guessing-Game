package com.aiguess.backend.dto;
import lombok.Data;

//when someone calls signup, they will be sending JSON like:
// {"username": "john", "email": "john@email.com", "password": "123"}

//spring will use this class to receive and read that JSON

@Data
public class AuthRequest {
    private String username;
    private String email;
    private String password;
}
package com.aiguess.backend.controller;
import com.aiguess.backend.dto.AuthRequest;
import com.aiguess.backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

//This is the main auth handler, and handles all the request.
// This file receives the request and pass to specific service

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody AuthRequest request){
        return authService.signup(request);
    }

    @PostMapping("/signin")
    public String signin(@RequestBody AuthRequest request){
        return authService.signin(request);
    }
}

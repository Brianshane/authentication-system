package com.auth_system.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_system.demo.dto.LoginRequest;
import com.auth_system.demo.dto.LoginResponse;
import com.auth_system.demo.service.LoginService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/auth")
public class LoginController {

    private   LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService =loginService;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request)
     {
    LoginResponse response = loginService.login(request);
        
        return ResponseEntity.ok(response);
    }
    
}

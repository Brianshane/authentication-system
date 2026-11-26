package com.auth_system.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth_system.demo.dto.LoginRequest;
import com.auth_system.demo.repository.UserRepository;

public class LoginService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

 public LoginService(UserRepository userRepository,PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder =passwordEncoder;
 }
 public User login(LoginRequest request){
     User user=userRepository.findByEmail(request.getEmail())
 }
}

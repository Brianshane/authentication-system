package com.auth_system.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.auth_system.demo.entity.User;
import com.auth_system.demo.dto.LoginRequest;
import com.auth_system.demo.repository.UserRepository;

public class LoginService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

 public LoginService(UserRepository userRepository,PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder =passwordEncoder;
 }
 //check user email if it exist
 public User login(LoginRequest request){
     User user=userRepository.findByEmail(request.getEmail())
     .orElseThrow(()->new IllegalArgumentException("invalid email or password"));
 
//verify password
boolean passwordMatches = passwordEncoder.matches(
    request.getPassword(),
    user.getPassword()
);
//rejectingincorrect passwords
if(!passwordMatches){
    throw new IllegalArgumentException("entered invalid password");
}

return user;

}
}
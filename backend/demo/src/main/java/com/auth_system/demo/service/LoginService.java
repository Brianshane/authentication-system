package com.auth_system.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.auth_system.demo.entity.User;
import com.auth_system.demo.dto.LoginRequest;
import com.auth_system.demo.dto.LoginResponse;
import com.auth_system.demo.repository.UserRepository;
import com.auth_system.demo.security.JwtService;

public class LoginService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

 public LoginService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService){
    this.userRepository = userRepository;
    this.passwordEncoder =passwordEncoder;
    this.jwtService=jwtService;
 }
 //check user email if it exist
 public LoginResponse login(LoginRequest request){
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

String token = jwtService.generateToken(user.getEmail());
return new LoginResponse(
    token ,
    "Bearer",

  user.getEmail()
)
;

}
}
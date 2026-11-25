package com.auth_system.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth_system.demo.dto.RegistrationRequest;
import com.auth_system.demo.entity.User;
import com.auth_system.demo.repository.UserRepository;

@Service
public class RegistrationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
     
    public RegistrationService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public String register(RegistrationRequest request){
        //checking where registration email already exist
        if(userRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("email already exist");
        }
        //
        //creating new user
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());

        //hashing the password
        String hashedPassword=
        passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);


        return "registration successfull";
    }


}

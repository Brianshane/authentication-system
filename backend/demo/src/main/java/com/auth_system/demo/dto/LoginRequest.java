package com.auth_system.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

@NotBlank (message="email required")
@Email (message ="enter valid email")
    private String email;
@NotBlank (message = "password required")
    private  String password;

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
     
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

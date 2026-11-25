package com.auth_system.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {
    @NotBlank (message = "full name is required")
 private String fullName;
 @NotBlank (message = "email is required")
 @Email (message="enter valid email")
 private String email;
 @NotBlank (message = "password required")
 @Size (min = 8,message = "password must be atleast 8character")
 private String password;

 public String getFullName(){
    return fullName;
 }
 public void setFullName(String fullName){
    this.fullName=fullName;
 }
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
    this.password=password;
    
 }

}

package com.auth_system.demo.dto;

public class LoginResponse {

    public String token;
    public String tokenType;
    public String email;

    public LoginResponse(String token, String tokenType , String email){
        this.token =token;
        this.tokenType = tokenType;
        this.email = email;
    }
    public String getToken(){
        return token;
    }
    public String getTokenType(){
        return tokenType;
    }
    public String getEmail(){
        return email;
    }
}


package com.auth_system.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ResetPasswordRequest {

    @NotBlank (message = "reset token is required")
    private String token;

    @NotBlank (message = "new password required")
    @Size (min = 8, message = "password require minimum of 8 characters")
    private String newPassword;

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
    public String getNewPassword(){
        return newPassword;
    }

    public void setNewPassword(String newPassword){
        this.newPassword = newPassword;
    }
    


}

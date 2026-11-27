package com.auth_system.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
@Entity 
@Table(name="password_reset_token")
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private long id;

@Column(nullable=false,unique=true)
private String tokenHash;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn (nullable = false,name="user_id")
private User user;

@Column(nullable = false)
private LocalDateTime expiryDate;

@Column (nullable = false)
private boolean used =false;

protected PasswordResetToken() {
}

public PasswordResetToken(String tokenHash,User user,LocalDateTime expiryDate){
    this.tokenHash =tokenHash;
    this.user=user;
    this.expiryDate = expiryDate;
}

public Long getId() {
        return id;
    }

public String getTokenHash(){
    return tokenHash;
}

public void setTokenHash(String tokenHash){
    this.tokenHash=tokenHash;
}


public User getUser(){
    return user;
}

public void setUser(User user){
     this.user=user;
}

public LocalDateTime getExpiryDate(){
    return expiryDate;
}

public void setExpiryDate(LocalDateTime expiryDate){
    this.expiryDate =expiryDate;
}


}

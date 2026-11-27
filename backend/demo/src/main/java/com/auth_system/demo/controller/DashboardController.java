package com.auth_system.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@RestController 
@RequestMapping("/api/dashboard")
public class DashboardController {
@GetMapping
public Map <String,String> dashboard(){
    return Map.of(
        "message","welcome to your dashboard",
        "status","authenticated succesfully"
    );
}

}

package com.roberto.weatherapi.controllers;

import com.roberto.weatherapi.dto.response.ResponseHeader;
import com.roberto.weatherapi.dto.user.User;
import com.roberto.weatherapi.interfaces.weatherInterface;
import com.roberto.weatherapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class weatherController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    weatherInterface weatherService;

    @PostMapping("/login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        final String jwt = jwtUtil.generateToken(username);
        User user = new User();
        user.setUsername(username);
        user.setToken("Bearer "+ jwt);
        return user;
    }

    @PostMapping("/weathercity")
    public ResponseEntity<ResponseHeader> getWeather(
           @RequestParam("city") String city) {

        return weatherService.getItems(city);
    }
}

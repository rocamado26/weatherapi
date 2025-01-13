package com.roberto.weatherapi.controllers;


import com.roberto.weatherapi.interfaces.weatherInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@Slf4j
@RestController
public class weatherController {

    @Autowired
    weatherInterface weatherService;

    @GetMapping("/weathercity")
    public ResponseEntity<Object> getWeather(
            @RequestParam(value = "city", required = false) String city) {

        return weatherService.getItems(city);
    }

}

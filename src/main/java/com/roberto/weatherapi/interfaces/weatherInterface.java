package com.roberto.weatherapi.interfaces;

import org.springframework.http.ResponseEntity;

public interface weatherInterface {

    ResponseEntity<Object> getItems(String City);

}

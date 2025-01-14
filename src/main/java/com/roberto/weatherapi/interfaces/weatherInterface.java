package com.roberto.weatherapi.interfaces;

import com.roberto.weatherapi.dto.response.ResponseHeader;
import org.springframework.http.ResponseEntity;

public interface weatherInterface {

    ResponseEntity<ResponseHeader> getItems(String City);

}

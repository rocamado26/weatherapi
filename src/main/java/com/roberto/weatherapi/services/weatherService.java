package com.roberto.weatherapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roberto.weatherapi.dto.GetWeaterInfo;
import com.roberto.weatherapi.interfaces.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
@Slf4j
public class weatherService implements weatherInterface {

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.weather}")
    private String urlWeather;

    @Value("${url.key}")
    private String keyApi;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseEntity<Object> getItems(String City) {

        //Obtiene la fecha de hoy
        LocalDate hoy = LocalDate.now();
        //suma un día
        LocalDate manana = hoy.plusDays(1);
        //formateando fecha en string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaManana = manana.format(formatter);
        try{

            /** Build the endpoint to call integration microservice. */
            String urlEndpoint = urlWeather + "/forecast.json?key="+keyApi+"&q="+City+"&lang=es&dt="+fechaManana;

            //HttpEntity<Object> requestHeader = new HttpEntity<>(bodyRequest, Utils.setHeaderHttp(headerDTO));

            /** Consume web service to integration services to WMS. */
            ResponseEntity<Object> response = restTemplate.getForEntity(urlEndpoint, Object.class);

            return response;

        }catch (Exception ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!! Please check yours logs and try again.");
        }
    }
}

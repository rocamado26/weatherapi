package com.roberto.weatherapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roberto.weatherapi.dto.response.ResponseHeader;
import com.roberto.weatherapi.dto.weatherapi.GetWeaterInfo;
import com.roberto.weatherapi.dto.weatherapi.forecastday;
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
import java.util.List;
import java.util.Objects;


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
    public ResponseEntity<ResponseHeader> getItems(String City) {

        //Obtiene la fecha de hoy
        LocalDate hoy = LocalDate.now();
        //suma un día
        LocalDate manana = hoy.plusDays(1);
        //formateando fecha en string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaManana = manana.format(formatter);

        //
        ResponseHeader responseService = new ResponseHeader();
        try{

            /** Build the endpoint to call integration microservice. */
            String urlEndpoint = urlWeather + "/forecast.json?key="+keyApi+"&q="+City+"&lang=es&dt="+fechaManana;

            //HttpEntity<Object> requestHeader = new HttpEntity<>(bodyRequest, Utils.setHeaderHttp(headerDTO));

            /** Consume web service to integration services to WMS. */
            ResponseEntity<GetWeaterInfo> response = restTemplate.getForEntity(urlEndpoint, GetWeaterInfo.class);

            //obtener condición del día general
            if(response.getStatusCode().is2xxSuccessful()){
                responseService.setMessage("Las condiciones del clima para el día "+fechaManana+" es");
                List<forecastday> info = Objects.requireNonNull(response.getBody()).getForecast().getForecastday();
                info.forEach(data ->{
                    responseService.setCondicion_clima(data.getDay().getCondition().getText());
                });
            }
            else{
                responseService.setMessage("Algo salió mal, por favor intentalo de nuevo");
            }

            return ResponseEntity.status(HttpStatus.OK).body(responseService);

        }catch (Exception ex){
            responseService.setMessage("Algo salió mal, por favor intentalo de nuevo");
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseService);
        }
    }
}

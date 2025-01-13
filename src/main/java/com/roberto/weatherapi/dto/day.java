package com.roberto.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class day {

    private Double maxtemp_c;
    private Double maxtemp_f;
    private Double mintemp_c;
    private Double mintemp_f;
    private Double avgtemp_c;
    private Double avgtemp_f;
    private Double maxwind_mph;
    private Double maxwind_kph;
    private Double totalprecip_mm;
    private Double totalprecip_in;
    private Double totalsnow_cm;
    private Double avgvis_km;
    private Double avgvis_miles;
    private Long avghumidity;
    private Long daily_will_it_rain;
    private Long daily_chance_of_rain;
    private Long daily_will_it_snow;
    private Long daily_chance_of_snow;
    private condition condition;
    private Double uv;

}

package com.roberto.weatherapi.dto.weatherapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class current {

    private Long last_updated_epoch;
    private String last_updated;
    private Double temp_c;
    private Double temp_f;
    private Long is_day;
    private condition condition;
    private Double wind_mph;
    private Double wind_kph;
    private Long wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private Double pressure_in;
    private Double precip_mm;
    private Double precip_in;
    private Long humidity;
    private Long cloud;
    private Double feelslike_c;
    private Double feelslike_f;
    private Double windchill_c;
    private Double windchill_f;
    private Double heatindex_c;
    private Double heatindex_f;
    private Double dewpoint_c;
    private Double dewpoint_f;
    private Double vis_km;
    private Double vis_miles;
    private Double uv;
    private Double gust_mph;
    private Double gust_kph;
}
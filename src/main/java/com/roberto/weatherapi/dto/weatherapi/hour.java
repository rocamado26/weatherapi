package com.roberto.weatherapi.dto.weatherapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class hour {

    private Long time_epoch;

    private String time;

    private Double temp_c;

    private Double temp_f;

    private Integer is_day;

    private condition condition;

    private Double wind_mph;

    private Double wind_kph;

    private Long wind_degree;

    private String wind_dir;

    private Double pressure_mb;

    private Double pressure_in;

    private Double precip_mm;

    private Double precip_in;

    private Double snow_cm;

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

    private Long will_it_rain;

    private Long chance_of_rain;

    private Long will_it_snow;

    private Long chance_of_snow;

    private Double vis_km;

    private Double vis_miles;

    private Double gust_mph;

    private Double gust_kph;

    private Long uv;

}

package com.roberto.weatherapi.dto.weatherapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class location {
    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    private String tz_id;
    private Long localtime_epoch;
    private String localtime;
}

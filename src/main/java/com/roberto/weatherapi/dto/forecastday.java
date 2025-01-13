package com.roberto.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class forecastday {

    private String date;
    private Long date_epoch;
    private day day;
    private astro astro;
    private List<hour> hour;



}

package com.roberto.weatherapi.dto.weatherapi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class forecast {

    private List<forecastday> forecastday;

}

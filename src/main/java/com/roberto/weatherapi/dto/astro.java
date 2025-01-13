package com.roberto.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class astro {

    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private String moon_phase;
    private Long moon_illumination;
    private Long is_moon_up;
    private Long is_sun_up;

}

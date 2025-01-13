package com.roberto.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWeaterInfo {

    private location location;
    private current current;
    private forecast forecast;

}

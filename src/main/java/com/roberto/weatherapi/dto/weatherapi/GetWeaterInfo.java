package com.roberto.weatherapi.dto.weatherapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWeaterInfo {

    private location location;
    private current current;
    private forecast forecast;

}

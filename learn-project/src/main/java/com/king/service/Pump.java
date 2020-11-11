package com.king.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pump {

    private String id;
    private Float pressure;
    private Float gravity;
    private Boolean status;

}

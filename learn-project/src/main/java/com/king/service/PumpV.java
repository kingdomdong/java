package com.king.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PumpV {


    private CanComponent canComponent;

    private String id;
    private Float pressure;
    private Float gravity;
    private Boolean status;

    public void open() {
        this.status = canComponent
                .send("pump:" + id + ":open");
    }


}

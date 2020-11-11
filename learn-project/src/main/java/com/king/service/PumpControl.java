package com.king.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PumpControl {

    private Pump pump;
    private CanComponent canComponent;

    public void openPump() {
        Boolean result = canComponent.send("pump:" + pump.getId() + ":open");
        pump.setStatus(result);
    }

}

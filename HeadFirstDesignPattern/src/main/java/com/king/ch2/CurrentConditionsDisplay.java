package com.king.ch2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private final Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Subject subject) {
        weatherData = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        log.info("Current conditions: "
                + temperature + "F degrees and "
                + humidity + "% humidity");
    }

}

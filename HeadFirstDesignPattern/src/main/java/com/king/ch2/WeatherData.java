package com.king.ch2;

import java.util.ArrayList;

/**
 * 中枢
 *
 * @author Yum
 * @version 1.0
 * @since 2020-11-01 10:09:43
 */
public class WeatherData implements Subject {

    // 实例变量声明
    private CurrentConditionsDisplay currentConditionsDisplay;
    private StatisticsDisplay statisticsDisplay;
    private ForecastDisplay forecastDisplay;
    private ArrayList<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temp, humidity, pressure));
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}

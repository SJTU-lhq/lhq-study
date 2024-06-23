package com.lhq.springboot2.test.test0311;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/11 20:23
 */
public class Display implements WeatherData{
    private double temperature;
    private double humidity;

    private DataSource dataSource;

    public Display(DataSource dataSource){
        this.dataSource = dataSource;
        dataSource.addDisplay(this);
    }


    @Override
    public Double getTemperature() {
        return temperature;
    }

    @Override
    public Double getHumidity() {
        return humidity;
    }

    public void update(double temperature, double humidity){
        this.temperature = temperature;
        this.humidity = humidity;
    }
}

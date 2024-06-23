package com.lhq.springboot2.test.test0311;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/11 20:16
 */
public class DataSource {
    private List<Display> displays;
    private double temperature;
    private double humidity;
    public DataSource(){
        displays = new ArrayList<>();
    }

    public void addDisplay(Display display){
        displays.add(display);
    }

    public void notifyDisplays(){
        for (Display display : displays) {
            display.update(temperature, humidity);
        }
    }

    public void updateData(double temperature, double humidity){
        this.temperature = temperature;
        this.humidity = humidity;
        notifyDisplays();
    }

}

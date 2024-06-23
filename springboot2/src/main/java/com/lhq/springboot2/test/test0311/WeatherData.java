package com.lhq.springboot2.test.test0311;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/11 20:15
 */
public interface WeatherData {
    /**
     *获取温度
     **/
    Double getTemperature();
    /**
     *获湿度
     **/
    Double getHumidity();
}

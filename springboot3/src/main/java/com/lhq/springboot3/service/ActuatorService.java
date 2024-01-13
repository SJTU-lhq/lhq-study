package com.lhq.springboot3.service;

import org.springframework.stereotype.Service;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/5 16:46
 */
@Service
public class ActuatorService {

    public void testThreadDump() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(10000);
            new Thread(()->{
                while (true){
                    System.out.println(Thread.currentThread());
                }
            }).start();
        }
    }
}

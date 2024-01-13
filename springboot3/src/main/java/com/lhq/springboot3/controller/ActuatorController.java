package com.lhq.springboot3.controller;

import com.lhq.springboot3.service.ActuatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/5 16:47
 */
@RestController
@RequestMapping("/study/actuator")
public class ActuatorController {
    @Autowired
    private ActuatorService actuatorService;

    @RequestMapping("/threadDump")
    public void testThreadDump() throws InterruptedException {
        actuatorService.testThreadDump();
    }
}

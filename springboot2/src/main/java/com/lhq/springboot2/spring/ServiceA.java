package com.lhq.springboot2.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/15 00:06
 */
@Service
@Scope("prototype")
public class ServiceA {
    @Autowired
    ServiceB serviceB;
/*    private ServiceB serviceB;

    // 使用setter注入ServiceB
    @Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }*/
}

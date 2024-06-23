package com.lhq.springboot2.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
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
public class ServiceB {
    @Autowired
     ServiceA serviceA;
/*    private ServiceA serviceA;

    // 使用setter注入ServiceA
    @Autowired
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }*/
}

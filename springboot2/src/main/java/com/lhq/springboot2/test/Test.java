package com.lhq.springboot2.test;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/8 18:41
 */
public class Test {
    private static class LazyHandle {
        private static final Test instance = new Test();
    }
    private Test(){}
    private static final Test getInstance(){
        return LazyHandle.instance;
    }

}

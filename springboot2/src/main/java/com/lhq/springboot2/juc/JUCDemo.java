package com.lhq.springboot2.juc;

/**v
 * @author lihaiquan
 * @description:
 * @date 2024/3/7 20:50
 */
public class JUCDemo {
    private volatile static boolean flag = false;

    public static void main(String[] args) {
        // 启动一个线程不断修改flag的值
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = true;
                System.out.println("Flag has been set to true.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 主线程不断检查flag的值
        while (!flag) {
            // 循环等待flag变为true
            System.out.println("flag为false");
        }

        System.out.println("Flag is now true. Program exits.");
    }
}

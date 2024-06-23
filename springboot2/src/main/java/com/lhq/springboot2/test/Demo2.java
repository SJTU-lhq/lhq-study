package com.lhq.springboot2.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/2/29 17:30
 */
public class Demo2 implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<List<Demo2>> listTask = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Demo2> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                list.add(new Demo2());
            }
            listTask.add(list);
        }

        CountDownLatch count;
        for (int i = 0; i < listTask.size(); i++) {
            List<Demo2> list = listTask.get(i);
            count = new CountDownLatch(10);
            for (Demo2 demo2 : list) {
                demo2.setCountDownLatch(count);
                demo2.setI(i);
                executorService.submit(demo2);
            }
            count.await();
        }
        executorService.shutdown();
    }

    private CountDownLatch countDownLatch;
    private int i;
    @Override
    public void run() {
        try {
            System.out.println("批次：" + i +Thread.currentThread().getName() + " start");
            Thread.sleep(100);
            System.out.println("批次：" + i +Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            countDownLatch.countDown();
        }
    }
    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}

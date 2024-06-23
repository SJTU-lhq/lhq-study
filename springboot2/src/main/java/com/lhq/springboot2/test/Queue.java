package com.lhq.springboot2.test;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/2/29 17:35
 */
public class Queue {
    private LinkedList<Integer> list = new LinkedList<>();
    private Semaphore takeSemaphore;
    private Semaphore offerSemaphore;
    public Queue(int max){
        takeSemaphore = new Semaphore(-max / 2);
        offerSemaphore = new Semaphore(max);
    }

    public Integer take(){
        try {
            takeSemaphore.acquire();
            Integer i = list.pollFirst();
            offerSemaphore.release();
            return i;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void offer(int val){
        try {
            offerSemaphore.acquire();
            list.addLast(val);
            takeSemaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Integer size(){
        return list.size();
    }
}

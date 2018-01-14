package com.yang.study.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/15 上午5:05
 * @Description
 */
public class Consumer extends Thread{

    private ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }


    public void run(){
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("消费玩具："+queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

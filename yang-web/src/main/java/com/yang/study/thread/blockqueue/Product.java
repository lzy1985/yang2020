package com.yang.study.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/15 上午5:00
 * @Description
 */
public class Product extends Thread{

    private ArrayBlockingQueue<String> queue;

    public Product(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run(){
        try {
            String[] s = new String[]{"老虎","狮子","大象","狼"};
            for (String s1 : s) {
                queue.put(s1);
                System.out.println("生产出玩具："+s1);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

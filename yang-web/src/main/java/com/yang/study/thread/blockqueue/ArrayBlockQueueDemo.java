package com.yang.study.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/15 上午5:07
 * @Description
 */
public class ArrayBlockQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        Product p = new Product(queue);
        Consumer c = new Consumer(queue);

        p.start();
        c.start();

    }
}


class Product extends Thread{

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

class Consumer extends Thread{

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


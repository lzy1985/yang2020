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

package com.yang.study.thread;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/9 上午4:50
 * @Description
 */
public class TDemo1 {

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];
        for (int i = 1; i < 10; i++) {
            Calculator c = new Calculator(i, "test" + i);
            threads[i] = new Thread(c);
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].start();
        }
    }

}

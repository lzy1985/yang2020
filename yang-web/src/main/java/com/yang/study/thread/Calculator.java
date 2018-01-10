package com.yang.study.thread;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2018/1/9 上午4:53
 * @Description
 */
public class Calculator implements Runnable {
    
    private Integer number;
    private String name;

    public Calculator(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
            System.out.println("线程ID："+Thread.currentThread().getId());
            System.out.println("线程number："+number);
            System.out.println("线程name："+Thread.currentThread().getName());
            System.out.println("线程priority："+Thread.currentThread().getPriority());
            System.out.println("线程state："+Thread.currentThread().getState());
        }
    }
}

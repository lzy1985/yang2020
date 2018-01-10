package com.study.yang.rabbitmq.enums;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/19 下午2:37
 * @Description
 */
public enum MqEnums {

    QUEUE_DIRECT("queue.direct"),
    QUEUE_TOPIC("queue.topic"),
    EXCHANGE_TOPIC("exchange.topic"),
    EXCHANGE_DIRECT("exchange.direct");

    private String name;

    MqEnums(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

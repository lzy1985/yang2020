package com.study.yang.rabbitmq.service;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/13 上午11:28
 * @Description
 */
public interface SendMqMessageService {

    void sendDirectMessage(Object msg);

    void sendTopicMessage(Object msg);
}

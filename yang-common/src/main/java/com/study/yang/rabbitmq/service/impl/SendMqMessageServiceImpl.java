package com.study.yang.rabbitmq.service.impl;

import com.study.yang.rabbitmq.service.SendMqMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/13 上午11:16
 * @Description
 */
@Slf4j
@Service(value = "sendMqMessageService")
public class SendMqMessageServiceImpl implements SendMqMessageService {


//    @Autowired
//    private RabbitTemplate rabbitTemplate;


    public void sendDirectMessage(Object msg){
//        sendMessage(MqEnums.EXCHANGE_DIRECT.getName(),MqEnums.QUEUE_DIRECT.getName(),msg);
    }
    public void sendTopicMessage(Object msg){
//        sendMessage(MqEnums.EXCHANGE_TOPIC.getName(),MqEnums.QUEUE_TOPIC.getName(),msg);
    }


    /**
     * 发送消息
     * @param exchange
     * @param queue
     * @param object
     */
    private void sendMessage(String exchange,String queue,Object object){
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        log.info("开始向【{}】中的【{}】队列发送消息,correlationId为{}",exchange,queue,correlationId);
//        rabbitTemplate.convertAndSend(exchange,queue,object,correlationId);
        log.info("结束向【{}】中的【{}】队列发送消息",exchange,queue);
    }
}

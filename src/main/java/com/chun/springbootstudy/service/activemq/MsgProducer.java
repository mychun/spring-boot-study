package com.chun.springbootstudy.service.activemq;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class MsgProducer {
    @Resource
    JmsMessagingTemplate jmsTemplate;

    public void sendMessage(Destination destination, String msg) {

        jmsTemplate.convertAndSend(destination,msg);
    }
}

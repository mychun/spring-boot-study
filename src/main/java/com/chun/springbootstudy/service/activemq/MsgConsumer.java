package com.chun.springbootstudy.service.activemq;

import com.chun.springbootstudy.config.ActiveMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MsgConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MsgConsumer.class);

    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
//    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME)
    public void getMessage(String msg) {
        logger.info("收到的消息为:{}",msg);
    }

    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME,containerFactory ="topicListenerContainer" )
    public void getTopicMessage(String msg) {
        logger.info("收到的消息为:{}",msg);
    }
}



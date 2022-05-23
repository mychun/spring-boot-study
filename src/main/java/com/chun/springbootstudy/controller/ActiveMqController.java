package com.chun.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activeMq")
public class ActiveMqController {
//    private static final Logger logger = LoggerFactory.getLogger(ActiveMqController.class);
//
//    @Resource
//    MsgProducer msgProducer;
//
//    @Resource
//    Destination topic;
//
//    @Resource
//    Destination queue;
//    @RequestMapping("/send/queue")
//    public void sendMessage() {
//        String msg = "hello queue";
//        logger.info("消息发送");
//        msgProducer.sendMessage(queue, msg);
//    }
//
//    @RequestMapping ("/send/topic")
//    public String sendTopicMessage() {
//        logger.info("消息发送");
//        msgProducer.sendMessage(topic, "Topic: hello activemq!");
//        return "success";
//    }
}



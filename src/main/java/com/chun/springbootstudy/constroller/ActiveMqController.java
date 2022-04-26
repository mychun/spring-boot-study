package com.chun.springbootstudy.constroller;

import com.chun.springbootstudy.service.activemq.MsgProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

@RestController
@RequestMapping("/activeMq")
public class ActiveMqController {
    private static final Logger logger = LoggerFactory.getLogger(ActiveMqController.class);

    @Resource
    MsgProducer msgProducer;

    @Resource
    Destination queue;
    @RequestMapping("/send/queue")
    public void sendMessage() {
        String msg = "hello queue";
        logger.info("消息发送");
        msgProducer.sendMessage(queue, msg);
    }
}



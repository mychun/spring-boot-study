package com.chun.springbootstudy.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

@Configuration
public class ActiveMqConfig {
    /*** 发布/订阅模式队列名称 */
    public static final String TOPIC_NAME = "activemq.topic";
    /*** 点对点模式队列名称 */
    public static final String QUEUE_NAME = "activemq.queue";
    @Value("${spring.activemq.user}")
    private String user;
    @Value("${spring.activemq.password}")
    private String password;
    @Value("${spring.activemq.broker-url}")
    private  String brokerUrl;

    // @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(user, password, brokerUrl);
    }

    @Bean
    public Destination topic() {
        return new ActiveMQTopic(TOPIC_NAME);
    }

    @Bean
    public Destination queue() {
        return  new ActiveMQQueue(QUEUE_NAME);
    }
}



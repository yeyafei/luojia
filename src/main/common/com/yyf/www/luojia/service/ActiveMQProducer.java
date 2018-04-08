package com.yyf.www.luojia.service;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/** 
 * @Description: ActiveMQ Queue模式发送端 （Topic略）
 * 1.用于多工程之间解耦
 * 2.同一个工程间异步执行
 * @author  yyf 
 * @date    2018年4月8日 下午4:40:26 
 * @version 1.0 
 */
@Component
public class ActiveMQProducer {
@Resource
private JmsMessagingTemplate jmsMessagingTemplate;

@Autowired(required = false)
public void sendMsg(String destinationName ,String message){
	System.out.println("发送的消息:——————————>" + message);
	Destination destination = (Destination) new ActiveMQQueue(destinationName);
	jmsMessagingTemplate.convertAndSend(destination,message);
	
}
}


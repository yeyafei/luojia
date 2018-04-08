package com.yyf.www.luojia.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description: ActiveMQ Queue模式调用端 
 * 1.多工程解耦此方法在B工程中
 * 2.同工程一般用于数据库削峰
 * @author yyf
 * @date 2018年4月8日 下午4:40:26
 * @version 1.0
 */
@Component	
public class ActiveMQConsumer {
	@JmsListener(destination="luojia.queue")
	public void receiveMsg(String message) {
		System.out.println("收到的消息:——————————>" + message);
	}
}

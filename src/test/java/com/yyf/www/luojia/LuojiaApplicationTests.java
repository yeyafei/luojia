package com.yyf.www.luojia;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yyf.www.luojia.service.ActiveMQProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuojiaApplicationTests {
	@Resource
	private ActiveMQProducer producer;
	/**
	 * 测试ActiveMQ Queue模式 生产者投入消息
	 */
	@Test
	public void mqQueueTest() {
		for (int i = 1; i <= 10; i++)
			producer.sendMsg("luojia.queue", i + "");
	}

}

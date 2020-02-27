package com.wangrui.location.jms;

import static org.junit.jupiter.api.Assertions.*;

import javax.jms.JMSException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JmsServiceTest {

	@Autowired
	private JmsService js;
	
//	@Test
//	void testSend() throws JMSException {
//		js.send();
//	}
	
//	@Test
//	void testReceive() throws JMSException {
//		js.reveive();
//	}
	
	@Test
	void testPulish() throws JMSException, InterruptedException {
		js.listenMsg();
		
		System.out.println("已经启动监听。。。。。。。。。。。。。。。。10 秒后发送消息");
		Thread.sleep(1000*30);
		System.out.println("将发送消息----------------------------------");
		js.publish();
	}

}

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
	
	@Test
	void testReceive() throws JMSException {
		js.reveive();
	}

}

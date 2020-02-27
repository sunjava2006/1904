package com.wangrui.location.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyJmsService {

	@Autowired
	@Qualifier(value = "1904")
	private Queue queue1904;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(String msg) {
		this.jmsTemplate.convertAndSend(this.queue1904, msg);
	}
	
	
	
}

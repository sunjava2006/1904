package com.wangrui.location.jms;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

@Service
public class JmsService {

	private static QueueConnectionFactory factory;
	static {
		factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://0.0.0.0:61616");
	}
	
	public void send() throws JMSException {
		QueueConnection conn = null;
		Session session = null;
		
		try {
			conn = factory.createQueueConnection();
			conn.start();
			
			session = conn.createSession(true, QueueSession.AUTO_ACKNOWLEDGE);
			
			// 1 消息队列
			Queue queue1904 = session.createQueue("1904");
			// 2 生产者
		    MessageProducer producer = session.createProducer(queue1904);
		    producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 3 消息
		    TextMessage message = session.createTextMessage("tomorrow end SpringBoot.");
			// 4 发送消息
			producer.send(message);
			// 5提交
			session.commit();
			System.out.println("---------------------------消息已发送---------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
	}
	
	public void reveive() throws JMSException {
		QueueConnection conn = null;
		Session session = null;
		
		try {
			conn = factory.createQueueConnection();
			conn.start();
			
			session = conn.createSession(true, QueueSession.AUTO_ACKNOWLEDGE);
			// 1 创建队列 
			Queue q1904 = session.createQueue("1904");
			// 2创建消费者
			MessageConsumer consumer = session.createConsumer(q1904);
			
			// 3 取消息
			Message message = consumer.receive();
			
			TextMessage msg = (TextMessage) message;
			String txt = msg.getText();
			System.out.println("-------------- 收到消息 -----------------" +txt);
			
			//4
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			session.close();
			conn.close();
		}
	}
}

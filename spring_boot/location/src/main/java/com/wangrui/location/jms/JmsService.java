package com.wangrui.location.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import com.wangrui.location.entity.Student;

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
	
	
	//=====================================================================================
	
	public void listenMsg() throws JMSException {
		
			Connection conn =  factory.createConnection();
			conn.start();
			Session session =  conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 1 create topic
			Topic topic = session.createTopic("notify1904");
			// 2 create consumer
			MessageConsumer consumer = session.createConsumer(topic);
			// 3 监听消息
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					
					try {
						TextMessage msg = (TextMessage) message;
						System.out.println("======================================收到： "+msg.getText());
						// 4 commit
						session.commit();
					} catch (JMSException e) {
						e.printStackTrace();
					} finally {
						try {
							consumer.close();
							session.close();
							conn.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			});
	}
	
	
	public void publish() throws JMSException {
		Connection conn = null;
		Session session = null;
		MessageProducer producer = null;
		try {
			conn = factory.createConnection();
			conn.start();
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			//1 create topic
			Topic topic = session.createTopic("notify1904");
			
			// 2 create producer
			producer = session.createProducer(topic);
			
			// 3 create message
			
			TextMessage msg = session.createTextMessage("吴皓");
			
			// 4 publish message
			producer.send(msg);
			
			session.commit();
			
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			producer.close();
			session.close();
			conn.close();
		}
		
	}
	
}

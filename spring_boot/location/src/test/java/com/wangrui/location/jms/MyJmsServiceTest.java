package com.wangrui.location.jms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MyJmsServiceTest {

	@Autowired
	private MyJmsService mjs;
	
	
	@Test
	void testSend() {
		mjs.send("这是我发送的消息。");
	}

}

package com.wangrui.location.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class EmailServiceTest {
	
	@Autowired
	private EmailService email;

	@Test
	void testSend() throws MessagingException {
		this.email.sendHtmlMail();
	}

}

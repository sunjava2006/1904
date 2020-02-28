package com.wangrui.location.service;



import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendHtmlMail() throws MessagingException {
		MimeMessage mail = this.javaMailSender.createMimeMessage();
		MimeMessageHelper help = new MimeMessageHelper(mail);
		
		help.setFrom("392977758@qq.com");
		help.setTo("jkwangrui@126.com");
		help.setSubject("地理位置GG激活邮件");
		String msg = "激活，请点击：<a href=\"http://localhost:9999/active?id=123&activecode=1234567abcdefg\">"
				+ "http://localhost:9999/active?id=123&activecode=1234567abcdefg</a>";
		help.setText(msg, true); // 第二个参数为true，表示是html类型。
		help.setSentDate(new Date());
		this.javaMailSender.send(mail);

		
	}


	
}

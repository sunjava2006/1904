package com.wangrui.spring.aop.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	public Integer getScore(Integer studentID) {
		System.out.println("传入参数：" + studentID);
		if(studentID>0 && studentID <10 ) {
			return 85;
		}
		else if(studentID >10 && studentID<100) {
			return 90;
		}else {
			return 80;
		}
	}

}

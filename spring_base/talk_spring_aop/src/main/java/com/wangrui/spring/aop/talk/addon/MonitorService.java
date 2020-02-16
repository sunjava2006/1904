package com.wangrui.spring.aop.talk.addon;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitorService {
	
	
	
	// (切点表达式：查找哪个类，哪一个方法上，我要加上横切逻辑。)
	// 在service包下，所有类，所有方法
	//@Around(value = "execution(* com.wangrui.spring.aop.talk.service..*.*(..))")
	@Around("@annotation(com.wangrui.spring.aop.talk.addon.Monitor)")
	public Object useTime(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		System.out.println("--------------------开始监测"+methodName+"方法运行时间");
		Object v = null;
		long startTime = System.currentTimeMillis();
		
		// 要监测的业务方法
		v = pjp.proceed();
		
		
		long endTime = System.currentTimeMillis();
		System.out.println(methodName+"------用时："+ (endTime-startTime));
		return v;
	}
	
	@Before("execution(* com.wangrui.spring.aop.talk..*.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("***************************");
	}
	
	@After("execution(* com.wangrui.spring.aop.talk..*.*(..))")
	public void after() {
		System.out.println("***************************");
		System.out.println("***************************");
	}
	
	
}

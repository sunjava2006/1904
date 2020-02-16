package com.wangrui.spring.aop.demo.service;



import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class addonService {
	@Pointcut("execution(* com.wangrui.spring.aop.demo.service..*.*(..))")
	public void pc() {};
	
//	@Before(value = "pc()")
//	public boolean prompt(JoinPoint jp) {
//		System.out.println("--------------服务开始 ----------------------------------------------");
//		
//		// 获取目标对象
//		Object target = jp.getTarget();
//		System.out.println("target:"+target);
//		
//		// 获取方法执行的参数
//		Object[] args = jp.getArgs();
//		Arrays.asList(args).stream().forEach((i)->System.out.println("arg:"+i));
//		
//		// 获取方法签名 
//		Signature signature = jp.getSignature();
//		String name = signature.getName();
//		System.out.println("name:" + name);
//		// 获取定义的类名
//		String className = signature.getDeclaringTypeName();
//		System.out.println("DeclaringTypeNmae:" + className);
//		
//		return false;
//	}
//	
//	@AfterReturning(returning = "score", value = "pc()" )
//	public boolean end(JoinPoint jp, int score) {
//		System.out.println("============= 方法已经返回 ===============");
//		System.out.println("返回值是:"+score);
//		return false;
//	}
//	
//	@AfterThrowing(throwing = "ex", pointcut = "pc()")
//	public boolean end(JoinPoint jp, Exception ex) {
//		System.out.println("============异常："+ ex.getMessage());
//		return false;
//	}
//	
//	@After(value = "pc()")
//	public boolean end(JoinPoint jp) {
//		System.out.println("=============方法已经结束=============");
//		return false;
//	}
//	
	
	@Around(value = "pc()")
	public int around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("--------------^before----------------");
		int id = (int)pjp.getArgs()[0];
		if(id > 200) {
			System.out.println(id +" > 200");
			return -1;
		}else {
			System.out.println(id + " 没有>200");
			return (int) pjp.proceed();
		}
//		System.out.println("-----------------% after------------------");
//		return true;
	}

}

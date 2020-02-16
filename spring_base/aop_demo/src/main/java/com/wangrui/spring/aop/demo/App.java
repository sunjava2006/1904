package com.wangrui.spring.aop.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring.aop.demo.bean.Flyable;
import com.wangrui.spring.aop.demo.bean.Human;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
        String[] names = app.getBeanFactory().getBeanDefinitionNames();
        for(String s : names) {
        	System.out.println(s);
        }
        Human h = (Human) app.getBean("human");
        h.work();
        
        ((Flyable)h).fly();
    }
}

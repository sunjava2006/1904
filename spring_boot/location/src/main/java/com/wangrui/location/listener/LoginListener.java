package com.wangrui.location.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class LoginListener implements HttpSessionAttributeListener, ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("------------------%%%%%%%%%%%%%%%%%%%%%%%%%%%-------contextInitialized %%%%%%%%%%%%%%%%%%%%%%%%%%%------------------------------");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		if("userInfo".equals(attrName)) {
			System.out.println("-------------------监听到登录@@@@@@@@@@@@@@@@@@@@@@@@---------------");
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeRemoved(se);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeReplaced(se);
	}

}

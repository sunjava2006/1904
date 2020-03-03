package com.wangrui.small.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener {

   
    public void attributeAdded(HttpSessionBindingEvent evt)  { 
         String attributeName = evt.getName();
         if("userInfo".equals(attributeName)){
        	 System.out.println("-----------------------��������һ���û���¼��-------------");
        	ServletContext app =  evt.getSession().getServletContext();
        	synchronized (app) {
        		Integer count = (Integer) app.getAttribute(AppListener.MEMBER_ACCESS);
        		app.setAttribute(AppListener.MEMBER_ACCESS, count+1);
			}
        	
         }
    }

	
    public void attributeRemoved(HttpSessionBindingEvent evt)  { 
    	 String attributeName = evt.getName();
         if("userInfo".equals(attributeName)){
        	 System.out.println("-----------------------��������һ���û��˳���-------------");
        	ServletContext app =  evt.getSession().getServletContext();
        	synchronized (app) {
        		Integer count = (Integer) app.getAttribute(AppListener.MEMBER_ACCESS);
        		app.setAttribute(AppListener.MEMBER_ACCESS, count-1);
			}
        	
         }
    }

	
    public void attributeReplaced(HttpSessionBindingEvent evt)  { 
         // TODO Auto-generated method stub
    }
	
}

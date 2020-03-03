package com.wangrui.small.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AccessListener
 *
 */
@WebListener
public class AccessListener implements ServletRequestListener, HttpSessionListener {

   
   // 每创建一个请求（被访问一次），就触发一次
	public void requestInitialized(ServletRequestEvent evt)  { 
        ServletContext app = evt.getServletContext();
        Integer totalCount = (Integer)app.getAttribute(AppListener.TOTAL_ACCESS);
        app.setAttribute(AppListener.TOTAL_ACCESS, totalCount+1);
    }
	
    public void requestDestroyed(ServletRequestEvent evt)  { 
         // TODO Auto-generated method stub
    }

	//=================================================================
    

    public void sessionCreated(HttpSessionEvent evt)  { 
        System.out.println("-----------------创建了一个新会话---------------");
        ServletContext app = evt.getSession().getServletContext();
        synchronized (app) {
        	  Integer currCount = (Integer)app.getAttribute(AppListener.CURRENT_ACCESS);
              app.setAttribute(AppListener.CURRENT_ACCESS, currCount+1);
		}
      
    }
	
    public void sessionDestroyed(HttpSessionEvent evt)  { 
    	 System.out.println("-----------------一个会话失效了---------------");
         ServletContext app = evt.getSession().getServletContext();
         synchronized (app) {
        	 Integer currCount = (Integer)app.getAttribute(AppListener.CURRENT_ACCESS);
             app.setAttribute(AppListener.CURRENT_ACCESS, currCount-1);
		}
        
    }
	
}

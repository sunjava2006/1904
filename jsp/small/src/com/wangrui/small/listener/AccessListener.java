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

   
   // ÿ����һ�����󣨱�����һ�Σ����ʹ���һ��
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
        System.out.println("-----------------������һ���»Ự---------------");
        ServletContext app = evt.getSession().getServletContext();
        synchronized (app) {
        	  Integer currCount = (Integer)app.getAttribute(AppListener.CURRENT_ACCESS);
              app.setAttribute(AppListener.CURRENT_ACCESS, currCount+1);
		}
      
    }
	
    public void sessionDestroyed(HttpSessionEvent evt)  { 
    	 System.out.println("-----------------һ���ỰʧЧ��---------------");
         ServletContext app = evt.getSession().getServletContext();
         synchronized (app) {
        	 Integer currCount = (Integer)app.getAttribute(AppListener.CURRENT_ACCESS);
             app.setAttribute(AppListener.CURRENT_ACCESS, currCount-1);
		}
        
    }
	
}

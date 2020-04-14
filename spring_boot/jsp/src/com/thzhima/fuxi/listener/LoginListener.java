package com.thzhima.fuxi.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class LoginListener implements HttpSessionAttributeListener {

   
    public void attributeAdded(HttpSessionBindingEvent event)  { 
        String name =  event.getName();
        if("userInfo".equals(name)) {
        	System.out.println("一个同学登录了-----------------------");
        }
    }


    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }
	
}

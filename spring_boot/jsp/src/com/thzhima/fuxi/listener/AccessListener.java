package com.thzhima.fuxi.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AccessListener implements ServletRequestListener {
	public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("�����������һ�Ρ�");
        
        Integer c = (Integer) sre.getServletContext().getAttribute("accessCount");
        sre.getServletContext().setAttribute("accessCount", c+=1);
    }
   
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("һ����������ˡ�");
    }

	
    
	
}

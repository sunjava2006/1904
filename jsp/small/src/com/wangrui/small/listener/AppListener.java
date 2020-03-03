package com.wangrui.small.listener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	public static final String TOTAL_ACCESS = "totalAccess";
	public static final String CURRENT_ACCESS = "currentAccess";
	public static final String MEMBER_ACCESS = "memberAccess";
	
	// ����ʱ
	public void contextInitialized(ServletContextEvent evt)  { 
        ServletContext app = evt.getServletContext();
        
        // �����ļ���ʵ��path
        String path = app.getRealPath("/count.txt");
        
        FileReader reader = null;
        try {
			reader = new FileReader(path);
			char[] buffer = new char[10];
			int count = reader.read(buffer);
			String str = new String(buffer,0,count);
			Integer totalAccess = Integer.parseInt(str);
			app.setAttribute(TOTAL_ACCESS, totalAccess);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
        //-----------------��ʼ����������---------------------
        app.setAttribute(CURRENT_ACCESS, 0);
        
        //-----------------��ʼ����Ա����---------------------
        app.setAttribute(MEMBER_ACCESS, 0);
        
        
    }

	// �ر�Ӧ��
    public void contextDestroyed(ServletContextEvent evt)  { 
    	ServletContext app = evt.getServletContext();
    	String path = app.getRealPath("/count.txt");
    	
    	FileWriter writer = null;
    	
    	try {
			writer = new FileWriter(path);
			Integer count = (Integer) app.getAttribute(TOTAL_ACCESS);
			writer.write(String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
         
    }

	
   
	
}

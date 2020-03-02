package com.wangrui.location.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(path = "/test")
	@ResponseBody
	public String test1(@RequestHeader(name = "Connection") String connection, 
			            HttpServletRequest request) {
		
		
		return request.getQueryString();
	}
	
	@RequestMapping("/code")
	public void img( OutputStream out, HttpSession session) throws IOException {
		int ran = (int)(Math.random()*10000);
		String str = String.valueOf(ran);
		session.setAttribute("code", str);
		
//		OutputStream out = response.getOutputStream();
		
		BufferedImage img = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
	    g.fillRect(0, 0, 80, 40);
	    
	    Font f = new Font("宋体", Font.BOLD, 20);
	    g.setColor(Color.RED);
	    g.setFont(f);
	    
	    g.drawString(str, 20, 30);
	    
	    //------------------------------------------
	    for(int i=0;i<10;i++) {
	    	int x1 = (int)(Math.random()*30);
	    	int y1 = (int)(Math.random()*40);
	    	int x2 = (int)(Math.random()*100);
	    	int y2 = (int)(Math.random()*400);
	    	g.drawLine(x1, y1, x2, y2);
	    }
	    //------------------------------------------
	    
	    
	    ImageIO.write(img, "jpg", out);
		
	}

}

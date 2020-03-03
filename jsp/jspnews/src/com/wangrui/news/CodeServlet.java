package com.wangrui.news;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/code")
public class CodeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 产生随机数字符串，验证码。
		String str = String.valueOf((int)(Math.random()*100000));
		
		// 将验证码，加入到用户Session中。
		HttpSession session = request.getSession(true);
		session.setAttribute("code", str);
		
		// 产生一个验证码图片
		BufferedImage img = new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		
		// 填充白色背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 60, 30);
		
		g.setColor(Color.black);
		g.drawString(str, 10, 20);
		
		// 输出图片
		response.addHeader("Content-Type", "image/jpeg");
		ImageIO.write(img, "jpg", response.getOutputStream());
		
	}

}

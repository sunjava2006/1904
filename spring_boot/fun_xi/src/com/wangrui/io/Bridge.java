package com.wangrui.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bridge {

	// 使用桥接流，指定字符集，写入文件和读取文件内容。
	
	public static void write(String fileName, String msg, String charsetName) throws IOException {
		OutputStreamWriter ow = null;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			ow = new OutputStreamWriter(out, charsetName);
			ow.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ow.close();
			out.close();
		}
		
	}
	
	public static void read(String fileName, String charsetName) throws IOException {
		FileInputStream in = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		try {
			in = new FileInputStream(fileName);
			ir = new InputStreamReader(in, charsetName);
			br = new BufferedReader(ir);
			String s = null;
			StringBuffer sb = new StringBuffer();
			while(null != (s=br.readLine())) {
				sb.append(s);
			}
			System.out.println(sb);
//			char[] buffer  = new char[2];
//			StringBuffer sb = new StringBuffer();
//			int count = -1;
//			while(-1 !=(count=ir.read(buffer))) {
//				sb.append(buffer, 0, count);
//			}
//			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ir.close();
			in.close();
		}
	}
	
	public static void write2(String fileName, String msg, String charsetName) throws IOException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			byte[] data = msg.getBytes(charsetName);
			out.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Bridge.write2("d:/b2.txt", "今天上课有一个同学打呼。。。", "utf-8");
		Bridge.read("d:/b2.txt", "utf-8");
	}
}

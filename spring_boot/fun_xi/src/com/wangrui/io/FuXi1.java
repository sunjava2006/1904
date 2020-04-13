package com.wangrui.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FuXi1 {

	// ���롢�������������ķ����кʹ�������ݷ�Ϊ��
	//   �ֽ� InputStream OutputStream
	//   �ַ� Reader      Writer
	
	public static void copy(String source, String target) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		byte[] buffer = new byte[1024];
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(target);
			int count = -1;
			do {
				count = in.read(buffer, 0, buffer.length); // read�����������������ֽ����������ļ�û�����ݿɶ�����-1��
				if(-1 != count) {
					out.write(buffer, 0, count);
				}
			}while(-1 != count);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
			in.close();
		}
	}
	
	
	/**
	 * �����ִ���ָ�����ļ���
	 * @param fileName
	 * @param msg
	 * @throws IOException 
	 */
	public static void write(String fileName, String msg, boolean append) throws IOException {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName , append);
			fw.write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fw.close();
		}
	}
	
	public static void read(String fileName) throws IOException {
		FileReader fr = null;
		char[] buffer = new char[2];
		try {
			fr = new FileReader(fileName);
			int count = -1;
			StringBuffer sb = new StringBuffer();
			while(-1 != (count=fr.read(buffer))){
				sb.append(buffer, 0, count);
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fr.close();
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
//		FuXi1.copy("C:\\Users\\wangrui\\Pictures\\Saved Pictures\\image1.jpg", 
//				   "C:\\Users\\wangrui\\Pictures\\Saved Pictures\\image2.jpg");
		
		FuXi1.write("d:/a.txt", "������Ҫץ��ʱ�临ϰ��", true);
		FuXi1.read("d:/a.txt");
	}
}

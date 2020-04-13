package com.wangrui.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializable {

	public static void write(Object o, String file) throws IOException {
		ObjectOutputStream os = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(file);
			os = new ObjectOutputStream(fout);
			os.writeObject(o);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fout.close();
			os.close();
		}
	}
	
	public static void read(String file) throws IOException {
		ObjectInputStream oi = null;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(file);
			oi = new ObjectInputStream(fin);
			Object o = oi.readObject();
			People p = (People)o;
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fin.close();
			oi.close();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
//		People p = new People();
//		p.setName("GG");
//		
//		write(p, "d:/gg.txt");
		
		read("d:/gg.txt");
	}
}

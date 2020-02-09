package com.thzhima.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		
		DateFormat fmt = DateFormat.getDateInstance(DateFormat.FULL);
		String str = fmt.format(now);
		System.out.println(str);
		//=====================================================
		
		SimpleDateFormat sfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str2 = sfmt.format(now);
		System.out.println(str2);
		Date d = sfmt.parse(str2);
		System.out.println(d);
		
	}
}

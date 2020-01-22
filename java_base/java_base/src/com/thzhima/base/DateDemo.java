package com.thzhima.base;

import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date now = new Date();
		
		Date d = new Date(1995-1900,0,1);
		
		Calendar c = Calendar.getInstance();
//		c.set(2020, 0, 20);
		c.set(Calendar.YEAR, 2020);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		System.out.println(c.get(Calendar.YEAR));
		
		String[] week = {"日","一","二"};
		
		String str = String.format("%d-%d-%d,星期%s", c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH), week[c.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(str);
		d = c.getTime(); // 日历转date
		System.out.println(d);
		
		// date -> calendar
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d);
		System.out.println(c2);
		String str2 = String.format("%d-%d-%d,星期%s", c2.get(Calendar.YEAR), c2.get(Calendar.MONTH)+1,c2.get(Calendar.DAY_OF_MONTH), week[c2.get(Calendar.DAY_OF_WEEK)-1]);
		System.out.println(str2);
		
	}
}

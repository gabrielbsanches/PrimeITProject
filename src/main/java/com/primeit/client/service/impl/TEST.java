package com.primeit.client.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TEST {

	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		//current date
		Date currentDate = (Date) c.getTime();
		
		//ONE week after the current date
		c.add(Calendar.DATE,7);
		Date nextDate = (Date) c.getTime();
		
		//TWO weeks after current date
		c.add(Calendar.DATE, 7);
		Date futureDate = (Date) c.getTime();
		
		//ONE week before current date
		c.add(Calendar.DATE, -21);
		Date lastDate = (Date) c.getTime();
		
		System.out.println(currentDate);
		System.out.println(nextDate);      
		System.out.println(futureDate);      
		System.out.println(lastDate); 

	}

}

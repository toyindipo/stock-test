package com.progno.stock.utils;

import java.util.Calendar;

public class DateLibs {
	//This method returns array of strings of size 2 containing the dates of previous 
	//week Monday and Friday respectively
	public static String[] getPreviousMonAndFriday() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DATE, -1 - (day % 7));
		String[] days = new String[2];
		days[1] = String.format("%d-%d-%d", calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
		calendar.add(Calendar.DATE, -5);
		days[0] = String.format("%d-%d-%d", calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
		
		return days;
	}
}

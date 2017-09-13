package com.whq.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTimeUtils {
	public static List<Date> converDates(String resouceDate){
		List<Date> list = new ArrayList<Date>();
		if(null!=resouceDate&&!"".equals(resouceDate.trim())){
			String[] rds = resouceDate.split(" ");
			for (String d : rds) {
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
				Date date = null;
				try {
					if(!"".equals(d)){
						date = sdf.parse(d);
						list.add(date);
					}
				} catch (Exception e) {
					System.out.println("日期转换异常！");
					e.printStackTrace();
				}
				
			}
		}
		return list;
	}
	/**
	 * 将日期转换为字符串
	 * @param date
	 * @return
	 */
	public static String toDateString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}
	public static boolean isWeek(Date date){
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY;
	}
}

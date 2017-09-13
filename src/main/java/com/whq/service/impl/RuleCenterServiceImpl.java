package com.whq.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.whq.common.util.DateTimeUtils;
import com.whq.service.RuleCenterService;

public class RuleCenterServiceImpl implements RuleCenterService {

	public boolean isLate(List<Date> times, Date date) {
		try {
			if(DateTimeUtils.isWeek(date)){
				return false;
			}
			Collections.sort(times);
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			Date lastTime = sdf.parse("09:31");
			if(times.get(0).getTime() > lastTime.getTime()){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isWorkingOverTime(List<Date> times, Date date) {
		if(DateTimeUtils.isWeek(date)){
			long mt = times.get(times.size()-1).getTime() - times.get(0).getTime();
			long h = mt/1000/3600;
			if(h>=4L){
				return true;
			}
		}
		return false;
	}

	public boolean isLeftEarly(List<Date> times, Date date) {
		try {
			if(DateTimeUtils.isWeek(date)){
				return false;
			}
			
			Collections.sort(times);
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			
			Date early = sdf.parse("17:31");
			if(times.get(times.size()-1).getTime() < early.getTime()){
				return true;
			}
			Date tempLast = sdf.parse("09:01");
			if(times.get(0).getTime() >= tempLast.getTime()){
				return false;
			}

			Date early2 = sdf.parse("18:01");
			if(times.get(times.size()-1).getTime() <= early2.getTime()){
				Date last = sdf.parse("09:01");
				if((times.get(0).getTime()-last.getTime())>(times.get(times.size()-1).getTime() - early.getTime())){
					return true;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isMayBeNotWork(Date date) {
		if(DateTimeUtils.isWeek(date)){
			return false;
		}
		return true;
	}
	public boolean isWorkingOverTimeBreak(List<Date> times, Date date) {
		try {
			if(DateTimeUtils.isWeek(date)){
				return false;
			}
			Collections.sort(times);
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			Date lastTime = sdf.parse("21:30");
			if(times.get(times.size()-1).getTime()>=lastTime.getTime()){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isWorkingOverTimeEeat(List<Date> times, Date date) {
		try {
			if(DateTimeUtils.isWeek(date)){
				return false;
			}
			Collections.sort(times);
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			Date lastTime = sdf.parse("19:30");
			if(times.get(times.size()-1).getTime()>=lastTime.getTime()){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
}

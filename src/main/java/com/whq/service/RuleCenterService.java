package com.whq.service;

import java.util.Date;
import java.util.List;

/**
 * 规则中心
 * @author whq
 *
 */
public interface RuleCenterService {
	/**
	 * 是否迟到
	 * @param time 打卡时间
	 * @param date 日期
	 * @return
	 */
	boolean isLate(List<Date> time,Date date);
	/**
	 * 是否加班 
	 * @param time 打卡时间
	 * @return date 日期
	 */
	boolean isWorkingOverTime(List<Date> time,Date date);
	/**
	 * 加班餐补
	 * @param time
	 * @param date
	 * @return
	 */
	boolean isWorkingOverTimeEeat(List<Date> time,Date date);
	/**
	 * 加班调体
	 * @param time
	 * @param date
	 * @return
	 */
	boolean isWorkingOverTimeBreak(List<Date> time,Date date);
	/**
	 * 是否早退
	 * @param time 打卡时间
	 * @param data 日期
	 * @return
	 */
	boolean isLeftEarly(List<Date> time,Date date);
	/**
	 * 有可能存在旷工
	 * 因为节日是国家给的，程序不可能去判断假日
	 * @return
	 */
	boolean isMayBeNotWork(Date date);
}

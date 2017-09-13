package com.whq.core.model;

import java.util.Date;

public class Employee {
	/**
	 * 考勤编号
	 */
	public String attendanceNo;	
	/**
	 * 姓名
	 */
	public String name;
	/**
	 * 部门
	 */
	public String departMent;
	/**
	 * 打卡日期
	 */
	public Date attendanceDate;
	/**
	 * 打卡时间
	 */
	public String attendanceTime;
	public String getAttendanceNo() {
		return attendanceNo;
	}
	public void setAttendanceNo(String attendanceNo) {
		this.attendanceNo = attendanceNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartMent() {
		return departMent;
	}
	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendanceTime() {
		return attendanceTime;
	}
	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	@Override
	public String toString() {
		return "Employee [attendanceNo=" + attendanceNo + ", name=" + name
				+ ", departMent=" + departMent + ", attendanceDate="
				+ attendanceDate + ", attendanceTime=" + attendanceTime + "]";
	}
	
}

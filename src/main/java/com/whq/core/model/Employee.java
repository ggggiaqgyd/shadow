package com.whq.core.model;

import java.util.Date;

public class Employee {
	/**
	 * ���ڱ��
	 */
	public String attendanceNo;	
	/**
	 * ����
	 */
	public String name;
	/**
	 * ����
	 */
	public String departMent;
	/**
	 * ������
	 */
	public Date attendanceDate;
	/**
	 * ��ʱ��
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

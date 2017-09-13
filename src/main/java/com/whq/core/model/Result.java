package com.whq.core.model;

import com.whq.service.FileResultService;

public class Result {
	private Employee employee;
	private String resultMsg;
	/**
	 * «©µΩ¿‡–Õ
	 */
	private String type;
	public Result() {
		// TODO Auto-generated constructor stub
	}
	public Result(Employee employee, String resultMsg,String type) {
		super();
		this.type = type;
		this.employee = employee;
		this.resultMsg = resultMsg;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

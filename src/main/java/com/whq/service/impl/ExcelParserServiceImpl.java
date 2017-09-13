package com.whq.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;

import com.whq.core.model.Employee;
import com.whq.service.ExcelParserService;

public class ExcelParserServiceImpl implements ExcelParserService{
	public Employee parseRowToEntity(HSSFRow row) {
		 Employee employee = new Employee();
		 employee.setAttendanceNo(row.getCell(0).getStringCellValue());
		 employee.setName(row.getCell(1).getStringCellValue());
		 employee.setDepartMent(row.getCell(2).getStringCellValue());
		 if(null!=row.getCell(2).getStringCellValue()&&!"".equals(row.getCell(2).getStringCellValue())){
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			 try {
				Date date = sdf.parse(row.getCell(3).getStringCellValue());
				employee.setAttendanceDate(date);
			} catch (ParseException e) {
				System.out.println("日期转换异常！");
				e.printStackTrace();
			}
		 }
		 employee.setAttendanceTime(row.getCell(4).getStringCellValue());
		return employee;
	}

}

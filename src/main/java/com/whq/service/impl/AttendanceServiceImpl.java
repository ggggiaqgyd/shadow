package com.whq.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.whq.common.util.DateTimeUtils;
import com.whq.common.util.StringUtils;
import com.whq.core.model.Employee;
import com.whq.core.model.Result;
import com.whq.service.AttendanceService;
import com.whq.service.ExcelParserService;
import com.whq.service.FileResultService;
import com.whq.service.ResultHandleCenterService;
import com.whq.service.RuleCenterService;

public class AttendanceServiceImpl implements AttendanceService{
	private static Logger logger = Logger.getLogger(AttendanceServiceImpl.class);  
	private ExcelParserService excelParserService;
	private FileResultService fileResultService;
	private RuleCenterService ruleCenterService;
	private ResultHandleCenterService resultHandleCenterService;
	public void start(String path) {
		fileResultService.init(path);
        FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(path);
	        //1.读取工作簿  
	        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);  
	        //2.读取工作表  
	        HSSFSheet sheet = workbook.getSheetAt(0);
	        //到得总行数
	        int count = sheet.getPhysicalNumberOfRows();
	        //第一行为表头，所以下标从1开始
	        List<Result> results = new ArrayList<Result>();
	        for (int i = 1; i < count; i++) {
	        	HSSFRow row = sheet.getRow(i);
	        	Employee employee = excelParserService.parseRowToEntity(row);
	        	analysis(employee,results);
			}
	        resultHandleCenterService.handleResults(results);
		} catch (FileNotFoundException e) {
			logger.error("没有找到相关的文件！",e);
		} catch (Exception e) {
			logger.error("系统错误，请联系管理员！",e);
		}
	}
	/**
	 * 分析员工出席情况
	 * @param employee
	 */
	private void analysis(Employee employee, List<Result> results) {
		boolean success = true;
		String d = DateTimeUtils.toDateString(employee.getAttendanceDate());
		String str = "员工:"+employee.getName()+"-->编号:"+employee.getAttendanceNo()+","+"在"+d;
		
		if(StringUtils.isEmpty(employee.getAttendanceTime())){
			if(ruleCenterService.isMayBeNotWork(employee.getAttendanceDate())){
				Result result = new Result(employee, str+"-->可能存在矿工！","可能矿工");
				results.add(result);
				success = false;
			}
		}else{
			Date date = employee.getAttendanceDate();
			List<Date> time = DateTimeUtils.converDates(employee.getAttendanceTime());
			if(ruleCenterService.isLate(time, date)){
				Result result = new Result(employee, str+"-->迟到","迟到");
				results.add(result);
				success = false;
			}
			if(ruleCenterService.isLeftEarly(time, date)){
				Result result = new Result(employee, str+"-->早退！","早退");
				results.add(result);
				success = false;
			}
			if(ruleCenterService.isWorkingOverTime(time, date)){
				Result result = new Result(employee, str+"-->周未加班！","周未加班");
				results.add(result);
				success = false;
			}
			if(ruleCenterService.isWorkingOverTimeEeat(time, date)){
				Result result = new Result(employee, str+"-->->加班餐补！","加班餐补");
				results.add(result);
				success = false;
			}
			if(ruleCenterService.isWorkingOverTimeBreak(time, date)){
				Result result = new Result(employee, str+"-->加班调休！","加班调休");
				results.add(result);
				success = false;
			}
		}
		if(success){
			Result result = new Result(employee, str+"-->正常！","正常");
			results.add(result);
		}
	}
	public ExcelParserService getExcelParserService() {
		return excelParserService;
	}
	public void setExcelParserService(ExcelParserService excelParserService) {
		this.excelParserService = excelParserService;
	}
	public FileResultService getFileResultService() {
		return fileResultService;
	}
	public void setFileResultService(FileResultService fileResultService) {
		this.fileResultService = fileResultService;
	}
	public RuleCenterService getRuleCenterService() {
		return ruleCenterService;
	}
	public void setRuleCenterService(RuleCenterService ruleCenterService) {
		this.ruleCenterService = ruleCenterService;
	}
	public ResultHandleCenterService getResultHandleCenterService() {
		return resultHandleCenterService;
	}
	public void setResultHandleCenterService(
			ResultHandleCenterService resultHandleCenterService) {
		this.resultHandleCenterService = resultHandleCenterService;
	}
	
}

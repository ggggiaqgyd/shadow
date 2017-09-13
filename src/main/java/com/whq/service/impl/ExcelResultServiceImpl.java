package com.whq.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.whq.common.util.DateTimeUtils;
import com.whq.core.model.Employee;
import com.whq.core.model.Result;
import com.whq.service.FileResultService;

public class ExcelResultServiceImpl implements FileResultService{
	private File file;	//总文件
	public void init(String path) {
		try {
			File f = new File(path);
			String dir = null;
			if(f.exists()){
				dir = f.getParent();
			}else{
				System.out.println("文件不存在！");
				return;
			}
			file = new File(new String(dir.getBytes(),"gbk")+File.separator+"总结果.xls");
			if(file.exists()){
				file.delete();
			}
			initExcelHead();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void initExcelHead() {
		 try {
			HSSFWorkbook workbook = new HSSFWorkbook();  
			HSSFSheet sheet = workbook.createSheet("结果");
			HSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("编号");
			row.createCell(1).setCellValue("姓名");
			row.createCell(2).setCellValue("日期");
			row.createCell(3).setCellValue("类型");
			row.createCell(4).setCellValue("原始数据");
			FileOutputStream fOut = new FileOutputStream(file);  
			workbook.write(fOut);  
			fOut.flush();  
			fOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}

	public void appendLine(String str) {
		// TODO Auto-generated method stub
		
	}

	public void appendLine(Result result, String type) {
        try {
			POIFSFileSystem ps=new POIFSFileSystem(new FileInputStream(file));  //使用POI提供的方法得到excel的信息  
			HSSFWorkbook wb=new HSSFWorkbook(ps);
		    HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
		    FileOutputStream out = new FileOutputStream(file);
		    HSSFRow row=sheet.createRow((sheet.getLastRowNum()+1)); //在现有行号后追加数据
		    Employee employee = result.getEmployee();
			row.createCell(0).setCellValue(employee.getAttendanceNo());
			row.createCell(1).setCellValue(employee.getName());
			row.createCell(2).setCellValue(DateTimeUtils.toDateString(employee.getAttendanceDate()));
			row.createCell(3).setCellValue(type);
			row.createCell(4).setCellValue(employee.getAttendanceTime());
	        out.flush();  
	        wb.write(out);    
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void appendExcel(List<Result> results) {
		try {
			POIFSFileSystem ps=new POIFSFileSystem(new FileInputStream(file));  //使用POI提供的方法得到excel的信息  
			HSSFWorkbook wb=new HSSFWorkbook(ps);
			HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
			FileOutputStream out = new FileOutputStream(file);
			for (Result result : results) {
			    HSSFRow row=sheet.createRow((sheet.getLastRowNum()+1)); //在现有行号后追加数据
			    Employee employee = result.getEmployee();
				row.createCell(0).setCellValue(employee.getAttendanceNo());
				row.createCell(1).setCellValue(employee.getName());
				row.createCell(2).setCellValue(DateTimeUtils.toDateString(employee.getAttendanceDate()));
				row.createCell(3).setCellValue(result.getType());
				row.createCell(4).setCellValue(employee.getAttendanceTime());
			}
	        out.flush();  
	        wb.write(out);    
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private Date converType(String file2) {
		// TODO Auto-generated method stub
		return null;
	}

}

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
	private File file;	//���ļ�
	public void init(String path) {
		try {
			File f = new File(path);
			String dir = null;
			if(f.exists()){
				dir = f.getParent();
			}else{
				System.out.println("�ļ������ڣ�");
				return;
			}
			file = new File(new String(dir.getBytes(),"gbk")+File.separator+"�ܽ��.xls");
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
			HSSFSheet sheet = workbook.createSheet("���");
			HSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("���");
			row.createCell(1).setCellValue("����");
			row.createCell(2).setCellValue("����");
			row.createCell(3).setCellValue("����");
			row.createCell(4).setCellValue("ԭʼ����");
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
			POIFSFileSystem ps=new POIFSFileSystem(new FileInputStream(file));  //ʹ��POI�ṩ�ķ����õ�excel����Ϣ  
			HSSFWorkbook wb=new HSSFWorkbook(ps);
		    HSSFSheet sheet=wb.getSheetAt(0);  //��ȡ����������Ϊһ��excel�����ж��������
		    FileOutputStream out = new FileOutputStream(file);
		    HSSFRow row=sheet.createRow((sheet.getLastRowNum()+1)); //�������кź�׷������
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
			POIFSFileSystem ps=new POIFSFileSystem(new FileInputStream(file));  //ʹ��POI�ṩ�ķ����õ�excel����Ϣ  
			HSSFWorkbook wb=new HSSFWorkbook(ps);
			HSSFSheet sheet=wb.getSheetAt(0);  //��ȡ����������Ϊһ��excel�����ж��������
			FileOutputStream out = new FileOutputStream(file);
			for (Result result : results) {
			    HSSFRow row=sheet.createRow((sheet.getLastRowNum()+1)); //�������кź�׷������
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

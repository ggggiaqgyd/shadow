package com.whq.service;

import org.apache.poi.hssf.usermodel.HSSFRow;

import com.whq.core.model.Employee;

/**
 * 20170617 wanghq01 excel������
 * @author whq
 *
 */
public interface ExcelParserService {
	/**
	 * ��excel��һ������ת��Ϊһ��ʵ�����
	 * @param row
	 * @return
	 */
	Employee parseRowToEntity(HSSFRow row);
}

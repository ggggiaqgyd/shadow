package com.whq.service;

import org.apache.poi.hssf.usermodel.HSSFRow;

import com.whq.core.model.Employee;

/**
 * 20170617 wanghq01 excel解析类
 * @author whq
 *
 */
public interface ExcelParserService {
	/**
	 * 将excel的一行数据转换为一个实体对像
	 * @param row
	 * @return
	 */
	Employee parseRowToEntity(HSSFRow row);
}

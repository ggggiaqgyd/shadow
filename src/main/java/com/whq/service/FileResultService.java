package com.whq.service;

import java.util.List;

import com.whq.core.model.Result;

public interface FileResultService {
	/**
	 * 初始化文件 
	 * @param path
	 */
	void init(String path);
	/**
	 * 追加一行
	 * @param str
	 */
	void appendLine(String str);
	/**
	 * 选择不同的文件进行追加
	 * @param str
	 * @param file
	 */
	void appendLine(Result result,String file);
	/**
	 * 将数据批量加截到excel中
	 * @param results
	 */
	void appendExcel(List<Result> results);
}

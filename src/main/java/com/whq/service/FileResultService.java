package com.whq.service;

import java.util.List;

import com.whq.core.model.Result;

public interface FileResultService {
	/**
	 * ��ʼ���ļ� 
	 * @param path
	 */
	void init(String path);
	/**
	 * ׷��һ��
	 * @param str
	 */
	void appendLine(String str);
	/**
	 * ѡ��ͬ���ļ�����׷��
	 * @param str
	 * @param file
	 */
	void appendLine(Result result,String file);
	/**
	 * �����������ӽص�excel��
	 * @param results
	 */
	void appendExcel(List<Result> results);
}

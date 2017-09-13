package com.whq.service;

import java.util.List;

import com.whq.core.model.Result;

/**
 * 20170617 wanghq01 ���ؽ����������
 * @author whq
 *
 */
public interface ResultHandleCenterService {
	/**
	 * �������ؽ��
	 * @param fileResultService
	 */
	void handleResult(Result result);
	/**
	 * ѡ���ļ�����׷��
	 * @param result
	 * @param file
	 */
	void handleResult(Result result,String file);
	/**
	 * ������
	 * @param results
	 */
	void handleResults(List<Result> results);
}

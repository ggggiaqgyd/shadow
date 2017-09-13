package com.whq.service;

import java.util.List;

import com.whq.core.model.Result;

/**
 * 20170617 wanghq01 返回解果处理中心
 * @author whq
 *
 */
public interface ResultHandleCenterService {
	/**
	 * 将处理返回结果
	 * @param fileResultService
	 */
	void handleResult(Result result);
	/**
	 * 选择文件进行追加
	 * @param result
	 * @param file
	 */
	void handleResult(Result result,String file);
	/**
	 * 处理结果
	 * @param results
	 */
	void handleResults(List<Result> results);
}

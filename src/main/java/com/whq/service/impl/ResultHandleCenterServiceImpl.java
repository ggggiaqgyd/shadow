package com.whq.service.impl;

import java.util.List;

import com.whq.core.model.Result;
import com.whq.service.FileResultService;
import com.whq.service.ResultHandleCenterService;

public class ResultHandleCenterServiceImpl implements ResultHandleCenterService{
	FileResultService fileResultService;
	public void handleResult(Result result) {
		fileResultService.appendLine(result.getResultMsg());
	}
	public void handleResult(Result result, String file) {
		fileResultService.appendLine(result,file); 
	}
	public void handleResults(List<Result> results) {
		fileResultService.appendExcel(results); 
	}
	public FileResultService getFileResultService() {
		return fileResultService;
	}
	public void setFileResultService(FileResultService fileResultService) {
		this.fileResultService = fileResultService;
	}
	
}

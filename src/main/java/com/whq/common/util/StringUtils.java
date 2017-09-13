package com.whq.common.util;

public class StringUtils {
	public static boolean isNotEmpty(String str){
		return str!=null&&!"".equals(str.trim());
	}
	public static boolean isEmpty(String str){
		return str==null || "".equals(str.trim());
	}
}

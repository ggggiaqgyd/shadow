package com.whq.main;

import java.util.Scanner;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.whq.service.AttendanceService;

/**
 * 影子考勤系统主入口
 * @author whq
 *
 */
public class Shadow {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        System.out.println("======欢迎使用影子考勤系统1.0=====");
        System.out.println("请将文件拖到此窗口，按回车继续："); 
        String line = s.nextLine(); 
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		AttendanceService attendanceService = (AttendanceService)beanFactory.getBean("attendanceService");
		attendanceService.start(line);
	}
}

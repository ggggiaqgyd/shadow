package com.whq.main;

import java.util.Scanner;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.whq.service.AttendanceService;

/**
 * Ӱ�ӿ���ϵͳ�����
 * @author whq
 *
 */
public class Shadow {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        System.out.println("======��ӭʹ��Ӱ�ӿ���ϵͳ1.0=====");
        System.out.println("�뽫�ļ��ϵ��˴��ڣ����س�������"); 
        String line = s.nextLine(); 
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		AttendanceService attendanceService = (AttendanceService)beanFactory.getBean("attendanceService");
		attendanceService.start(line);
	}
}

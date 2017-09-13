package com.whq.service;

import java.util.Date;
import java.util.List;

/**
 * ��������
 * @author whq
 *
 */
public interface RuleCenterService {
	/**
	 * �Ƿ�ٵ�
	 * @param time ��ʱ��
	 * @param date ����
	 * @return
	 */
	boolean isLate(List<Date> time,Date date);
	/**
	 * �Ƿ�Ӱ� 
	 * @param time ��ʱ��
	 * @return date ����
	 */
	boolean isWorkingOverTime(List<Date> time,Date date);
	/**
	 * �Ӱ�Ͳ�
	 * @param time
	 * @param date
	 * @return
	 */
	boolean isWorkingOverTimeEeat(List<Date> time,Date date);
	/**
	 * �Ӱ����
	 * @param time
	 * @param date
	 * @return
	 */
	boolean isWorkingOverTimeBreak(List<Date> time,Date date);
	/**
	 * �Ƿ�����
	 * @param time ��ʱ��
	 * @param data ����
	 * @return
	 */
	boolean isLeftEarly(List<Date> time,Date date);
	/**
	 * �п��ܴ��ڿ���
	 * ��Ϊ�����ǹ��Ҹ��ģ����򲻿���ȥ�жϼ���
	 * @return
	 */
	boolean isMayBeNotWork(Date date);
}

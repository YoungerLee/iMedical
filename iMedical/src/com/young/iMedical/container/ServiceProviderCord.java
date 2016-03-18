package com.young.iMedical.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProviderCord {

	protected static ApplicationContext ac;

	/**
	 * @Name: load
	 * @Description: 加载beans.xml文件(filename放置的是beans.xml)
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-18 （创建日期）
	 * @Parameters: String filename（传递beans.xml文件）
	 * @Return: 无
	 */
	public static void load(String filename) {
		ac = new ClassPathXmlApplicationContext(filename);
	}
}
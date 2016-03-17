package com.young.iMedical.util;

import java.lang.reflect.ParameterizedType;

public class GenericSuperClass {
	/**
	 * 范类转换，转换成对应的对象
	 * 
	 * @param clazz
	 * @return 返回对象
	 */
	public static Class getClass(Class clazz) {
		ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
		Class entity = (Class) pt.getActualTypeArguments()[0];
		return entity;
	}
}
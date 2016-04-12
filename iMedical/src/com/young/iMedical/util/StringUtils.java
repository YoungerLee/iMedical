package com.young.iMedical.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StringUtils {
	private StringUtils() {

	}

	public static java.util.Date stringConvertDate(String dateString) {
		java.util.Date utilDate = null;
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd")
					.parse(dateString);
			utilDate = new java.util.Date(date.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return utilDate;
	}

	public static java.sql.Date stringToSqlDate(String dateString) {
		java.sql.Date sqlDate = null;
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd")
					.parse(dateString);
			sqlDate = new java.sql.Date(date.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	public static java.sql.Time stringToSqlTime(String timeString) {
		java.sql.Time sqlTime = null;
		try {
			java.util.Date date = new SimpleDateFormat("HH:mm:ss")
					.parse(timeString);
			sqlTime = new java.sql.Time(date.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlTime;
	}

	public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	public static String addDate(java.util.Date nowDate, int day) {
		String plusDate = null;
		try {
			Calendar fromCal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			fromCal.setTime(nowDate);
			fromCal.add(Calendar.DATE, day);
			plusDate = dateFormat.format(fromCal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plusDate;
	}

	public static Integer[] stringArrayToIntegerArray(String[] strArray) {
		Integer[] intArray = new Integer[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}
}

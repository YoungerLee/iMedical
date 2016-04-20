package com.young.iMedical.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.young.iMedical.domain.Log;

public interface LogService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.LogServiceImpl";

	void saveUserLog(HttpServletRequest request, String details);

	void saveDoctorLog(HttpServletRequest request, String details);

	List<Log> findLogListByCondition(Log log);

	void deleteLogByLogId(Integer id);

	void deleteLogByLogIDs(Integer[] ids);
}

package com.young.iMedical.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.LogDao;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Log;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.LogService;

@Transactional(readOnly = true)
@Service(LogService.SERVICE_NAME)
public class LogServiceImpl implements LogService {
	@Resource(name = LogDao.SERVICE_NAME)
	private LogDao logDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUserLog(HttpServletRequest request, String details) {
		Log log = new Log();
		log.setIpAddress(request.getRemoteAddr());// IP地址
		User user = (User) request.getSession().getAttribute("user");
		log.setOperName(user.getUsername());// 操作人
		log.setOperTime(new java.sql.Timestamp(System.currentTimeMillis()));// 操作时间
		log.setDetails(details);
		logDao.save(log);
	}

	@Override
	public void saveDoctorLog(HttpServletRequest request, String details) {
		Log log = new Log();
		log.setIpAddress(request.getRemoteAddr());// IP地址
		Doctor doctor = (Doctor) request.getSession().getAttribute("user");
		log.setOperName(doctor.getName());// 操作人
		log.setOperTime(new java.sql.Timestamp(System.currentTimeMillis()));// 操作时间
		log.setDetails(details);
		logDao.save(log);
	}

	@Override
	public List<Log> findLogListByCondition(Log log) {
		// 组织查询和排序的条件
		String hqlWhere = "";
		List<String> paramsList = new ArrayList<String>();
		if (log != null && log.getOperName() != null
				&& !log.getOperName().equals("")) {
			hqlWhere += " and o.operName like ?";
			paramsList.add("%" + log.getOperName() + "%");
		}
		Object[] params = paramsList.toArray();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.operTime", "desc");
		List<Log> list = logDao.findCollectionByConditionNoPage(hqlWhere,
				params, orderby);
		return list;
	}

	@Override
	public void deleteLogByLogId(String id) {
		logDao.deleteObjectByID(id);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteLogByLogIDs(String[] ids) {
		logDao.deleteObjectByIDs(ids);
	}
}

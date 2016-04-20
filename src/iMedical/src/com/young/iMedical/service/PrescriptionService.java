package com.young.iMedical.service;

import java.util.List;

import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;

public interface PrescriptionService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.PrescriptionServiceImpl";

	/**
	 * 添加药方
	 * 
	 * @param prescription
	 */
	void savePres(Prescription prescription);

	/**
	 * 根据医生用户查找药方
	 * 
	 * @param id
	 * @return 结果的集合
	 */
	List<Prescription> findPresByDoc(Doctor doctor);

	/**
	 * 根据普通用户查找药方
	 * 
	 * @param id
	 * @return 结果的集合
	 */
	List<Prescription> findPresByUser(User user);

	/**
	 * 根据id查找药方
	 * 
	 * @param id
	 * @return 结果的集合
	 */
	List<Prescription> findPresById(String id);

	/**
	 * 删除多条记录
	 * 
	 * @param ids
	 */
	void deletePresByIds(String[] ids);
}

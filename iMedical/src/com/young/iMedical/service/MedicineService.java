package com.young.iMedical.service;

import java.util.List;

import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Medicine;

public interface MedicineService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.MedicineServiceImpl";

	/**
	 * 添加药物
	 * 
	 * @param medicine
	 */
	void saveMed(Medicine medicine);

	/**
	 * 根据医生用户查找药物
	 * 
	 * @param id
	 * @return
	 */
	List<Medicine> findMedByDoc(Doctor doctor);

	/**
	 * 根据id查找药物
	 * 
	 * @param id
	 * @return
	 */
	List<Medicine> findMedById(String id);

	/**
	 * 删除单条记录
	 * 
	 * @param id
	 */
	void deleteMedById(String id);

	/**
	 * 删除多条记录
	 * 
	 * @param ids
	 */
	void deleteMedByIds(String[] ids);

	/**
	 * 查看药名是否存在
	 * 
	 * @param name
	 * @return 布尔值
	 */
	boolean isMedNameExist(String name);

	/**
	 * 查看药物id是否已经存在
	 * 
	 * @param id
	 * @return
	 */
	boolean isMedIdExist(String id);

	/**
	 * 修改药物
	 * 
	 * @param medicine
	 */
	void updateMed(Medicine medicine);
}

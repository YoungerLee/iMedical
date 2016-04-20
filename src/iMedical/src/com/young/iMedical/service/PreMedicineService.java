package com.young.iMedical.service;

import java.util.List;
import java.util.Set;

import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.web.vo.PreMedicineForm;

public interface PreMedicineService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.PreMedicineServiceImpl";

	/**
	 * 查找药方中的药品
	 * 
	 * @param pm_id
	 */
	PreMedicine findPreMedById(int pm_id);

	/**
	 * 把Set类型的PO对象转化成List类型的VO对象
	 * 
	 * @param set
	 * @return List<PreMedicineForm>
	 */
	List<PreMedicineForm> POconvertVO(Set<PreMedicine> set);
}

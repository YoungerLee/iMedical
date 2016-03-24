package com.young.iMedical.service;

import com.young.iMedical.domain.PreMedicine;

public interface PreMedicineService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.PreMedicineServiceImpl";

	/**
	 * 查找药方中的药品
	 * 
	 * @param pm_id
	 */
	PreMedicine findPreMedById(int pm_id);
}

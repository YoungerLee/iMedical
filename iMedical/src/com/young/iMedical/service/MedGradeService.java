package com.young.iMedical.service;

import com.young.iMedical.domain.MedGrade;

public interface MedGradeService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.MedGradeServiceImpl";

	/**
	 * 添加药品评价记录
	 * 
	 * @param mg
	 */
	void saveGrade(MedGrade mg);
}

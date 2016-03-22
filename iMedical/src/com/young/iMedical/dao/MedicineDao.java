package com.young.iMedical.dao;

import com.young.iMedical.domain.Medicine;

public interface MedicineDao extends CommonDao<Medicine> {
	public final static String SERVICE_NAME = "com.young.iMedical.dao.impl.MedicineDaoImpl";
}

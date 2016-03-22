package com.young.iMedical.dao;

import com.young.iMedical.domain.Prescription;

public interface PrescriptionDao extends CommonDao<Prescription> {
	public final static String SERVICE_NAME = "com.young.iMedical.dao.impl.PrescriptionDaoImpl";
}

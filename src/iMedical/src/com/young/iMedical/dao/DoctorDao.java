package com.young.iMedical.dao;

import com.young.iMedical.domain.Doctor;

public interface DoctorDao extends CommonDao<Doctor> {
	public final static String SERVICE_NAME = "com.young.iMedical.dao.impl.DoctorDaoImpl";
}

package com.young.iMedical.service;

import com.young.iMedical.domain.Doctor;

public interface DoctorService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.DoctorServiceImpl";

	void saveDoctor(Doctor doctor);

	Doctor findDoctorById(String id);

	Doctor findDoctorByName(String name);
}

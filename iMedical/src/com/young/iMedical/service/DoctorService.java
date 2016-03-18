package com.young.iMedical.service;

import com.young.iMedical.domain.Doctor;

public interface DoctorService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.DoctorServiceImpl";

	public void saveDoctor(Doctor doctor);

	public Doctor findDoctorById(String id);

	public Doctor findDoctorByName(String name);
}

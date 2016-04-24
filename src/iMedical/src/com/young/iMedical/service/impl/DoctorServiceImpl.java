package com.young.iMedical.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.DoctorDao;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.service.DoctorService;

@Transactional(readOnly = true)
@Service(DoctorService.SERVICE_NAME)
public class DoctorServiceImpl implements DoctorService {
	@Resource(name = DoctorDao.SERVICE_NAME)
	private DoctorDao doctorDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveDoctor(Doctor doctor) {
		doctorDao.save(doctor);
	}

	@Override
	public Doctor findDoctorById(String id) {
		return (Doctor) doctorDao.findObjectByID(id);
	}

	@Override
	public Doctor findDoctorByName(String name) {
		String hqlWhere = " and o.name = ?";
		Object[] params = { name };
		List<Doctor> list = doctorDao.findCollectionByConditionNoPage(hqlWhere,
				params, null);
		Doctor Doctor = null;
		if (list != null && list.size() > 0) {
			Doctor = list.get(0);
		}
		return Doctor;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateDoctor(Doctor doctor) {
		doctorDao.update(doctor);
	}
}

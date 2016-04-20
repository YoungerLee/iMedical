package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.DoctorDao;
import com.young.iMedical.domain.Doctor;

@Repository(DoctorDao.SERVICE_NAME)
public class DoctorDaoImpl extends CommonDaoImpl<Doctor> implements DoctorDao {

}

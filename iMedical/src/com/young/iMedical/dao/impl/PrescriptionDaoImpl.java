package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.PrescriptionDao;
import com.young.iMedical.domain.Prescription;

@Repository(PrescriptionDao.SERVICE_NAME)
public class PrescriptionDaoImpl extends CommonDaoImpl<Prescription> implements
		PrescriptionDao {

}

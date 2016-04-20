package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.PreMedicineDao;
import com.young.iMedical.domain.PreMedicine;

@Repository(PreMedicineDao.SERVICE_NAME)
public class PreMedicineDaoImpl extends CommonDaoImpl<PreMedicine> implements
		PreMedicineDao {
}
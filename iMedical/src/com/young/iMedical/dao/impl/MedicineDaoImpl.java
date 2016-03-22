package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.MedicineDao;
import com.young.iMedical.domain.Medicine;

@Repository(MedicineDao.SERVICE_NAME)
public class MedicineDaoImpl extends CommonDaoImpl<Medicine> implements
		MedicineDao {

}

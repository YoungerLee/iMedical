package com.young.iMedical.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.PreMedicineDao;
import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.service.PreMedicineService;

@Transactional(readOnly = true)
@Service(PreMedicineService.SERVICE_NAME)
public class PreMedicineServiceImpl implements PreMedicineService {
	@Resource(name = PreMedicineDao.SERVICE_NAME)
	private PreMedicineDao preMedicineDao;

	@Override
	public PreMedicine findPreMedById(int id) {
		return preMedicineDao.findObjectByID(id);
	}
}

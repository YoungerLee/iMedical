package com.young.iMedical.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.MedicineDao;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Medicine;
import com.young.iMedical.service.MedicineService;

@Transactional(readOnly = true)
@Service(MedicineService.SERVICE_NAME)
public class MedicineServiceImpl implements MedicineService {
	@Resource(name = MedicineDao.SERVICE_NAME)
	private MedicineDao medicineDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveMed(Medicine medicine) {
		medicineDao.save(medicine);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMed(Medicine medicine) {
		medicineDao.update(medicine);
	}

	@Override
	public List<Medicine> findMedById(String id) {
		String hqlWhere = " and o.med_id = ?";
		Object[] params = { id };
		return medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	public List<Medicine> findMedByDoc(Doctor doctor) {
		String hqlWhere = " and o.doctor = ?";
		Object[] params = { doctor };
		return medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMedById(String id) {
		medicineDao.deleteObjectByID(id);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMedByIds(String[] ids) {
		medicineDao.deleteObjectByIDs(ids);
	}

	@Override
	public boolean isMedNameExist(String name) {
		String hqlWhere = " and o.name = ?";
		Object[] params = { name };
		return !medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				null).isEmpty();

	}

	@Override
	public boolean isMedIdExist(String id) {
		String hqlWhere = " and o.med_id = ?";
		Object[] params = { id };
		return !medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				null).isEmpty();
	}
}

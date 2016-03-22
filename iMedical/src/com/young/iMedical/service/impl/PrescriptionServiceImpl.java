package com.young.iMedical.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.PrescriptionDao;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.PrescriptionService;

@Transactional(readOnly = true)
@Service(PrescriptionService.SERVICE_NAME)
public class PrescriptionServiceImpl implements PrescriptionService {
	@Resource(name = PrescriptionDao.SERVICE_NAME)
	private PrescriptionDao prescriptionDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void savePres(Prescription prescription) {
		prescriptionDao.save(prescription);
	}

	@Override
	public List<Prescription> findPresByDoc(Doctor doctor) {
		String hqlWhere = " and o.doctor = ?";
		Object[] params = { doctor };
		return prescriptionDao.findCollectionByConditionNoPage(hqlWhere,
				params, null);
	}

	@Override
	public List<Prescription> findPresByUser(User user) {
		String hqlWhere = " and o.user = ?";
		Object[] params = { user };
		return prescriptionDao.findCollectionByConditionNoPage(hqlWhere,
				params, null);
	}

	@Override
	public List<Prescription> findPresById(String id) {
		String hqlWhere = " and o.pre_id = ?";
		Object[] params = { id };
		return prescriptionDao.findCollectionByConditionNoPage(hqlWhere,
				params, null);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePresByIds(String[] ids) {
		prescriptionDao.deleteObjectByIDs(ids);
	}
}

package com.young.iMedical.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import com.young.iMedical.web.vo.MedicineForm;

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
	public List<Medicine> findMedById(Integer id) {
		String hqlWhere = " and o.med_id = ?";
		Object[] params = { id };
		return medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	public List<Medicine> getAllMed() {
		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.med_id", "desc"); // 降序排列
		return medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				orderby);
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
	public void deleteMedById(Integer id) {
		medicineDao.deleteObjectByID(id);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMedByIds(Integer[] ids) {
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
	public boolean isMedIdExist(Integer id) {
		String hqlWhere = " and o.med_id = ?";
		Object[] params = { id };
		return !medicineDao.findCollectionByConditionNoPage(hqlWhere, params,
				null).isEmpty();
	}

	@Override
	public List<MedicineForm> POconvertVO(List<Medicine> list) {
		List<MedicineForm> voList = new ArrayList<MedicineForm>();
		MedicineForm medicineForm = null;
		for (int i = 0; list != null && i < list.size(); i++) {
			Medicine medicine = list.get(i);
			medicineForm = new MedicineForm();
			medicineForm.setMed_id(medicine.getMed_id());
			medicineForm.setName(medicine.getName());
			medicineForm.setMethod(medicine.getMethod());
			medicineForm.setBuyTime(medicine.getBuyTime());
			medicineForm.setPerNum(medicine.getPerNum());
			medicineForm.setQuantity(medicine.getQuantity());
			medicineForm.setType(medicine.getType());
			medicineForm.setDoctor(medicine.getDoctor().getName());
			voList.add(medicineForm);
		}
		return voList;
	}
}

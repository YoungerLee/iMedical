package com.young.iMedical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.PreMedicineDao;
import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.web.vo.PreMedicineForm;

@Transactional(readOnly = true)
@Service(PreMedicineService.SERVICE_NAME)
public class PreMedicineServiceImpl implements PreMedicineService {
	@Resource(name = PreMedicineDao.SERVICE_NAME)
	private PreMedicineDao preMedicineDao;

	@Override
	public PreMedicine findPreMedById(int id) {
		return preMedicineDao.findObjectByID(id);
	}

	@Override
	public List<PreMedicineForm> POconvertVO(Set<PreMedicine> set) {
		List<PreMedicineForm> voList = new ArrayList<PreMedicineForm>();
		PreMedicineForm pmf = null;
		Iterator<PreMedicine> it = set.iterator();
		while (it.hasNext()) {
			PreMedicine pm = (PreMedicine) it.next();
			pmf = new PreMedicineForm();
			pmf.setPm_id(pm.getPm_id());
			pmf.setName(pm.getName());
			pmf.setType(pm.getType());
			pmf.setMethod(pm.getMethod());
			pmf.setPerNum(pm.getPerNum());
			pmf.setQuantity(pmf.getQuantity());
			pmf.setTotalNum(pm.getTotalNum());
			voList.add(pmf);
		}
		return voList;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMeds(Set<PreMedicine> set) {
		Iterator<PreMedicine> it = set.iterator();
		while (it.hasNext()) {
			PreMedicine pm = (PreMedicine) it.next();
			preMedicineDao.update(pm);
		}
	}
}

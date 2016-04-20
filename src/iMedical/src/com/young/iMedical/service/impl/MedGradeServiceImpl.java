package com.young.iMedical.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.MedGradeDao;
import com.young.iMedical.domain.MedGrade;
import com.young.iMedical.service.MedGradeService;

@Transactional(readOnly = true)
@Service(MedGradeService.SERVICE_NAME)
public class MedGradeServiceImpl implements MedGradeService {
	@Resource(name = MedGradeDao.SERVICE_NAME)
	private MedGradeDao medGradeDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveGrade(MedGrade mg) {
		medGradeDao.save(mg);
	}
}

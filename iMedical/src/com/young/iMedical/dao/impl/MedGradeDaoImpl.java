package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.MedGradeDao;
import com.young.iMedical.domain.MedGrade;

@Repository(MedGradeDao.SERVICE_NAME)
public class MedGradeDaoImpl extends CommonDaoImpl<MedGrade> implements
		MedGradeDao {

}
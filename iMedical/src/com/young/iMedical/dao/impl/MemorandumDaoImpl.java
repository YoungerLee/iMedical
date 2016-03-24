package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.MemorandumDao;
import com.young.iMedical.domain.Memorandum;

@Repository(MemorandumDao.SERVICE_NAME)
public class MemorandumDaoImpl extends CommonDaoImpl<Memorandum> implements
		MemorandumDao {
}

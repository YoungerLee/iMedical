package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.HistoryLogDao;
import com.young.iMedical.domain.HistoryLog;

@Repository(HistoryLogDao.SERVICE_NAME)
public class HistoryLogDaoImpl extends CommonDaoImpl<HistoryLog> implements
		HistoryLogDao {
}

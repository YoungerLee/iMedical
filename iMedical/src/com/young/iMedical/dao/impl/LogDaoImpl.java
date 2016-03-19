package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.LogDao;
import com.young.iMedical.domain.Log;

@Repository(LogDao.SERVICE_NAME)
public class LogDaoImpl extends CommonDaoImpl<Log> implements LogDao {

}

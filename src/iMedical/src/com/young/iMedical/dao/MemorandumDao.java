package com.young.iMedical.dao;

import com.young.iMedical.domain.Memorandum;

public interface MemorandumDao extends CommonDao<Memorandum> {
	public final static String SERVICE_NAME = "com.young.iMedical.dao.impl.MemorandumDaoImpl";
}

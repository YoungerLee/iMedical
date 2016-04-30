package com.young.iMedical.dao;

import java.sql.Time;
import java.util.List;

import com.young.iMedical.domain.Memorandum;

public interface MemorandumDao extends CommonDao<Memorandum> {
	public final static String SERVICE_NAME = "com.young.iMedical.dao.impl.MemorandumDaoImpl";

	List<Time> findTimeByPresAndMed(String pre_id, Integer pm_id);
}

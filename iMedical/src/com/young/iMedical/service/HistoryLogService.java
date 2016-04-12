package com.young.iMedical.service;

import java.util.List;

import com.young.iMedical.domain.HistoryLog;

public interface HistoryLogService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.HistoryLogServiceImpl";

	void saveHistoryLog(HistoryLog hl);

	List<HistoryLog> getAllLog();
}

package com.young.iMedical.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.HistoryLogDao;
import com.young.iMedical.domain.HistoryLog;
import com.young.iMedical.service.HistoryLogService;

@Transactional(readOnly = true)
@Service(HistoryLogService.SERVICE_NAME)
public class HistoryLogServiceImpl implements HistoryLogService {
	@Resource(name = HistoryLogDao.SERVICE_NAME)
	private HistoryLogDao historyLogDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveHistoryLog(HistoryLog hl) {
		historyLogDao.save(hl);
	}

	@Override
	public List<HistoryLog> getAllLog() {
		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.log_id", "desc"); // 降序排列
		return historyLogDao.findCollectionByConditionNoPage(hqlWhere, params,
				orderby);
	}
}

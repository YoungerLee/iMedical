package com.young.iMedical.service.impl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.MemorandumDao;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.util.StringUtils;
import com.young.iMedical.web.vo.MedKitData;

@Transactional(readOnly = true)
@Service(MemorandumService.SERVICE_NAME)
public class MemorandumServiceImpl implements MemorandumService {
	@Resource(name = MemorandumDao.SERVICE_NAME)
	private MemorandumDao memorandumDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveMemo(Memorandum memo) {
		memorandumDao.save(memo);
	}

	@Override
	public List<Memorandum> findMemoByUser(User user) {
		String hqlWhere = " and o.user = ?";
		Object[] params = { user };
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	public List<Memorandum> findMemoByUserToKit(User user) {
		String hqlWhere = " and o.user = ? and o.flag = 0";
		Object[] params = { user };
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	public List<Memorandum> findMemoByPres(Prescription pres) {
		String hqlWhere = " and o.prescription= ?";
		Object[] params = { pres };
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	public List<Memorandum> findMemoByPresAndMed(Prescription pres,
			PreMedicine pm) {
		String hqlWhere = " and o.prescription = ? and o.preMedicine = ?";
		Object[] params = { pres, pm };
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.time", "asc");
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				orderby);
	}

	@Override
	public List<Memorandum> fineMemoById(Integer mem_id) {
		String hqlWhere = " and o.mem_id= ?";
		Object[] params = { mem_id };
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMemoByIds(Integer[] ids) {
		memorandumDao.deleteObjectByIDs(ids);
	}

	@Override
	public boolean isMemoIdExist(Integer mem_id) {
		String hqlWhere = " and o.mem_id = ?";
		Object[] params = { mem_id };
		return !memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null).isEmpty();
	}

	@Override
	public List<MedKitData> PO2MedKit(List<Memorandum> list) {
		List<MedKitData> voList = new ArrayList<MedKitData>();
		MedKitData mkd = null;
		for (int i = 0; list != null && i < list.size(); i++) {
			Memorandum memorandum = list.get(i);
			mkd = new MedKitData();
			mkd.setMed_id(String.valueOf(memorandum.getPreMedicine()
					.getMed_id()));
			mkd.setBeginDate(StringUtils.sqlDateToString(memorandum
					.getBeginDate()));
			mkd.setEndDate(StringUtils.sqlDateToString(memorandum.getEndDate()));
			mkd.setTime(StringUtils.sqlTimeToString(memorandum.getTime()));
			voList.add(mkd);
		}
		return voList;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMemo(Memorandum memo) {
		memorandumDao.update(memo);
	}

	@Override
	public List<Time> findTimeByPresAndMed(String pre_id, Integer pm_id) {
		return memorandumDao.findTimeByPresAndMed(pre_id, pm_id);
	}
}

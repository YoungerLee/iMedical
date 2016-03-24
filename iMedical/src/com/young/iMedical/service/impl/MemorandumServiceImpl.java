package com.young.iMedical.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.MemorandumDao;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.MemorandumService;

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
	public List<Memorandum> findMemoByPres(Prescription pres) {
		String hqlWhere = " and o.prescription= ?";
		Object[] params = { pres };
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	public List<Memorandum> fineMemoById(int mem_id) {
		String hqlWhere = " and o.mem_id= ?";
		Object[] params = { mem_id };
		return memorandumDao.findCollectionByConditionNoPage(hqlWhere, params,
				null);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMemoByIds(String[] ids) {
		memorandumDao.deleteObjectByIDs(ids);
	}
}

package com.young.iMedical.service;

import java.util.List;

import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;

public interface MemorandumService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.MemorandumServiceImpl";

	/**
	 * 添加备忘录
	 * 
	 * @param memo
	 */
	void saveMemo(Memorandum memo);

	/**
	 * 查找指定用户的备忘录
	 * 
	 * @param user
	 * @return 结果的集合
	 */
	List<Memorandum> findMemoByUser(User user);

	/**
	 * 查找对应药方的备忘录
	 * 
	 * @param pres
	 * @return 结果的集合
	 */
	List<Memorandum> findMemoByPres(Prescription pres);

	/**
	 * 根据id查找备忘录
	 * 
	 * @param mem_id
	 * @return
	 */
	List<Memorandum> fineMemoById(int mem_id);

	/**
	 * 删除记录
	 * 
	 * @param ids
	 */
	void deleteMemoByIds(String[] ids);
}

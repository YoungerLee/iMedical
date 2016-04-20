package com.young.iMedical.service;

import java.util.List;

import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.web.vo.MedKitData;
import com.young.iMedical.web.vo.MemorandumForm;

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
	 * 查找指定用户的备忘录返回药箱
	 * 
	 * @param user
	 * @return 结果的集合
	 */
	List<Memorandum> findMemoByUserToKit(User user);

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
	List<Memorandum> fineMemoById(Integer mem_id);

	/**
	 * 删除记录
	 * 
	 * @param ids
	 */
	void deleteMemoByIds(Integer[] ids);

	/**
	 * 判断是否存在
	 * 
	 * @param mem_id
	 * @return
	 */
	boolean isMemoIdExist(Integer mem_id);

	/**
	 * 修改备忘录信息
	 * 
	 * @param memo
	 */
	void updateMemo(Memorandum memo);

	/**
	 * 把PO对象转化为VO对象
	 * 
	 * @param list
	 * @return VO对象的集合
	 */
	List<MemorandumForm> POconvertVO(List<Memorandum> list);

	/**
	 * 把PO对象封装为VO对象(药箱)
	 * 
	 * @param list
	 * @return VO对象的集合
	 */
	List<MedKitData> PO2MedKit(List<Memorandum> list);
}

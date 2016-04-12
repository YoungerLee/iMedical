package com.young.iMedical.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.service.PrescriptionService;
import com.young.iMedical.util.StringUtils;

public class MemorandumAction extends BaseAction implements
		ModelDriven<Memorandum> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Memorandum memorandum;
	private MemorandumService memorandumService = (MemorandumService) ServiceProvider
			.getService(MemorandumService.SERVICE_NAME);
	private PrescriptionService prescriptionService = (PrescriptionService) ServiceProvider
			.getService(PrescriptionService.SERVICE_NAME);
	private PreMedicineService preMedicineService = (PreMedicineService) ServiceProvider
			.getService(PreMedicineService.SERVICE_NAME);
	private static Map<String, Integer> medFreq = new HashMap<String, Integer>();
	private static Map<String, Integer> freqNum = new HashMap<String, Integer>();
	static {
		medFreq.put("每日3次", 3);
		medFreq.put("每日2次", 2);
		medFreq.put("每日1次", 1);
		freqNum.put("一次1粒", 1);
		freqNum.put("一次1袋", 1);
		freqNum.put("一次2粒", 2);
		freqNum.put("一次2袋", 2);
		freqNum.put("一次3粒", 3);
		freqNum.put("一次3袋", 3);
	}

	@Override
	public Memorandum getModel() {
		return memorandum;
	}

	/**
	 * @Name: addMemo
	 * @Description: 添加备忘录
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-24（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到memoList.jsp
	 */
	@SuppressWarnings("unchecked")
	public String addMemo() {
		// 获取请求参数
		String pre_id = request.getParameter("pre_id");
		String content = request.getParameter("content");
		int pm_id = Integer.parseInt(request.getParameter("pm_id"));
		String beginDate = request.getParameter("beginDate");
		User user = (User) request.getSession().getAttribute("user");
		PreMedicine preMedicine = preMedicineService.findPreMedById(pm_id);// 获取药品
		String method = preMedicine.getMethod();// 获取使用方法

		String str[] = method.split("，");// 截取字符串
		int day = (int) Math.ceil(preMedicine.getTotalNum() * 1.0
				/ medFreq.get(str[2]) / freqNum.get(str[1]));// 吃药的天数
		String endDate = StringUtils.addDate(
				StringUtils.stringConvertDate(beginDate), day);// 根据指定开始日期和天数计算结束日期
		List<Prescription> list = prescriptionService.findPresById(pre_id);// 获取药方
		if (!list.isEmpty()) {
			Prescription prescription = list.get(0);// 获取药方
			int frequency = medFreq.get(str[2]);// 根据吃药频度插入备忘录
			for (int i = 1; i <= frequency; i++) {
				String time = request.getParameter("time" + i);
				Memorandum memorandum = new Memorandum();
				memorandum.setUser(user);
				memorandum.setPrescription(prescription);
				memorandum.setPreMedicine(preMedicine);
				memorandum.setContent(content);
				memorandum.setBeginDate(StringUtils.stringToSqlDate(beginDate));
				memorandum.setEndDate(StringUtils.stringToSqlDate(endDate));
				memorandum.setTime(StringUtils.stringToSqlTime(time));
				memorandumService.saveMemo(memorandum);
			}
			return memoList();
		} else {
			return "error";
		}
	}

	/**
	 * @Name: addMemo
	 * @Description: 添加备忘录参数设置
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-24（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到addMemo.jsp
	 */
	public String askAddMemo() {
		int pm_id = Integer.parseInt(request.getParameter("pm_id"));
		String pre_id = request.getParameter("pre_id");
		PreMedicine preMedicine = preMedicineService.findPreMedById(pm_id);
		String method = preMedicine.getMethod();
		String frequency = method.split("，")[2];
		String content = preMedicine.getName() + "：" + preMedicine.getMethod();
		request.getSession().setAttribute("content", content);
		request.getSession().setAttribute("pm_id", pm_id);
		request.getSession().setAttribute("pre_id", pre_id);
		request.getSession().setAttribute("frequency", medFreq.get(frequency));
		return "askAddMemo";
	}

	/**
	 * @Name: memoList
	 * @Description: 查看备忘录
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-24（创建日期）
	 * @Parameters: 无
	 * @Return: String memoList 跳转到memoList.jsp
	 */
	public String memoList() {
		User user = (User) request.getSession().getAttribute("user");
		List<Memorandum> memoList = memorandumService.findMemoByUser(user);
		request.setAttribute("memoList", memoList);
		return "memoList";
	}

	/**
	 * @Name: delOneMemo
	 * @Description: 删除单条记录
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-24（创建日期）
	 * @Parameters: 无
	 * @Return: String memoList 跳转到memoList.jsp
	 */
	public String delOneMemo() {
		String id = request.getParameter("id");
		Integer mem_id = Integer.parseInt(id);
		if (memorandumService.isMemoIdExist(mem_id)) {
			Integer[] ids = { mem_id };
			memorandumService.deleteMemoByIds(ids);
			return memoList();
		} else {
			return "error";
		}
	}

	/**
	 * @Name: delOneMemo
	 * @Description: 删除多条记录
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-24（创建日期）
	 * @Parameters: 无
	 * @Return: String memoList 跳转到memoList.jsp
	 */
	public String delBatchMemo() {
		memorandumService
				.deleteMemoByIds(StringUtils.stringArrayToIntegerArray(request
						.getParameterValues("delId")));
		return memoList();
	}

	/************************** Android端的action *************************/
	public void android_memo_list() {
		User user = (User) request.getSession().getAttribute("user");
		List<Memorandum> memoList = memorandumService.findMemoByUser(user);
	}
}

package com.young.iMedical.web.medkit;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.HistoryLog;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.HistoryLogService;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.util.DataMap;
import com.young.iMedical.util.StringUtils;
import com.young.iMedical.web.action.BaseAction;
import com.young.iMedical.web.vo.MedKitData;

@SuppressWarnings("serial")
public class MedKitAction extends BaseAction {
	private MemorandumService memorandumService = (MemorandumService) ServiceProvider
			.getService(MemorandumService.SERVICE_NAME);
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private PreMedicineService preMedicineService = (PreMedicineService) ServiceProvider
			.getService(PreMedicineService.SERVICE_NAME);
	private HistoryLogService historyLogService = (HistoryLogService) ServiceProvider
			.getService(HistoryLogService.SERVICE_NAME);

	public void test() {
		try {
			PrintWriter out = response.getWriter();
			String test = request.getParameter("med");
			String username = request.getParameter("name");
			System.out.println(test);
			System.out.println(username);
			out.write("AA");
			out.write("Hi," + username + "!");
			out.write("FF");
			if ("getmed".equals(test)) {
				out.write("I get it");
				System.out.println(test);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void memo() {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("name");
			// System.out.println(username);
			if (!(username == null || "".equals(username))) {
				User user = userService.findUserByName(username);
				List<Memorandum> memoList = memorandumService
						.findMemoByUser(user);
				if (!(memoList == null || memoList.isEmpty())) {
					List<MedKitData> voList = memorandumService
							.PO2MedKit(memoList);
					Gson gson = new Gson();
					String jsonStr = gson.toJson(voList);
					out.write("AA" + jsonStr + "FF");
					// for (Memorandum memo : memoList) {
					// memo.setFlag(1);
					// memorandumService.updateMemo(memo);
					// }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void confirm() {
		try {
			String username = request.getParameter("name");
			User user = userService.findUserByName(username);
			List<Memorandum> list = memorandumService.findMemoByUser(user);
			if (!list.isEmpty()) {
				HistoryLog historyLog = new HistoryLog();
				Memorandum memorandum = list.get(0);
				Prescription prescription = memorandum.getPrescription();
				Set<PreMedicine> medSet = prescription.getMedicines();
				Map<String, Integer> freqNum = DataMap.getFreqNum();
				Iterator<PreMedicine> it = medSet.iterator();
				while (it.hasNext()) {
					PreMedicine pm = (PreMedicine) it.next();
					String usage = pm.getMethod().split("，")[1];
					Integer deduct = freqNum.get(usage);
					Integer surplus = pm.getTotalNum() - deduct;
					pm.setTotalNum(surplus);
				}
				preMedicineService.updateMeds(medSet);
				historyLog.setUsername(memorandum.getUser().getUsername());
				historyLog.setState(1);
				historyLog.setSetTime(memorandum.getTime());
				historyLog.setActualTime(StringUtils
						.stringToSqlTime(new SimpleDateFormat("HH:mm:ss")
								.format(Calendar.getInstance().getTime())));
				historyLog.setContent(memorandum.getContent());
				historyLog.setDate(StringUtils
						.stringToSqlDate(new SimpleDateFormat("yyyy-MM-dd")
								.format(Calendar.getInstance().getTime())));
				historyLogService.saveHistoryLog(historyLog);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

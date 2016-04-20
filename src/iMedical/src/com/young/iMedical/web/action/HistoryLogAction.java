package com.young.iMedical.web.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.HistoryLog;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.service.HistoryLogService;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.util.StringUtils;

public class HistoryLogAction extends BaseAction implements
		ModelDriven<HistoryLog> {
	private HistoryLog historyLog;
	private HistoryLogService historyLogService = (HistoryLogService) ServiceProvider
			.getService(HistoryLogService.SERVICE_NAME);
	private MemorandumService memorandumService = (MemorandumService) ServiceProvider
			.getService(MemorandumService.SERVICE_NAME);

	@Override
	public HistoryLog getModel() {
		return historyLog;
	}

	/**
	 * @Name:addHistoryLog
	 * @Description: 添加日志
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String home 跳转到historyLog.jsp
	 */
	public String addHistoryLog() {
		Integer mem_id = Integer.parseInt(request.getParameter("id"));
		List<Memorandum> list = memorandumService.fineMemoById(mem_id);
		if (!list.isEmpty()) {
			HistoryLog historyLog = new HistoryLog();
			Memorandum memorandum = list.get(0);
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
			return getAllLog();
		} else {
			return "error";
		}
	}

	public String getAllLog() {
		List<HistoryLog> list = historyLogService.getAllLog();
		request.setAttribute("logList", list);
		return "logList";
	}
}

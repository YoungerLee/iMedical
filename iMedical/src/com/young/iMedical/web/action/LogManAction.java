package com.young.iMedical.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Log;
import com.young.iMedical.service.LogService;
import com.young.iMedical.util.StringUtils;

public class LogManAction extends BaseAction implements ModelDriven<Log> {

	private Log log = new Log();

	private LogService logService = (LogService) ServiceProvider
			.getService(LogService.SERVICE_NAME);

	@Override
	public Log getModel() {
		return log;
	}

	/**
	 * @Name: home
	 * @Description: 查询日志列表信息
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String home 跳转到logIndex.jsp
	 */
	public String home() {
		List<Log> list = logService.findLogListByCondition(log);
		request.setAttribute("logList", list);
		return "home";
	}

	/**
	 * @Name: delete
	 * @Description: 删除查询得到的日志列表信息
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String delete 重定向到logIndex.jsp
	 */
	public String delete() {
		logService
				.deleteLogByLogIDs(StringUtils
						.stringArrayToIntegerArray(request
								.getParameterValues("logID")));
		return "delete";
	}
}

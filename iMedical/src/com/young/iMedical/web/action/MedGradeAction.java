package com.young.iMedical.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.MedGrade;
import com.young.iMedical.domain.Medicine;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.MedGradeService;
import com.young.iMedical.service.MedicineService;

@SuppressWarnings("serial")
public class MedGradeAction extends BaseAction implements ModelDriven<MedGrade> {
	private MedGrade medGrade = new MedGrade();
	private MedGradeService mgs = (MedGradeService) ServiceProvider
			.getService(MedGradeService.SERVICE_NAME);
	private MedicineService ms = (MedicineService) ServiceProvider
			.getService(MedicineService.SERVICE_NAME);

	@Override
	public MedGrade getModel() {
		return medGrade;
	}

	/**
	 * @Name: addGrade
	 * @Description: 添加药品
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-04-15（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到home.jsp
	 */
	public String addGrade() {
		MedGrade medGrade = new MedGrade();
		User user = (User) request.getSession().getAttribute("user");
		int user_id = user.getUser_id();
		int med_id = Integer.parseInt(request.getParameter("med_id"));
		double grade = Double.parseDouble(request.getParameter("grade"));
		medGrade.setUser_id(user_id);
		medGrade.setMed_id(med_id);
		medGrade.setGrade(grade);
		mgs.saveGrade(medGrade);
		return "addGrade";
	}

	public String askGrade() {
		String med_id = request.getParameter("med_id");
		List<Medicine> list = ms.findMedById(Integer.parseInt(med_id));
		if (!list.isEmpty()) {
			Medicine med = list.get(0);
			request.setAttribute("med", med);
		}
		return "askGrade";
	}
}

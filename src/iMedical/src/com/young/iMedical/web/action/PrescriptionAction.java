package com.young.iMedical.web.action;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Medicine;
import com.young.iMedical.domain.PreMedicine;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.service.PrescriptionService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.util.StringUtils;

public class PrescriptionAction extends BaseAction implements
		ModelDriven<Prescription> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Prescription prescription;
	private PrescriptionService prescriptionService = (PrescriptionService) ServiceProvider
			.getService(PrescriptionService.SERVICE_NAME);
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private PreMedicineService pms = (PreMedicineService) ServiceProvider
			.getService(PreMedicineService.SERVICE_NAME);

	@Override
	public Prescription getModel() {
		return prescription;
	}

	/**
	 * @Name: addPres
	 * @Description: 添加药方
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到presList.jsp
	 */
	@SuppressWarnings("unchecked")
	public String addPres() {
		try {
			Prescription prescription = new Prescription();
			Set<PreMedicine> medSet = new HashSet<PreMedicine>();
			String name = request.getParameter("name");
			User user = userService.findUserByName(name);
			Doctor doctor = (Doctor) request.getSession().getAttribute("user");
			String purpose = request.getParameter("purpose");
			prescription.setDoctor(doctor);
			prescription.setUser(user);
			prescription.setPurpose(purpose);
			prescription.setTime(StringUtils
					.stringToSqlDate(new SimpleDateFormat("yyyy-MM-dd")
							.format(new java.util.Date())));
			Map<Medicine, Integer> medMap = (Map<Medicine, Integer>) request
					.getSession().getAttribute("medMap");
			for (Map.Entry<Medicine, Integer> entry : medMap.entrySet()) {
				PreMedicine pm = new PreMedicine();
				pm.setMed_id(entry.getKey().getMed_id());
				pm.setName(entry.getKey().getName());
				pm.setMethod(entry.getKey().getMethod());
				pm.setType(entry.getKey().getType());
				pm.setPerNum(entry.getKey().getPerNum());
				pm.setQuantity(entry.getValue());
				pm.setTotalNum(pm.getPerNum() * pm.getQuantity());
				medSet.add(pm);
			}
			prescription.setMedicines(medSet);
			medMap.clear();
			prescriptionService.savePres(prescription);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return "addPres";
	}

	/**
	 * @Name: presListOfUser
	 * @Description: 查找普通用户的药方
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到presList.jsp
	 */
	public String presListOfUser() {
		User user = (User) request.getSession().getAttribute("user");
		List<Prescription> presList = prescriptionService.findPresByUser(user);
		request.setAttribute("userPres", presList);
		return "userList";
	}

	/**
	 * @Name: presListOfDoctor
	 * @Description: 查找医生用户的药方
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到presList.jsp
	 */
	public String presListOfDoctor() {
		Doctor doctor = (Doctor) request.getSession().getAttribute("user");
		List<Prescription> presList = prescriptionService.findPresByDoc(doctor);
		request.setAttribute("docPres", presList);
		return "docList";
	}
}

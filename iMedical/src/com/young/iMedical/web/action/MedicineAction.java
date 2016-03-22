package com.young.iMedical.web.action;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Medicine;
import com.young.iMedical.service.MedicineService;

@SuppressWarnings("serial")
public class MedicineAction extends BaseAction implements ModelDriven<Medicine> {
	private Medicine medicine = new Medicine();

	private MedicineService medicineService = (MedicineService) ServiceProvider
			.getService(MedicineService.SERVICE_NAME);

	@Override
	public Medicine getModel() {
		return medicine;
	}

	/**
	 * @Name: addMed
	 * @Description: 添加药品
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String add 跳转到medList.jsp
	 */
	public String addMed() {
		try {
			Medicine medicine = new Medicine();
			BeanUtils.populate(medicine, request.getParameterMap());
			Doctor doctor = (Doctor) request.getSession().getAttribute("user");
			medicine.setDoctor(doctor);
			if (!medicineService.isMedNameExist(medicine.getName())) {
				medicineService.saveMed(medicine);
				return medList();
			} else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Name: delOneMed
	 * @Description: 删除单个药品
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String delete 跳转到medList.jsp
	 */
	public String delOneMed() {
		String id = request.getParameter("id");
		if (medicineService.isMedIdExist(id)) {
			String[] ids = { id };
			medicineService.deleteMedByIds(ids);
			return medList();
		} else {
			return "error";
		}
	}

	/**
	 * @Name: delBatchMed
	 * @Description: 批量删除药品
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String deleteBatch 跳转到medList.jsp
	 */
	public String delBatchMed() {
		String[] ids = request.getParameterValues("delId");
		medicineService.deleteMedByIds(ids);
		return medList();
	}

	/**
	 * @Name: delBatchMed
	 * @Description: 查看药品
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String list 跳转到medList.jsp
	 */
	public String medList() {
		Doctor doctor = (Doctor) request.getSession().getAttribute("user");
		List<Medicine> list = medicineService.findMedByDoc(doctor);
		request.setAttribute("medList", list);
		return "list";
	}

	public String askUpdateMed() {
		String med_id = request.getParameter("id");
		List<Medicine> list = medicineService.findMedById(med_id);
		if (!list.isEmpty()) {
			Medicine med = list.get(0);
			request.getSession().setAttribute("med", med);
			return "updateMed";
		} else {
			return "error";
		}
	}

	/**
	 * @Name: delBatchMed
	 * @Description: 修改药品
	 * @Author: 李飞洋
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2016-03-19（创建日期）
	 * @Parameters: 无
	 * @Return: String update 跳转到medList.jsp
	 */
	public String updateMed() {
		try {
			Medicine medicine = new Medicine();
			Doctor doctor = (Doctor) request.getSession().getAttribute("user");
			BeanUtils.populate(medicine, request.getParameterMap());
			medicine.setDoctor(doctor);
			medicineService.updateMed(medicine);
			return medList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
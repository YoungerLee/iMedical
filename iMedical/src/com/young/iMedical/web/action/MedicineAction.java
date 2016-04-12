package com.young.iMedical.web.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.Medicine;
import com.young.iMedical.service.MedicineService;
import com.young.iMedical.util.StringUtils;
import com.young.iMedical.web.vo.MedicineForm;

@SuppressWarnings("serial")
public class MedicineAction extends BaseAction implements ModelDriven<Medicine> {
	private Medicine medicine = new Medicine();

	private MedicineService medicineService = (MedicineService) ServiceProvider
			.getService(MedicineService.SERVICE_NAME);

	@Override
	public Medicine getModel() {
		return medicine;
	}

	/*********************** 网页端的action ********************************/
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
				return "addMed";
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
		if (medicineService.isMedIdExist(Integer.parseInt(id))) {
			String[] ids = { id };
			medicineService.deleteMedByIds(StringUtils
					.stringArrayToIntegerArray(ids));
			return "delOneMed";
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
		medicineService.deleteMedByIds(StringUtils
				.stringArrayToIntegerArray(ids));
		return "delBatchMed";
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
		List<Medicine> list = medicineService.findMedById(Integer
				.parseInt(med_id));
		if (!list.isEmpty()) {
			Medicine med = list.get(0);
			request.getSession().setAttribute("med", med);
			return "askUpdateMed";
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
			return "updateMed";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加药品到药方
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String addToPres() {
		String med_id = request.getParameter("id");
		List<Medicine> list = medicineService.findMedById(Integer
				.parseInt(med_id));
		if (!list.isEmpty()) {
			Medicine medicine = list.get(0);
			Map<Medicine, Integer> medMap = (Map<Medicine, Integer>) request
					.getSession().getAttribute("medMap");
			medMap.put(medicine,
					medMap.containsKey(medicine) ? medMap.get(medicine) + 1 : 1);
			return "addToPres";
		} else {
			return "error";
		}

	}

	@SuppressWarnings("unchecked")
	public String changeNum() {
		String med_id = request.getParameter("id");
		List<Medicine> list = medicineService.findMedById(Integer
				.parseInt(med_id));
		if (!list.isEmpty()) {
			Medicine medicine = list.get(0);
			Map<Medicine, Integer> medMap = (Map<Medicine, Integer>) request
					.getSession().getAttribute("medMap");
			medMap.put(medicine,
					Integer.parseInt(request.getParameter("buynum")));
			return "change";
		} else {
			return "error";
		}
	}

	@SuppressWarnings("unchecked")
	public String clearMed() {
		Map<Medicine, Integer> medMap = (Map<Medicine, Integer>) request
				.getSession().getAttribute("medMap");
		medMap.clear();
		return "clear";
	}

	/*********************** Android端的action ***********************/
	public void android_medicine_list() {
		try {
			PrintWriter out = response.getWriter();
			Doctor doctor = (Doctor) request.getSession().getAttribute("user");
			List<Medicine> list = medicineService.findMedByDoc(doctor);
			List<MedicineForm> voList = medicineService.POconvertVO(list);
			Gson gson = new Gson();
			String str = gson.toJson(voList);
			out.write(str);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

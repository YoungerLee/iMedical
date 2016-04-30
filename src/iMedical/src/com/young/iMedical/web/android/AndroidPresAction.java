package com.young.iMedical.web.android;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Prescription;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.service.PrescriptionService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.util.StringUtils;
import com.young.iMedical.web.action.BaseAction;
import com.young.iMedical.web.vo.PrescriptionForm;

public class AndroidPresAction extends BaseAction implements
		ModelDriven<PrescriptionForm> {

	private PrescriptionForm pf;
	private PrescriptionService prescriptionService = (PrescriptionService) ServiceProvider
			.getService(PrescriptionService.SERVICE_NAME);
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private PreMedicineService pms = (PreMedicineService) ServiceProvider
			.getService(PreMedicineService.SERVICE_NAME);

	@Override
	public PrescriptionForm getModel() {
		return pf;
	}

	// --------------------以下是Android端的请求--------------------------//

	public void list() {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			if (username != null && !"".equals(username)) {
				User user = userService.findUserByName(username);
				List<Prescription> presList = prescriptionService
						.findPresByUser(user);
				List<PrescriptionForm> voList = POconvertVO(presList);
				Gson gson = new Gson();
				String str = gson.toJson(voList);
				out.write(str);
				out.flush();
				out.close();
			} else {
				out.write("Please submit legal parameters!");
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 把PO对象转化为VO对象
	 * 
	 * @param list
	 * @return VO对象的集合
	 */
	private List<PrescriptionForm> POconvertVO(List<Prescription> list) {
		List<PrescriptionForm> voList = new ArrayList<PrescriptionForm>();
		PrescriptionForm pf = null;
		for (int i = 0; list != null && i < list.size(); i++) {
			Prescription prescription = list.get(i);
			pf = new PrescriptionForm();
			pf.setUsername(prescription.getUser().getUsername());
			pf.setPre_id(prescription.getPre_id());
			pf.setPurpose(prescription.getPurpose());
			pf.setDoctorName(prescription.getDoctor().getName());
			pf.setTime(StringUtils.sqlDateToString(prescription.getTime()));
			pf.setMedicines(pms.POconvertVO(prescription.getMedicines()));
			voList.add(pf);
		}
		return voList;
	}
}

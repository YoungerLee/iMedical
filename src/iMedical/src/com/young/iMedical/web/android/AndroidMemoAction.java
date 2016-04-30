package com.young.iMedical.web.android;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.service.PrescriptionService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.web.action.BaseAction;
import com.young.iMedical.web.vo.MemorandumForm;

/**
 * 处理Android端的关于备忘录的请求
 * 
 * @author Young date:2016-04-29
 */
@SuppressWarnings("serial")
public class AndroidMemoAction extends BaseAction implements
		ModelDriven<MemorandumForm> {
	private MemorandumForm mf = new MemorandumForm();
	private MemorandumService memorandumService = (MemorandumService) ServiceProvider
			.getService(MemorandumService.SERVICE_NAME);
	private PrescriptionService prescriptionService = (PrescriptionService) ServiceProvider
			.getService(PrescriptionService.SERVICE_NAME);
	private PreMedicineService preMedicineService = (PreMedicineService) ServiceProvider
			.getService(PreMedicineService.SERVICE_NAME);
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);

	@Override
	public MemorandumForm getModel() {
		return mf;
	}

	public void android_memo_list() {
		try {
			PrintWriter out = response.getWriter();
			String user_id = request.getParameter("user_id");
			if (user_id != null && !"".equals(user_id)) {
				User user = userService.findUserById(user_id);
				List<Memorandum> memoList = memorandumService
						.findMemoByUser(user);
				List<MemorandumForm> voList = memorandumService
						.POconvertVO(memoList);
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

	public void android_add_memo() {

	}
}

package com.young.iMedical.web.action;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.web.vo.MedKitData;

@SuppressWarnings("serial")
public class MedKitAction extends BaseAction {
	private MemorandumService memorandumService = (MemorandumService) ServiceProvider
			.getService(MemorandumService.SERVICE_NAME);
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);

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
			if (!(username == null || "".equals(username))) {
				User user = userService.findUserByName(username);
				List<Memorandum> memoList = memorandumService
						.findMemoByUserToKit(user);
				if (!(memoList == null || memoList.isEmpty())) {
					List<MedKitData> voList = memorandumService
							.PO2MedKit(memoList);
					Gson gson = new Gson();
					String jsonStr = gson.toJson(voList);
					out.write("AA" + jsonStr + "FF");
					for (Memorandum memo : memoList) {
						memo.setFlag(1);
						memorandumService.updateMemo(memo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

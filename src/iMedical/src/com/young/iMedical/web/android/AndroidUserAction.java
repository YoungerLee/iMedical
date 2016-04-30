package com.young.iMedical.web.android;

import java.io.PrintWriter;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.LogService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.util.MD5Utils;
import com.young.iMedical.util.StringUtils;
import com.young.iMedical.web.action.BaseAction;
import com.young.iMedical.web.vo.UserForm;

@SuppressWarnings("serial")
public class AndroidUserAction extends BaseAction implements ModelDriven<User> {
	private User iMedUser = new User();
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private LogService logService = (LogService) ServiceProvider
			.getService(LogService.SERVICE_NAME);

	@Override
	public User getModel() {
		return iMedUser;
	}

	public void login() {
		try {
			PrintWriter out = response.getWriter();
			String username = iMedUser.getUsername();
			String password = iMedUser.getPassword();
			String md5Psw = MD5Utils.md5(password);
			UserForm userForm = new UserForm();
			// 使用登录名查询数据库，获取用户的详细信息
			if (username != null && !"".equals(username) && password != null
					&& !"".equals(password)) {
				User user = userService.findUserByName(username);
				if (user == null) {
					userForm.setCode(101);
					userForm.setMsg("用户名不存在");
					Gson gson = new Gson();
					String jsonStr = gson.toJson(userForm);
					out.write(jsonStr);
				} else {
					if (password == null || password.equals("")
							|| !user.getPassword().equals(md5Psw)) {
						userForm.setCode(102);
						userForm.setMsg("密码错误");
						Gson gson = new Gson();
						String jsonStr = gson.toJson(userForm);
						out.write(jsonStr);
					} else {
						// request.getSession().g
						request.getSession().setAttribute("user", user);
						userForm.setUsername(user.getUsername());
						userForm.setUser_id(user.getUser_id());
						userForm.setGender(user.getGender());
						userForm.setBirthday(StringUtils.sqlDateToString(user
								.getBirthday()));
						userForm.setSessionID(request.getSession().getId());
						userForm.setCode(100);
						userForm.setMsg("登录成功");
						logService.saveUserLog(request,
								"登录模块：当前用户【" + user.getUsername() + "】登录系统");
						Gson gson = new Gson();
						String jsonStr = gson.toJson(userForm);
						out.write(jsonStr);
					}
					out.flush();
					out.close();
				}
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

	public void logout() {
		try {
			PrintWriter out = response.getWriter();
			// 清空session
			request.getSession().invalidate();
			out.write("注销成功");
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

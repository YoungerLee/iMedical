package com.young.iMedical.web.action;

import java.io.PrintWriter;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.LogService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.util.MD5Utils;

@SuppressWarnings("serial")
public class UserAction extends BaseAction implements ModelDriven<User> {

	private User user = new User();

	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private LogService logService = (LogService) ServiceProvider
			.getService(LogService.SERVICE_NAME);

	@Override
	public User getModel() {
		return user;
	}

	public String login() {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String md5Psw = MD5Utils.md5(password);
			// 使用登录名查询数据库，获取用户的详细信息
			User user = userService.findUserByName(username);
			if (user == null) {
				out.write("用户名不存在！");
				return "error";
			} else {
				if (password == null || password.equals("")
						|| !user.getPassword().equals(md5Psw)) {
					out.write("密码错误！");
					return "error";
				} else {
					request.getSession().setAttribute("user", user);
					logService.saveUserLog(request,
							"登录模块：当前用户【" + user.getUsername() + "】登录系统");
					return "login";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String logout() {
		// 清空session
		request.getSession().invalidate();
		return "logout";
	}
}

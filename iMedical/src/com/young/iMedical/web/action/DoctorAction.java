package com.young.iMedical.web.action;

import java.io.PrintWriter;

import com.opensymphony.xwork2.ModelDriven;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.service.DoctorService;
import com.young.iMedical.service.LogService;
import com.young.iMedical.util.MD5Utils;

@SuppressWarnings("serial")
public class DoctorAction extends BaseAction implements ModelDriven<Doctor> {
	private Doctor doctor;
	private DoctorService doctorService = (DoctorService) ServiceProvider
			.getService(DoctorService.SERVICE_NAME);
	private LogService logService = (LogService) ServiceProvider
			.getService(LogService.SERVICE_NAME);

	@Override
	public Doctor getModel() {
		return doctor;
	}

	/****************************** 网页端的action ******************************/
	public String login() {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String md5Psw = MD5Utils.md5(password);
			// 使用登录名查询数据库，获取用户的详细信息
			Doctor doctor = doctorService.findDoctorByName(username);
			if (doctor == null) {
				out.write("用户名不存在！");
				return "error";
			} else {
				if (password == null || password.equals("")
						|| !doctor.getPassword().equals(md5Psw)) {
					out.write("密码错误！");
					return "error";
				} else {
					request.getSession().setAttribute("user", doctor);
					logService.saveDoctorLog(request,
							"登录模块：当前用户【" + doctor.getName() + "】登录系统");
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

	/************************* Android端的action ************************/
	public void android_doctor_login() {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String md5Psw = MD5Utils.md5(password);
			// 使用登录名查询数据库，获取用户的详细信息
			Doctor doctor = doctorService.findDoctorByName(username);
			if (doctor == null) {
				out.write("用户名不存在！");

			} else {
				if (password == null || password.equals("")
						|| !doctor.getPassword().equals(md5Psw)) {
					out.write("密码错误！");

				} else {
					request.getSession().setAttribute("user", doctor);
					logService.saveDoctorLog(request,
							"登录模块：当前用户【" + doctor.getName() + "】登录系统");
				}
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void android_doctor_logout() {
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

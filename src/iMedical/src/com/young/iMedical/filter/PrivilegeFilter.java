package com.young.iMedical.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.young.iMedical.domain.Doctor;
import com.young.iMedical.domain.User;

public class PrivilegeFilter implements Filter {
	private List<String> doctor_list = new ArrayList<String>();
	private List<String> user_list = new ArrayList<String>();

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		// System.out.println(uri);
		Object object = request.getSession().getAttribute("user");
		if (doctor_list.contains(uri) || user_list.contains(uri)) {
			// 说明当前资源需要权限
			if (request.getSession(false) == null || object == null) {// 当前资源需要登录
				response.getWriter().println(
						"<script language='javascript'>alert('当前资源需要权限，请先登录！');window.location='"
								+ request.getContextPath()
								+ "/index.jsp'</script>");
				return;
			} else {// 当前已经登录，过滤角色权限
				if (object instanceof Doctor && doctor_list.contains(uri)) {// 当前资源符合医生权限，放行
					chain.doFilter(req, resp);
				} else if (object instanceof User && user_list.contains(uri)) {// 当前资源符合普通用户权限，放行
					chain.doFilter(req, resp);
				} else {// 当前资源不符合角色权限
					if (object instanceof User) {// 若当前用户是普通用户，则返回用户主页
						resp.getWriter().println(
								"<script language='javascript'>alert('您不具有对应的权限！');window.location='"
										+ request.getContextPath()
										+ "/jsp/userHome.jsp'</script>");
						return;
					} else if (object instanceof Doctor) {// 若当前用户是医生，则返回医生页面
						resp.getWriter().println(
								"<script language='javascript'>alert('您不具有对应的权限！');window.location='"
										+ request.getContextPath()
										+ "/jsp/docHome.jsp'</script>");
						return;
					}
				}
			}
		} else {// 当前资源不需要权限
			chain.doFilter(req, resp);
		}
	}

	@SuppressWarnings("resource")
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		try {
			BufferedReader teacherReader = new BufferedReader(new FileReader(
					context.getRealPath("WEB-INF/doctor.txt")));
			String line = null;
			while ((line = teacherReader.readLine()) != null) {
				doctor_list.add(line);
			}

			BufferedReader studentReader = new BufferedReader(new FileReader(
					context.getRealPath("WEB-INF/user.txt")));
			line = null;
			while ((line = studentReader.readLine()) != null) {
				user_list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

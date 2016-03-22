<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<div align="center">
		<h1>iMedical</h1><hr>
		<s:if test="#session.user == null">
			Welcome To iMedical!
			<a href="${pageContext.request.contextPath }/index.jsp">请先登录</a>
		</s:if>
		<s:if test="#session.user != null">
			欢迎回来!<s:property value="#session.user.name"/>!<br>
			<a href="${pageContext.request.contextPath }/doctor_askAddMed.action">添加药品</a>
			<a href="${pageContext.request.contextPath }/medicine_medList.action">查看药品</a>
		</s:if>
	</div>
  </body>
</html>
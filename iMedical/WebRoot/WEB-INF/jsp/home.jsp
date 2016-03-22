<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  </head>
  <body align="center">
	<h1>iMedical</h1><hr>
	<s:if test="#session.user == null">
		Welcome To iMedical!
		<a href="${pageContext.request.contextPath }/index.jsp">请先登录</a>
	</s:if>
	<s:if test="#session.user != null">
		欢迎回来!#session.user.username!<br>
	</s:if>
  </body>
</html>


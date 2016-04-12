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
			欢迎回来!<s:property value="#session.user.username"/>!<br>
			<a href="${pageContext.request.contextPath }/prescription_presListOfUser.action">查看我的药方</a>
			<a href="${pageContext.request.contextPath }/memorandum_memoList.action">服药备忘录</a>
			<a href="${pageContext.request.contextPath }/user_logout.action">注销</a>
		</s:if>
	</div>
  </body>
</html>
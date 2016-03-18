<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  <body align="center">
	<h1>iMedical</h1><hr>
	<c:if test="${sessionScope.user==null}">
		Welcome To iMedical!
		<a href="${pageContext.request.contextPath }/index.jsp">请先登录</a>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		欢迎回来!${sessionScope.user.username }!<br>
	</c:if>
  </body>
</html>


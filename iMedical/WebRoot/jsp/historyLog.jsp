<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>History Log</h1><hr>
  	<table border="1" width="100%">
  		<tr>
  			<th>用户信息</th>
  			<th>事件</th>
  			<th>日期</th>
  			<th>状态</th>
  			<th>设定时间</th>
  			<th>实际吃药时间</th>			

  		</tr>
  		<c:forEach items="${requestScope.logList}" var="hl">
	  		<tr>
	  			<td><c:out value="${hl.username }"/></td>
	  			<td><c:out value="${hl.content }"/></td>
	  			<td><c:out value="${hl.date }"/></td>
	  			<c:if test="${hl.state == 1 }">
	  				<td><font color="blue">已吃药</font></td>
	  			</c:if>
	  				<c:if test="${hl.state == 0 }">
	  				<td><font color="blue">未吃药</font></td>
	  			</c:if>
	  			<td><c:out value="${hl.setTime }"/></td>
	  			<td><c:out value="${hl.actualTime }"/></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<a href="${pageContext.request.contextPath }/jsp/userHome.jsp">返回主页</a>
  </body>
</html>

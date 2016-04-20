<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>Show Prescription</h1><hr>
  	<c:forEach items="${requestScope.docPres }" var="dp">
  		<div align="left">
  			病人姓名：${dp.user.username }
 			病因：${dp.purpose }<br>
 			日期：${dp.time }
 		</div>
 		<div align="center">
		  	<table border="1" width="100%">
		  		<tr>
		  			<th>药物名称</th>
		  			<th>药物种类</th>
		  			<th>使用方法</th>
		  			<th>药物数量</th>
		  			<th>规	格</th>
		  		</tr>
		  		<c:forEach items="${dp.medicines }" var="pm">
			  		<tr>
			  			<td><c:out value="${pm.name }"/></td>
			  			<td><c:out value="${pm.type }"/></td>
			  			<td><c:out value="${pm.method }"/></td>
			  			<td><c:out value="${pm.quantity }"/></td>
			  			<td><c:out value="${pm.perNum }"/></td>
			  		</tr>
		  		</c:forEach>
		  	</table>
	  	</div>
  	</c:forEach>
  	<div align="center">
	  	<input type="submit" value="批量删除"/>
	  	<font color="red">祝您早日康复！</font>
	  	<a href="${pageContext.request.contextPath }/jsp/docHome.jsp">返回主页</a>
  	</div>
  </body>
</html>

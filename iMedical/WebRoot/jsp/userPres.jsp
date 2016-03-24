<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>Show Prescription</h1><hr>
  	<c:forEach items="${requestScope.userPres }" var="up">
  		<div align="left">
  			病人姓名：${up.user.username }<br>
 			病因：${up.purpose }<br>
 			日期：${up.time }<br>
 			医生姓名：${up.doctor.name }
 		</div>
 		<div align="center">
		  	<table border="1" width="100%">
		  		<tr>
		  			<th>药物名称</th>
		  			<th>药物种类</th>
		  			<th>使用方法</th>
		  			<th>药物数量</th>
		  			<th>规	格</th>
		  			<th>药物总量</th>
		  			<th>添加至备忘录</th>
		  		</tr>
		  		<c:forEach items="${up.medicines }" var="pm">
			  		<tr>
			  			<td><c:out value="${pm.name }"/></td>
			  			<td><c:out value="${pm.type }"/></td>
			  			<td><c:out value="${pm.method }"/></td>
			  			<td><c:out value="${pm.quantity }"/></td>
			  			<td><c:out value="${pm.perNum }"/></td>
			  			<td><c:out value="${pm.totalNum }"/></td>
			  			<td><a href="${pageContext.request.contextPath }/memorandum_askAddMemo.action?pre_id=${up.pre_id }&pm_id=${pm.pm_id }">添加至备忘录</a></td>
			  		</tr>
		  		</c:forEach>
		  	</table>
	  	</div>
  	</c:forEach>
  	<div align="center">
	  	<input type="submit" value="批量删除"/>
	  	<font color="red">祝您早日康复！</font>
	  	<a href="${pageContext.request.contextPath }/jsp/userHome.jsp">返回主页</a>
  	</div>
  </body>
</html>

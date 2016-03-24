<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function checkAll(allC){
  			var otherCs = document.getElementsByName("delId");
  			for(var i=0;i<otherCs.length;i++){
  				otherCs[i].checked = allC.checked;
  			}
  		}
  	</script>
  </head>
  <body style="text-align: center;">
  	<h1>药物管理</h1><hr>
  	<form action="${pageContext.request.contextPath}/medicine_delBatchMed.action" method="POST">
  	<table border="1" width="100%">
  		<tr>
  			<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
  			<th>药物名称</th>
  			<th>药物种类</th>
  			<th>使用方法</th>
  			<th>药物数量</th>
  			<th>规	格</th>
  			<th>购置日期</th>
  			<th>修改</th>
  			<th>删除</th>
  			<th>添加至药方</th>
  		</tr>
  		<c:forEach items="${requestScope.medList}" var="med">
	  		<tr>
	  			<td><input type="checkbox" name="delId" value="${med.med_id }" /></td>
	  			<td><c:out value="${med.name }"/></td>
	  			<td><c:out value="${med.type }"/></td>
	  			<td><c:out value="${med.method }"/></td>
	  			<td><c:out value="${med.quantity }"/></td>
	  			<td><c:out value="${med.perNum }"/></td>
	  			<td><c:out value="${med.buyTime }"/></td>
	  			<td><a href="${pageContext.request.contextPath }/medicine_askUpdateMed.action?id=${med.med_id }">修改</a></td>
	  			<td><a href="${pageContext.request.contextPath }/medicine_delOneMed.action?id=${med.med_id }">删除</a></td>
	  			<td><a href="${pageContext.request.contextPath }/medicine_addToPres.action?id=${med.med_id }">添加至药方</a></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<input type="submit" value="批量删除"/>
  	<a href="${pageContext.request.contextPath }/jsp/docHome.jsp">返回主页</a>
  	</form>
  </body>
</html>

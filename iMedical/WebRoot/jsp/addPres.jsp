<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function changeNum(id,obj,oldnum){
  			if(!/^[1-9]\d*$/.test(obj.value)){
  				alert("借用数量必须为正整数!");
  				obj.value=oldnum;
  				return;
  			}
  			window.location.href="${pageContext.request.contextPath }/medicine_changeNum.action?id="+id+"&buynum="+obj.value;
  		}
  	</script>
  </head>
  <body>
  	<h1>iMedical_Prescription</h1><hr>
  	<div align="center">
	  	<form action="${pageContext.request.contextPath }/prescription_addPres.action" method="POST">
	  		病人姓名:<input type="text" name="name" value="${param.name }" /><br>
	  		<br>
	  		病因:<textarea rows="5" cols="45" name="purpose"></textarea><br>
	  		<br>
	  		<input type="submit" value="确认"/>
	  	</form>
  	</div>
  	药品清单:<br>
  	<div align="right">
  		<a href="${pageContext.request.contextPath }/medicine_medList.action">添加药品</a>
  		<a href="${pageContext.request.contextPath }/medicine_clearMed.action">清空药品</a>
  	</div>
  	<table width="100%" border="1" style="text-align: center">
			<tr>
				<th>药品名称</th>
  				<th>药品类型</th>
  				<th>使用方法</th>
  				<th>药品规格</th>
  				<th>药品数量</th>
  				<th>库存状态</th>
			</tr>
			<c:set var="money" value="0" />
			<c:forEach items="${sessionScope.medMap}" var="entry">
				<tr>
					<td>${entry.key.name }</td>
					<td>${entry.key.type }</td>
					<td>${entry.key.method }</td>
					<td>${entry.key.perNum }</td>
					<td><input type="text" value="${entry.value }" style="width: 30px" onchange="changeNum('${entry.key.med_id }',this,${entry.value })"/>件</td>
					<td>
						<c:if test="${entry.value <= entry.key.quantity }">
							<font color="blue">数量充足</font>
						</c:if>
						<c:if test="${entry.value > entry.key.quantity }">
							<font color="red">数量不足</font>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div align="center"><a href="${pageContext.request.contextPath }/jsp/docHome.jsp">返回主页</a></div>
  </body>
</html>

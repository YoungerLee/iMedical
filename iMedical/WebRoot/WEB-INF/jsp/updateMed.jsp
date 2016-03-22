<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>药物管理_修改药物</h1><hr>
  	<form action="${pageContext.request.contextPath }/medicine_updateMed.action" method="POST" >
  		<input type="hidden" name="med_id" value="${sessionScope.med.med_id }">
  		<table border="1" align="center">
  			<tr>
  				<td>药物名称</td>
  				<td><input type="text" name="name" value="${sessionScope.med.name }" /></td>
  			</tr>
  			<tr>
  				<td>药物种类</td>
  				<td><input type="text" name="type" value="${sessionScope.med.type }" /></td>
  			</tr>
  			<tr>
  				<td>使用方法</td>
  				<td><input type="text" name="method" value="${sessionScope.med.method }" /></td>
  			</tr>
  			<tr>
  				<td>药物数量</td>
  				<td><input type="text" name="quantity" value="${sessionScope.med.quantity }" /></td>
  			</tr>
  			<tr>
  				<td>规	格</td>
  				<td><input type="text" name="perNum" value="${sessionScope.med.perNum }" /></td>
  			</tr>
  			<tr>
  				<td>购置时间</td>
  				<td><input type="text" name="buyTime" value="${sessionScope.med.buyTime }" /></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="修改药物"/>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

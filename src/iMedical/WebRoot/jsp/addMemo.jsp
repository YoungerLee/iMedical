<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body style="text-align: center;">
  	<h1>Add To Memorandum</h1><hr>
  	<form action="${pageContext.request.contextPath }/memorandum_addMemo.action" method="POST" >
  		<input type="hidden" name="pre_id" value="${sessionScope.pre_id }">
  		<input type="hidden" name="pm_id" value="${sessionScope.pm_id }">
  		<table border="1" align="center">
  			<tr>
  				<td>事件</td>
  				<td><input type="text" name="content" value="${sessionScope.content }" readonly="readonly" style="background: silver"/></td>
  			</tr>
  			<tr>
  				<td>开始日期</td>
  				<td><input type="text" name="beginDate" value="${param.beginDate }" /></td>
  			</tr>
  			<c:if test="${sessionScope.frequency == 1 }">
	  			<tr>
	  				<td>提醒时间</td>
	  				<td><input type="text" name="time1" value="${param.time1 }" /></td>
	  			</tr>
  			</c:if>
  			<c:if test="${sessionScope.frequency == 2 }">
  				<tr>
	  				<td>提醒时间1</td>
	  				<td><input type="text" name="time1" value="${param.time1 }" /></td>
	  			</tr>
	  			<tr>
	  				<td>提醒时间2</td>
	  				<td><input type="text" name="time2" value="${param.time2 }" /></td>
	  			</tr>
  			</c:if>
  			<c:if test="${sessionScope.frequency == 3 }">
  				<tr>
	  				<td>提醒时间</td>
	  				<td><input type="text" name="time1" value="${param.time1 }" /></td>
	  			</tr>
  				<tr>
	  				<td>提醒时间</td>
	  				<td><input type="text" name="time2" value="${param.time2 }" /></td>
	  			</tr>
	  			<tr>
	  				<td>提醒时间</td>
	  				<td><input type="text" name="time3" value="${param.time3 }" /></td>
	  			</tr>
  			</c:if>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="提交"/>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

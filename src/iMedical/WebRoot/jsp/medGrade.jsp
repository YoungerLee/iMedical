<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
		
	</script>
  </head>
  <body>
  	<form action="${pageContext.request.contextPath }/medGrade_addGrade.action" method="post">
  		<input type="hidden" name="med_id" value="${requestScope.med.med_id }">
  		<table border="1" align="center">
  			<tr>
  				<td>药品名称</td>
  				<td><input type="text" name="name" value="${requestScope.med.name }" readonly="readonly" style="background: silver" /></td>
  			</tr>
  			<tr>
  				<td>评分</td>
  				<td>
  					<select id="gradeID" name="grade">
						<option>5.0</option>
						<option>4.5</option>
						<option>4.0</option>
						<option>3.5</option>
						<option>3.0</option>
						<option>2.5</option>
						<option>2.0</option>
						<option>1.5</option>
						<option>1.0</option>
					</select>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="提交"/>
  				</td>
  			</tr>
  		</table>
	</form>	
  </body>
</html>

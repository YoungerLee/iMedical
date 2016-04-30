<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<div align="center">
	 	<h1>iMedical</h1><hr>
	 	
	 	<form action="${pageContext.request.contextPath}/medkit_memo.action" method="post">
	 		<table>
		 		<tr>
					<td>用户名:</td>
					<td><input type="text" name="name" ></td>
					<td id="username_msg"></td>
				</tr>
	 		</table>
	 		<input type="submit" value="查看"/>
	 	</form>
 	</div>
  </body>
</html>
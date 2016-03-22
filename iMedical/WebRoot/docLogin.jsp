<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
  		function checkForm(){
  			var canSub = true;
  			//非空校验
  			canSub = checkNull("username","用户名不能为空!") && canSub;
  			canSub = checkNull("password","密码不能为空!") && canSub;
  			canSub = checkNull("valistr","验证码不能为空!") && canSub;
  			return canSub;
  		
  		}
  		function checkNull(name,msg){
  			document.getElementById(name+"_msg").innerHTML = "";
  			var objValue = document.getElementsByName(name)[0].value;
  			if(objValue == null || objValue == ""){
				document.getElementById(name+"_msg").innerHTML = "<font color='red'>"+msg+"</font>";
  				return false;
  			}
  			return true;
  		}
  	</script>
  </head>
  <body>
  	<div align="center">
	 	<h1>iMedical</h1><hr>
	 	<font color="red">${msg }</font>
	 	<form action="${pageContext.request.contextPath}/doctor_login.action" method="post">
	 		<table>
		 		<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" ></td>
					<td id="username_msg"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
					<td id="password_msg"></td>
				</tr>
	 		</table>
	 		<input type="submit" value="登录"/>
	 	</form>
 	</div>
  </body>
</html>
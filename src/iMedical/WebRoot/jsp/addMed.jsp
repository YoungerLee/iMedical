<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function checkData(){
  			var price = document.getElementsByName("price")[0].value;
  			var restNum = document.getElementsByName("restNum")[0].value;
  			if(isNaN(price) || isNaN(restNum)){
  				alert("单价和数量必须是数字!");
  				document.getElementsByName("price")[0].value = "";
  				document.getElementsByName("restNum")[0].value = "";
  				return false;
  			}else if(price<=0 || restNum<=0){
	  			alert("单价和数量必须大于0!")
	  			document.getElementsByName("price")[0].value = "";
	  			document.getElementsByName("restNum")[0].value = "";
	  			return false;
  			}else{
  				return true;
  			}
  		}
  	</script>
  </head>
  <body style="text-align: center;">
  	<h1>药物管理_添加药物</h1><hr>
  	<form action="${pageContext.request.contextPath }/medicine_addMed.action" method="post">
  		<table border="1" align="center">
  			<tr>
  				<td>药物名称</td>
  				<td><input type="text" name="name" <s:property value="#parameters.name"/> /></td>
  			</tr>
  			<tr>
  				<td>药物种类</td>
  				<td><input type="text" name="type" <s:property value="#parameters.type"/>  /></td>
  			</tr>
  			<tr>
  				<td>使用方法</td>
  				<td><input type="text" name="method" <s:property value="#parameters.method"/>  /></td>
  			</tr>
  			<tr>
  				<td>药物数量</td>
  				<td><input type="text" name="quantity" <s:property value="#parameters.quantity"/> /></td>
  			</tr>
  			<tr>
  				<td>规	 格</td>
  				<td><input type="text" name="perNum" <s:property value="#parameters.perNum"/>  /></td>
  			</tr>
  			<tr>
  				<td>购置日期</td>
  				<td><input type="text" name="buyTime" <s:property value="#parameters.buyTime"/>  /></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="添加药物"/>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

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
  	<h1>Memorandum List</h1><hr>
  	<form action="${pageContext.request.contextPath}/memorandum_delBatchMemo.action" method="POST">
  	<table border="1" width="100%">
  		<tr>
  			<th><input type="checkbox" onclick="checkAll(this)"/>全选</th>
  			<th>事件</th>
  			<th>开始日期</th>
  			<th>结束日期</th>
  			<th>提醒时间</th>			
  			<th>修改</th>
  			<th>删除</th>	
  			<th>确认</th>
  		</tr>
  		<c:forEach items="${requestScope.memoList}" var="memo">
	  		<tr>
	  			<td><input type="checkbox" name="delId" value="${memo.mem_id }" /></td>
	  			<td><c:out value="${memo.content }"/></td>
	  			<td><c:out value="${memo.beginDate }"/></td>
	  			<td><c:out value="${memo.endDate }"/></td>
	  			<td><c:out value="${memo.time }"/></td>
	  			<td><a href="${pageContext.request.contextPath }/memorandum_askUpdateMemo.action?id=${memo.mem_id }">修改</a></td>
	  			<td><a href="${pageContext.request.contextPath }/memorandum_delOneMemo.action?id=${memo.mem_id }">删除</a></td>
	  			<td><a href="${pageContext.request.contextPath }/historylog_addHistoryLog.action?id=${memo.mem_id }">确认</a></td>
	  		</tr>
  		</c:forEach>
  	</table>
  	<input type="submit" value="批量删除"/>
  	<a href="${pageContext.request.contextPath }/jsp/userHome.jsp">返回主页</a>
  	</form>
  </body>
</html>

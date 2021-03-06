<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Memo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询备忘录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  <link rel="stylesheet" href="css/global.css">

  </head>

    <body>
        <div class="top">
        	<div class="logo">
                <br>
              	<p style="text-align:left" >&nbsp;&nbsp;&nbsp;个人信息管理系统</p>
              	
             </div>
             <p style="text-align:right"  >欢迎，${sessionScope.User}</p>
         </div>
		<%@ include file="menu.jsp" %>
		<div class="select">
			<form action="servlet/SelectMemoServlet" method="post">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按日期查询：
				<input type="text" name="time">日期格式为：年份-月份-日期（例：17-05-23）
				<input style="height: 25px;width: 70px" type="submit" value="确定" />
				<a href="servlet/MemoInformationServlet"><input style="height: 25px;width: 70px" type="button" value="返回" /></a>
			</form>
		</div>

        <div class="shadow">
        	<%List<Memo> list=(List<Memo>) request.getAttribute("list"); %>
         	<table border="1">
         		<tr>
         			<th width="200px">时间</th>
         			<th width="400px">事件</th>
         			<th width="100px">地点 </th>
         			<th width="50px">操作</th>
         			<th width="50px">操作 </th>
         		</tr>
				<c:forEach var="memo" items="${list}">
     			<tr>
     				<td>${memo.time}</td>
     				<td>${memo.memo}</td> 
     				<td>${memo.place}</td> 
					<td><a href="servlet/EditMemoServlet?addressid=${memo.memoid}">编辑</a></td>
					<td><a href="servlet/DeleteMemoServlet?addressid=${memo.memoid}">删除</a></td>
     			</tr>
				</c:forEach>
         		<tr>
					<td colspan="7" width="200px" height="50px" align="center">
         				<a href="addaddress.jsp"><input style="height: 35px;width: 70px" type="submit" name="Submit" value="添加" /></a>
         			</td>
         		</tr>
			</table>
         </div>
    </body>
</html>

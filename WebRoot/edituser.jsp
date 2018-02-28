<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  	<link rel="stylesheet" type="text/css" href="css/global.css">

  </head>
    <style>
  </style>
  <script type="text/javascript" src="jquery.js"></script> 

    <body>
        <div class="top">
        	<div class="logo">
                <br>
              	<p style="text-align:left" >&nbsp;&nbsp;&nbsp;个人信息管理系统</p>
              	
             </div>
             <p style="text-align:right"  >欢迎，${sessionScope.User}</p>
         </div>
		<%@ include file="menu.jsp" %>
        <div class="noshadow">
        <%List<User> list=(List<User>) request.getAttribute("list"); %>
        <form name="" action="servlet/EditUserDatabaseServlet" method="post">
        	<input type="hidden" name="username" value="<%=list.get(0).getUsername()%>">
			密码：<input type="password" name="password" value="<%=list.get(0).getPassword()%>"><br><br>
   			确认密码：<input type="password" name="passwordconfirm"><br><br>
   			 姓名：<input type="text" name="name" value="<%=list.get(0).getName()%>"><br><br>
   			 性别：<input type="radio" checked="checked" name="sex" value="male" />男
   		    <input type="radio" name="sex" value="female" />女<br><br>
   			出生年月：
   			<select name="year">
   			<c:forEach begin="1990" end="2010" varStatus="i">
   				 <option value="${i.index}"><c:out value="${i.index}"></c:out></option>
   			</c:forEach>
   			</select>年
   			<select name="month">
   			<c:forEach begin="1" end="12" varStatus="j">
   				 <option value="${j.index}"><c:out value="${j.index}"></c:out></option>
   			</c:forEach>
   			</select>月<br><br>
     		<input type="submit" value="确认">&nbsp;&nbsp;&nbsp;
     		&nbsp;&nbsp;&nbsp;
     		<a href="servlet/InformationServlet"><input type="button" value="返回"></a>
         </form>
        </div>
    </body>
</html>

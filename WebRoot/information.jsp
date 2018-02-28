<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
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
        <div class="shadow">
        <%List<User> list=(List<User>) request.getAttribute("list"); %>
		<form name="" action="servlet/EditUserServlet" method="get">
			<input type="hidden" name="userid" value="<%=list.get(0).getUserid()+""%>">
         	<table border="1" bordercolor="#dedede">
         		<tr>
         			<td width="200px" height="50px" align="center">UID：</td>
         			<td width="600px"><%=list.get(0).getUserid()+""%></td>
         		</tr>
         		<tr>
         			<td width="200px" height="50px" align="center">姓名：</td>
         			<td width="600px"><%=list.get(0).getName()%></td>
         		</tr>
         		<tr>
         			<td width="200px" height="50px" align="center">性别：</td>
         			<td><%=list.get(0).getSex()%></td>
         		</tr>
         		<tr>
        			<td width="200px" height="50px" align="center">出生年月：</td>
        			<td><%=list.get(0).getYear()%>年
             			<%=list.get(0).getMonth()%>月</td>
         		</tr>
         		<tr>
         			<td colspan="2" width="200px" height="50px" align="center">
         				<input style="height: 35px;width: 70px" type="submit" name="Submit" value="编 辑" />
         			</td>
         		</tr>
         	</table>
         </form>
       </div>
    </body>
</html>

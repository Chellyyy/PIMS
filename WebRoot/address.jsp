<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Address" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通讯录管理</title>
    
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
			<form action="servlet/SelectAddressServlet" method="post">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按姓名查询：
				<input type="text" name="addressname">
				<input style="height: 25px;width: 70px" type="submit" value="确定" />
				<a href="servlet/AddressInformationServlet"><input style="height: 25px;width: 70px" type="button" value="返回" /></a>
			</form>
		</div>

        <div class="shadow">
        <%List<Address> list=(List<Address>) request.getAttribute("list"); %>
        
         <table border="1" bordercolor="#dedede">
         	<tr>
         		<th>姓名</th>
         		<th>电话</th>
         		<th>工作地点</th>
         		<th>城市</th>
         		<th>备注</th>
         		<th>操作</th>
         		<th>操作</th>
         	</tr>
			<c:forEach var="address" items="${list}">
     		<tr>
     			<td>${address.addressname}</td>
     			<td>${address.telephone}</td> 
     			<td>${address.address}</td> 
     			<td>${address.city}</td> 
     			<td>${address.other}</td> 
				<td><a href="servlet/EditAddressServlet?addressid=${address.addressid}">编辑</a></td>
				<td><a href="servlet/DeleteAddressServlet?addressid=${address.addressid}">删除</a></td>
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

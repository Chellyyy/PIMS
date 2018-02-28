<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Income" %>
<%@ page import="entity.Expense" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>财务管理</title>
    
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
        <%List<Income> ilist=(List<Income>) request.getAttribute("ilist"); %>
         <table border="1" bordercolor="#dedede">
         	<tr style="background-color:#09b000;color: white;" align="center">
         		<td colspan="5">收入情况</td>
         	</tr>
        	<tr>
         		<th width="200px">时间</th>
         		<th width="400px">项目</th>
         		<th width="100px">金额 </th>
         		<th width="50px">操作</th>
         		<th width="50px">操作 </th>
        	 </tr>
			<c:forEach var="income" items="${ilist}">
     		<tr>
     			<td>${income.time}</td>
     			<td>${income.item}</td> 
     			<td>${income.money}</td> 
				<td><a href="servlet/EditIncomeServlet?incomeid=${income.incomeid}">编辑</a></td>
				<td><a href="servlet/DeleteIncomeServlet?incomeid=${income.incomeid}">删除</a></td>
     		</tr>
			</c:forEach>
         	<tr>
         		<td colspan="7" width="200px" height="50px" align="center">
         			<a href="addincome.jsp"><input style="height: 35px;width: 70px" type="submit" name="Submit" value="添加" /></a>
         		</td>
         	</tr>
        </table>
	</div> 
    <br>
    <div class="shadow">
         <%List<Expense> elist=(List<Expense>) request.getAttribute("elist"); %>
         <table border="1" bordercolor="#dedede">
         	<tr style="background-color:#c90000;color: white;" align="center">
         		<td colspan="5">消费情况</td>
         	</tr>
        	<tr>
         		<th width="200px">时间</th>
         		<th width="400px">项目</th>
         		<th width="100px">金额 </th>
         		<th width="50px">操作</th>
         		<th width="50px">操作 </th>
         	</tr>
			<c:forEach var="expense" items="${elist}">
     		<tr>
     			<td>${expense.time}</td>
     			<td>${expense.item}</td> 
     			<td>${expense.money}</td> 
				<td><a href="servlet/EditExpenseServlet?expenseid=${expense.expenseid}">编辑</a></td>
				<td><a href="servlet/DeleteExpenseServlet?expenseid=${expense.expenseid}">删除</a></td>
     		</tr>
			</c:forEach>
         	<tr>
         		<td colspan="7" width="200px" height="50px" align="center">
         			<a href="addexpense.jsp"><input style="height: 35px;width: 70px" type="submit" name="Submit" value="添加" /></a>
         		</td>
         	</tr>
        </table>
	</div>
    <br>
    <div class="shadow">
         <table border="1" bordercolor="#dedede">
         	<tr style="background-color:#5a5a5a;color: white;" align="center">
         		<td colspan="5">财务总况</td>
         	</tr>
         	<tr>
         		<th>总收入</th>
         		<th>总支出</th>
         		<th>余额 </th>
         	</tr>
     		<tr>
     			<td><%=request.getAttribute("incomesum")%></td>
     			<td><%=request.getAttribute("expensesum")%></td>
     			<td><%=request.getAttribute("balance")%></td> 
     		</tr>
        </table>
     </div>
    </body>
</html>

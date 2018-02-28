<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息管理系统</title>
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
 	<div class="container">
    	<div class="content">
        	<div class="logo">
                <br>
              	<p style="text-align:right" >个人信息管理系统&nbsp;&nbsp;&nbsp;</p>
             </div>
         </div>
         <div class="win">
              <form name="" action="servlet/LoginServlet" method="post" >
				<table border="1" align="center" cellpadding="2" cellspacing="0" bordercolor="#dedede">
  					<tr>
    					<th colspan="2" align="center" bgcolor="#00cca3" height="50px">用户登录 </th>
  					</tr>
					<tr height="40px">
    					<td width="73" align="right" style="color: black;">用户名：</td>
    					<td width="218">&nbsp;&nbsp;<input type="text" id="username" name="username" ></td>
  					</tr>
  					<tr height="40px">
    					<td align="right" style="color: black;">密码：</td>
    					<td>&nbsp;&nbsp;<input type="password" name="password"  id="password" /></td>
  					</tr>
  					<tr height="40px">
    					<td colspan="2" align="center">
    					<input type="submit" name="Submit" value="登 录" />&nbsp;&nbsp;&nbsp;&nbsp;
      					<input name="Submit2" type="reset" value="重 置" />&nbsp;&nbsp;&nbsp;&nbsp;
      					<a href='register.jsp'>注册</a>
  					</tr>
				</table>
			</form>
		</div>
	</div>

  </body>
</html>

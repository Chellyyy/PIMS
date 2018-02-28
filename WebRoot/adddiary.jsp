<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加日记</title>
    
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
        <div class="noshadow">
         <form name="" action="servlet/AddDiaryServlet" method="post">
         	<input type="hidden" name="userid" value="">
         	地点：<input type="text" name="place" width="500px"><br><br>
         	人物：<input type="text" name="people" width="500px"><br><br>
			事情：<textarea name="detail" style="width: 400px;height: 200px"></textarea><br><br>
        	 <input style="height: 35px;width: 70px" type="submit" name="Submit" value="确定" />&nbsp;&nbsp;&nbsp;
     		<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;
     		<a href="servlet/DiaryInformationServlet"><input type="button" value="返回"></a>
          </form>
         </div>
    </body>
</html>

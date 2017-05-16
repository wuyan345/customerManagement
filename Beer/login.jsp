<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="refresh" content="5; url=http://www.baidu.com/" /> -->
<title>系统登录</title>
</head>
<body>

	<h1><p style="text-align:center">客户信息管理系统</p></h1>
	<hr />
	<div id="content" style="line-height:180%;height:50px;width:1350px;float:left;"></div>
	<h2><p style="text-align:center">
		<%
			String status = (String)request.getAttribute("isLog");
			if(null == status)
				out.print("请登录");
			else if("NO".equals(status))
				out.print("账号或密码错误，请重新输入");
		%>
	</p></h2>
	<div id="menu" style="height:200px;width:550px;float:left;"></div>
	<div id="content" style="line-height:170%;height:300px;width:60px;float:left;">
		用户名
		<br />
		密码
	</div>
	<div id="content" style="line-height:180%;height:300px;width:400px;float:left;">
		<form action="Login.do" method="POST">
			<input type="text" name="ID">
			<br />
			<input type="password" name="password" />
			<br /><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="登录" />
		</form>
	</div>

</body>
</html>
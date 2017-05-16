<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p style="text-align:right">
		<%
			String username = (String)request.getAttribute("name");
			out.print("你好，" + username);
		%>
		&nbsp;
		<a href="/ServletLearning/Login.do?action=logout">退出</a>
	</p>
	<h1><p style="text-align:center">客户信息登记系统</p></h1>
	<div style="left: 500px; position: absolute;">
	<a href="/ServletLearning/CustomersSystem.do" target="_blank">添加客户</a>
	</div>
	<div style="left: 800px; position: absolute;">
	<a href="/ServletLearning/CustomerSearch.do" target="_blank">高级搜索</a>
	</div>
	<a href="/ServletLearning/CustomerQuery.do" target="_blank"><center>查询客户</center></a>
	<hr />
	<h2><p style="text-align:center">没有搜索到结果</p></h2>
	
	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><p style="text-align:center">客户信息登记系统</p></h1>
	<div style="left: 500px; position: absolute;">
	<a href="/ServletLearning/index.html" target="_blank">添加客户</a>
	</div>
	<div style="left: 800px; position: absolute;">
	<a href="/ServletLearning/customerSearch.jsp" target="_blank">高级搜索</a>
	</div>
	<a href="/ServletLearning/customerQuery.jsp" target="_blank"><center>查询客户</center></a>
	<hr />
	<h3><p style="text-align:center">高级搜索</p></h3>
	
	<div id="content" style="line-height:170%;height:300px;width:400px;float:left;">
		<form action="#" method="POST">
			<input type="text" name="name" value="123">
			<br />
			<input type="radio" name="gender" value="男">男
			<input type="radio" name="gender" value="女">女
			<br />
			<input type="text" name="birthday" />
			<br />
			<input type="text" name="cellphone" />
			<br />
			<input type="text" name="address" />
			<br />
			<input type="text" name="email" />
			<br />
			<textarea rows="4" cols="40" name="description"></textarea>
			<br />
			<input type="submit" value="添加客户" />
			<input type="reset" value="重置" />
		</form>
	</div>
</body>
</html>
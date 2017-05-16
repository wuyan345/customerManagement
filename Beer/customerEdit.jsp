<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
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
	<a href="/ServletLearning/customerSearch.jsp" target="_blank">高级搜索</a>
	</div>
	<a href="/ServletLearning/CustomerQuery.do" target="_blank"><center>查询客户</center></a>
	<hr />
	<h3><p style="text-align:center">编辑客户</p></h3>
	
	<div id="menu" style="height:200px;width:540px;float:left;"></div>
	<div id="content" style="line-height:170%;height:300px;width:80px;float:left;">
		姓名
		<br />
		性别
		<br />
		出生年月
		<br />
		手机
		<br />
		住址
		<br />
		邮箱
		<br /><br />
		描述
	</div>
	
	<%! 
		String[][] data = null;
		int row = 0;
		String id;
	%>
	<%
		data = (String[][])request.getAttribute("DBdata");
		row = (int)request.getAttribute("row");
		id = (String)request.getAttribute("id");
	%>
	
	<div id="content" style="line-height:170%;height:300px;width:400px;float:left;">
		<form action="CustomerEdit.do?edit=1&id=<% out.print(id); %>" method="POST">
			<input type="text" name="name" value=<% out.print(data[row][1]); %>>
			<br />
			<input type="radio" name="gender" value="男" <% if(data[row][2].equals("男")) out.print("checked"); %>>男
			<input type="radio" name="gender" value="女" <% if(data[row][2].equals("女")) out.print("checked"); %>>女
			<br />
			<input type="text" name="birthday" value=<% out.print(data[row][3]); %>>
			<br />
			<input type="text" name="cellphone" value=<% out.print(data[row][4]); %>>
			<br />
			<input type="text" name="address" value=<% out.print(data[row][5]); %>>
			<br />
			<input type="text" name="email" value=<% out.print(data[row][6]); %>>
			<br />
			<textarea rows="4" cols="40" name="description"><% out.print(data[row][7]); %></textarea>
			<br />
			<input type="submit" value="编辑客户" />
			<input type="reset" value="重置" />
		</form>
	</div>

</body>
</html>
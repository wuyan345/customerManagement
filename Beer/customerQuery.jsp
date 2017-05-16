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
	<h1><p style="text-align:center">客户信息管理系统</p></h1>
	<div style="left: 500px; position: absolute;">
	<a href="/ServletLearning/CustomersSystem.do" target="_blank">添加客户</a>
	</div>
	<div style="left: 800px; position: absolute;">
	<a href="/ServletLearning/CustomerSearch.do" target="_blank">高级搜索</a>
	</div>
	<a href="/ServletLearning/CustomerQuery.do" target="_blank"><center>查询客户</center></a>
	<hr />
	<h3><p style="text-align:center">客户列表</p></h3>

	<table border="1" align="center">
	    <tr>
	        <th>姓名</th>
	        <th>性别</th>
	        <th>出生年月</th>
	        <th>手机</th>
	        <th>住址</th>
	        <th>邮箱</th>
	        <th>描述</th>
	        <th>操作</th>
	    </tr>
    	<% 
    		int rows = (int)request.getAttribute("rows");
    		String[][] data = (String[][])request.getAttribute("DBdata");
    		for(int j=rows-1; j>=0; j--){
    			out.print("<tr>");
    			for(int i=1; i<8; i++)
    				out.print("<td>" + data[j][i] + "</td>");
    			out.print("<td>");
    			out.print("<a href=\"/ServletLearning/CustomerEdit.do?id=" + data[j][0] + "\"> 编辑&nbsp; </a>");
    			out.print("<a href=\"/ServletLearning/CustomerDelete.do?id=" + data[j][0] + "\"> 删除 </a>");
    			out.print("</td>");
    			out.print("</tr>");
    		}
    	%>
	</table>
</body>
</html>
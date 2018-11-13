<%@page import="com.imooc.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>



    <%
		if(session.getAttribute("user")!=null){
		User user = (User)session.getAttribute("user");
			System.out.println(user.getPath());

		// 获得绝对路径最后一个\的位置
		int idx = user.getPath().lastIndexOf("\\");
		// 获得文件上传的唯一文件名：
		String fileName = user.getPath().substring(idx+1);
	%>
	<div class="login">
		<div class="header">
			<h1>登录成功</h1>
		</div>
		<div class="content" align="center">
			<table align="center">

				<tr>

					<td align="center"><img style="height: 300px;" align="center" src="\upload\<%=fileName%>"  /></td>
				</tr>
				<tr>
					<td align="center">欢迎<font color="red"><%=user.getNickname()%></font>        &nbsp;&nbsp;登录成功！</td>
				</tr>
			</table>
		</div>
	</div>
	<%
		}else {
	%>
	<div class="login">
		<div class="header">
			<h1>您好还没有登录！请先去<a href="login.jsp"/>登录</h1>
		</div>
	</div>
    <%
		}
	%>
</body>
</html>
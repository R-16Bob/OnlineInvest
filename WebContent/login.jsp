<%@ page language="java"     pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
		<style>
		p {color:red}
		</style>
	</head>
	<body>
		<h1 align="center">在线问卷系统</h1>
		<p align="center" color=red>${error}</p>
		<form action="Login" method=get>
		<table align="center">
		<tr><td>用户名</td><td><input type=text name=uname></td></tr>
		<tr><td>密&nbsp码</td><td><input type=password name=pwd></td></tr>
		<tr><td align="center"><input type="submit" value="登录/注册"	></td>
		<td align="center"><input type="reset" value="取消"></td></tr>
		</table>
		</form>
	</body>
</html>
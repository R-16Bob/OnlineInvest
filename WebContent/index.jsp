<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	   <title>欢迎使用线上问卷系统！</title>
	 </head>
	<body>
	<%
		//如果没有登录，就转到登录界面
		if(session.getAttribute("uname")==null){
			response.sendRedirect("login.jsp");
		}
	
		String ip=request.getRemoteAddr();
		session.setAttribute("ip", ip);
		%>
	     <h1>欢迎使用线上问卷系统！${uname}</h1>
	     <p>${ip}</p>
	</body>
</html>
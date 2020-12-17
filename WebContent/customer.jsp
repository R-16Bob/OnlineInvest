<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>客户列表</title>
		 <style type="text/css">
			table.hovertable {
			    font-family: verdana,arial,sans-serif;
			    font-size:11px;
			    color:#333333;
			    border-width: 1px;
			    border-color: #999999;
			    border-collapse: collapse;
			}
			table.hovertable th {
			    background-color:#c3dde0;
			    border-width: 1px;
			    padding: 8px;
			    border-style: solid;
			    border-color: #a9c6c9;
			}
			table.hovertable tr {
			    background-color:#d4e3e5;
			}
			table.hovertable td {
			    border-width: 1px;
			    padding: 8px;
			    border-style: solid;
			    border-color: #a9c6c9;
			}
			</style>
			<script type="text/javascript">
			   function del() {
				var msg = "您真的确定要删除吗?请确认！";
				if(confirm(msg)){
				    return true;
				}else{
				    return false;
				}
			   }
			</script>
	</head>
	<body>
		<a href="addCus.jsp">增加客户</a>
		<table width="60%" border=1 class="hovertable">
		<thead>
		<tr><th>ID</th><th>姓名</th><th>电话</th><th></th></tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${clist}">
	         <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	           <td>${c.id}</td>
	           <td>${c.name}</td>
	           <td>${c.phone}</td>
	           <td>
	                <a href="customer.action?opttype=delete&id=${c.id}">删除</a>
	                <a href="customer.action?opttype=edit&id=${c.id}">编辑</a>
	           </td>
	         </tr>
	     </c:forEach>
		</tbody>
		</table>
	</body>
</html>
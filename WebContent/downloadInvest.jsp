<%@ page contentType="application/vnd.ms-word; charset=utf-8"%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder,entity.Invest" %>
 
<%
	Invest inv = (Invest)request.getSession().getAttribute("inv");
         //对中文文件名编码
	String fileName = URLEncoder.encode(inv.getTitle(), "UTF-8") + ".doc";
	response.setHeader("Content-disposition", "attachment; filename=" + fileName);
%>
<html xmlns:v="urn:schemas-microsoft-com:vml" 
      xmlns:o="urn:schemas-microsoft-com:office:office" 
      xmlns:w="urn:schemas-microsoft-com:office:word" 
      xmlns:m="http://schemas.microsoft.com/office/2004/12/omml" 
      xmlns:st1="urn:schemas-microsoft-com:office:smarttags" 
      xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="ProgId" content="Word.Document">
<meta name="Generator" content="Microsoft Word 12">
<meta name="Originator" content="Microsoft Word 12"> 
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>${inv.title}下载</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/sticky-footer/sticky-footer.css" rel="stylesheet">
</head>
<body>
<div class="container">
      <div class="page-header">
        <h1>${inv.title}</h1>
		<br />
		<h4>${inv.content}</h4>
      </div>
     <form role="form" action="SubmitInvest" method="post">
		<c:forEach var="q" items="${qlist}">
		<div class="form-group">
		 <label>${q.q_content}</label>
         <c:if test="${q.type==1}">
         <c:forEach var="c" items="${cvlist}">
         <c:if test="${c.q_id==q.q_id}">
         <div class="radio">
             <label>
                 <input type="radio" name="q${c.q_id}"  value="${c.c_content}" > ${c.c_content}
             </label>
         </div>
         </c:if>
         </c:forEach>
         </c:if>
         <c:if test="${q.type==2}">
         <c:forEach var="c" items="${cvlist}">
         <c:if test="${c.q_id==q.q_id}">
         <div class="checkbox">
             <label><input type="checkbox" name="q${c.q_id}" value="${c.c_content}">${c.c_content}</label>
         </div>
         </c:if>
         </c:forEach>
         </c:if>
         <c:if test="${q.type!=1&&q.type!=2}">
         <input type="text" class="form-control" name="q${q.q_id}">
         </c:if>
         </div>
         <br>
		</c:forEach>

     </form>

    </div>
</body>
</html>
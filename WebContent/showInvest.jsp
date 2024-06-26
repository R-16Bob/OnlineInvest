<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>${inv.title}</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sticky-footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Begin page content -->
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
		<c:if test="${inv.status==2}">
	   <div class="col-sm-offset-5 col-sm-7">
       <button type="submit" class="btn btn-primary">提交</button>
	   </div>
	   </c:if>
     </form>

    </div>
  </body>
</html>

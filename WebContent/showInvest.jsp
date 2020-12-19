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
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/sticky-footer/sticky-footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>${inv.title}</h1>
		<br />
		<h4>${inv.content}</h4>
      </div>
     <form role="form">
		<c:forEach var="q" items="${qlist}">
		<div class="form-group">
		 <label>${q.q_content}</label>
         <c:if test="${q.type==1}">
         <c:forEach var="c" items="${cvlist}">
         <c:if test="${c.q_id==q.q_id}">
         <div class="radio">
             <label>
                 <input type="radio" name="optionsRadios"  value="option1" checked> ${c.c_content}
             </label>
         </div>
         </c:if>
         </c:forEach>
         </c:if>
         <c:if test="${q.type==2}">
         <c:forEach var="c" items="${cvlist}">
         <c:if test="${c.q_id==q.q_id}">
         <div class="checkbox">
             <label><input type="checkbox" name="" value="">${c.c_content}</label>
         </div>
         </c:if>
         </c:forEach>
         </c:if>
         <c:if test="${q.type!=1&&q.type!=2}">
         <input type="text" class="form-control" name="">
         </c:if>
         </div>
         <br>
		</c:forEach>

	   <div class="col-sm-offset-5 col-sm-7">
       <button type="submit" class="btn btn-primary">提交</button>
	   </div>
     </form>

    </div>
  </body>
</html>

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

    <title>编辑问题</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/sticky-footer/sticky-footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Begin page content -->
    <br>
    <div class="container">
     <form role="form" action="EditInvest" method="post">  
     <input type="hidden" name="opt" value="update">
     <input type="hidden" name="q_id" value="${que.q_id}">
     <h4>新的问题描述：</h4>
        		<input type="text" class="form-control" name="q_content" 
        			   value="${que.q_content}">
      <h4>在下面编辑选项文字</h4>
     <c:if test="${que.type!=1&&que.type!=2}">
     <c:forEach var="c" items="${clist}">    
		 <div class="form-group">         
         <input type="text" name="c_${c.c_id}" value="${c.c_content}" class="form-control" id="name" >
		 </div>
       <br>
       </c:forEach>
       </c:if>
	   <div class="col-sm-offset-5 col-sm-7">
       <button type="submit" class="btn btn-primary">保存修改</button>
	   </div>
     </form>
     </div>
  </body>
</html>

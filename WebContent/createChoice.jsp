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

    <title>创建选项</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sticky-footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>${que.q_content}</h1>
		<br />
		<h4>在下面编辑选项文字</h4>
      </div>
     <form role="form" action="EditInvest" method="post">  
     <input type="hidden" name="opt" value="createChoice">
     <input type="hidden" name="q_id" value="${que.q_id}">
     <c:forEach var="count" begin="1" end="${cnum}">    
		 <div class="form-group">         
         <input type="text" name="c_${count}" class="form-control" id="name" >
		 </div>
       <br>
       </c:forEach>
	   <div class="col-sm-offset-5 col-sm-7">
       <button type="submit" class="btn btn-primary">完成创建</button>
	   </div>
     </form>
     </div>
  </body>
</html>

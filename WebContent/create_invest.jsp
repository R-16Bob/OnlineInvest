<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- 给网页加图标 -->
    <link rel="icon" href="">

    <title>新建问卷</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
		<%
		//如果没有登录，就转到登录界面
		if(session.getAttribute("uname")==null){
			response.sendRedirect("login.jsp");
		}
		%>
    <div class="container">

      <form class="form-signin" action="Create_invest" method=post>
        <h2 class="form-signin-heading">在线设计问卷</h2>
        
        <input type="text"  class="form-control" name=title placeholder="问卷标题" required autofocus>
		
        <input type="text"  class="form-control" name=content placeholder="问卷描述" required>
        <br>
		<button class="btn btn-lg btn-primary btn-block" type="submit">立即创建</button>
      </form>
	<form class="form-signin"  method="post" action="UploadServlet" enctype="multipart/form-data">
	  <h2 class="form-signin-heading">或者导入Excel问卷</h2>
	  	<input class="file" type="file" name="uploadFile">
	  <br />
	  <a class="btn btn-success" href="Example.PNG" role="button" >excel示例</a> 
	  <br />
	  <br />
			<button class="btn btn-lg btn-primary btn-block" type="submit">导入问卷</button>
	</form>
    </div> <!-- /container -->

  </body>
</html>
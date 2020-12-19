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

    <title>问卷设计</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/starter-template/starter-template.css" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">在线问卷系统</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="Invest?opt=queryAll">我的问卷</a></li>
                <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎，${uname}</a>
    			
    			<ul class="dropdown-menu">
    								<li><a href="Logout">退出登录</a></li>
    								</li>
    			</ul>
              </ul>
            </div>
          </div>
        </nav>

    <div class="container">

      <div class="starter-template">
        <form role="form" method="post" action="EditInvest">
        	<div class="form-group">
        		<label for="name">新的题目</label>
        		<input type="text" class="form-control" id="title" 
        			   value="${inv.title}">
        			   <br>
					   <label for="name">新的描述</label>
					   <input type="text" class="form-control" id="inv_content" 
					   	   value="${inv.content}">
        	</div>
        	<button type="submit" class="btn btn-default">保存</button>
        </form>
      </div>
	  

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
<%@ page language="java" pageEncoding="utf-8"%>
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
	<style>
		.fixed-table-body{
		overflow:visible !important;
		}
	</style>
    <title>我的问卷</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">
  </head>

  <body>
		<%
		//如果没有登录，就转到登录界面
		if(session.getAttribute("uname")==null){
			response.sendRedirect("login.jsp");
		}
		%>
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

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a  href="create_invest.jsp" target="_blank">新建问卷 <span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">问卷列表</h1>


          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>id</th>
                  <th>title</th>
                  <th>创建时间</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach var="inv" items="${invlist}">
				<tr>
				  <td>${inv.id}</td>
				  <td>${inv.title}</td>
				  <td>${inv.created}</td>
				  <td>
					 <a class="btn btn-primary" href="Invest?opt=edit&invest_id=${inv.id}" role="button" >设计</a>
				  </td>
				  <td>
				  	<a class="btn btn-success" href="Invest?opt=share&invest_id=${inv.id}" role="button" target="_blank" >发布</a>
				  </td>
				  <td>
					 <a class="btn btn-danger" href="Invest?opt=delete&invest_id=${inv.id}" role="button" >删除</a>
				  </td>
				  <td>
				              <ul class="nav navbar-nav">
				<li class="dropdown">
				                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">分析&下载 <span class="caret"></span></a>
				                  <ul class="dropdown-menu">
				                    <li><a href="Statistic?opt=show&invest_id=${inv.id}" target="_blank">统计分析</a></li>
									<li><a href="Statistic?opt=download&invest_id=${inv.id}">下载分析报告</a></li>
				                    <li><a href="ShowInvest?opt=download&invest_id=${inv.id}">下载问卷</a></li>
				                    <li><a href="DownLoad?filename=data${inv.id}.xls&inv_id=${inv.id}">导出数据</a></li>				                    
				                  </ul>
				                </li>
								 </ul>
				</td>
				</tr>
				</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>

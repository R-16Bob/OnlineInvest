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
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/starter-template.css" rel="stylesheet">

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
        		<input type="hidden" name="opt" value="editInv">
        		<label for="name">新的标题</label>
        		<input type="text" class="form-control" name="title" 
        			   value="${inv.title}">
        			   <br>
					   <label for="name">新的描述</label>
					   <input type="text" class="form-control" name="inv_content" 
					   	   value="${inv.content}">
        	</div>
        	<button type="submit" class="btn btn-default">保存</button>
        </form>
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
         <div class="btn-group">
	<a class="btn btn-warning" href="EditInvest?opt=editQuestion&q_id=${q.q_id}" role="button" >编辑</a>
<a class="btn btn-danger" href="EditInvest?opt=deleteQuestion&q_id=${q.q_id}" role="button" >删除</a>
</div>
         <br>         <br>
		</c:forEach>


     </form>


	<form role="form" action="EditInvest" method="post">
	<div class="col-sm-offset-4 col-sm-8">
	<h3>在下面增加新问题：</h3>
	</div>
	<div class="form-group">
		<input type="hidden" name="opt" value="createQue">
		<label for="name">问题描述</label>
        		<input type="text" class="form-control" name="q_content"
        		value="请输入问题描述">
        		<br>
		<label for="name">问题类型</label>
		<select name="type" class="form-control">
			<option value=1>单选</option>
			<option value=2>多选</option>
			<option value=0>填空</option>
		</select>
			<br>
		<label for="name">选项数(填空题不用选择)</label>
		<select name="cnum" class="form-control">
			<option value=1>1</option>
			<option value=2>2</option>
			<option value=3>3</option>
			<option value=4>4</option>
			<option value=5>5</option>
		</select>
		<br>
			   <div class="col-sm-offset-5 col-sm-7">
       <button type="submit" class="btn btn-primary">创建问题</button>
	   </div>
	</div>
	</form>
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
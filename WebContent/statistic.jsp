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
    <script src="js/echarts.min.js"></script>
    <link rel="icon" href="../../favicon.ico">

    <title>${inv.title}分析报告</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sticky-footer.css" rel="stylesheet">

  </head>

  <body>

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>${inv.title}分析报告</h1>
      </div>
     <c:forEach var="sta" items="${statistics}">
	 <h4>${sta.q_content}</h4>
	 <c:if test="${sta.type==1||sta.type==2}">
	 <div class="table-responsive">
	   <table class="table table-striped">
         <thead>
           <tr>
             <th>选项</th>
             <th>小计</th>
             <th>比例</th>
           </tr>
         </thead>
         <tbody>
         <c:forEach var="count" begin="0" end="${sta.cnum-1}">
     				<tr>
     				  <td>${sta.contents[count]}</td>
     				  <td>${sta.amount[count]}</td>
     				  <td>${sta.percent[count]}%</td> 
     				</tr>	    				
     	</c:forEach>
     				<tr>
     				<td>总计</td>
     				<td>${sta.sum}</td>
     				<td></td>
     				</tr>	
         </tbody>
       </table>
     </div>
	 <br />
	 <div id="chart${sta.question_id}" style="width: 600px;height:400px;"></div>
	<script type="text/javascript">
	    // 基于准备好的dom，初始化echarts实例
	    var q_id=${sta.question_id};
	    var title='${sta.q_content}';
	    var myChart = echarts.init(document.getElementById('chart'.concat(q_id)));	
	    var arr= new Array;
	    var index=0;
		<c:forEach var="count" begin="0" end="${sta.cnum-1}">
		arr[index++]=${sta.amount[count]};
		</c:forEach>
	    // 指定图表的配置项和数据
	    var option = {
	        title: {
	            text: title
	        },
	        tooltip: {},
			toolbox: {
			                feature: {			   			                 
			                    saveAsImage: {}
			                }
			            },
	        xAxis: {
	            data: [
	            	<c:forEach var="count" begin="0" end="${sta.cnum-1}">
	            	"${sta.contents[count]}",
	            	</c:forEach>
	            ]
	        },
	        yAxis: {},
	        series: [{
	            name: '人数',
	            type: 'bar',
	            data: arr
	        }]
	    };	 
	    // 使用刚指定的配置项和数据显示图表。
	    myChart.setOption(option);
	</script>
	 </c:if>
	 <c:if test="${sta.type!=1&&sta.type!=2}">
	 <div class="table-responsive">
	   <table class="table table-striped">
	     <thead>
	       <tr>
	         <th>答案文本</th>
	       </tr>
	     </thead>
	     <tbody>
	     <c:forEach var="count" begin="0" end="${sta.sum-1}">
	 				<tr>
	 				  <td>${sta.contents[count]}</td>
	 				</tr>	
	 	</c:forEach>	
	     </tbody>
	   </table>
	 </div>
	 <br>
	 </c:if>
	 
	 </c:forEach>
	 
  </body>
</html>

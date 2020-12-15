<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Upload</title>
	</head>
	<body>
	<h1>导入Excel问卷</h1>
	<form method="post" action="UploadServlet" enctype="multipart/form-data">
	请选择文件：<br>
	<input type="file" name="uploadFile">
	<br><br>
	<input type="submit" value="上传">
	</form>
	</body>
</html>
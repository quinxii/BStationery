<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interceptor</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<div class="me-auto ms-auto w-50 mt-3">
		<div class="mt-5 mb-5">
			<a class="text-decoration-none bg-dark text-light p-3 rounded-5" href="/home/index">Home</a>
			<a class="text-decoration-none bg-dark text-light p-3 rounded-5" href="/home/category">Category</a>
		</div>
		<hr>
		<jsp:include page="_global.jsp"></jsp:include>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<div class="me-auto ms-auto w-25 mt-5 bg-dark-subtle p-4 rounded-5">
		<h1 class="text-dark-emphasis text-center">Profile</h1>
		<form class="mt-3" action="/logout" method="post">
		  <div class="mb-3">
		    <input value="${user.username}" readonly placeholder="Username" type="text" class="form-control"/>
		  </div>
		  <div class="mb-3">
		    <input value="${user.password}" placeholder="Password" type="password" class="form-control"/>
		  </div>
		  <div class="mb-3">
		    <input value="${user.fullname}" placeholder="Fullname" type="text" class="form-control"/>
		  </div>
		  <div class="mb-3">
		    <input value="${user.email}" placeholder="Email" type="email" class="form-control"/>
		  </div>
		  <div class="mb-3">
		    <input value="${user.admin?'Admin':'user'}" readonly placeholder="Admin" type="text" class="form-control"/>
		  </div>
		  <div class="w-100 text-end">
		  	<button formaction="/admin/index" formmethod="get" type="submit" class="btn btn-info">Admin</button>
		  	<button type="submit" class="btn btn-danger">Logout</button>
		  </div>
		</form>
	</div>
</body>
</html>
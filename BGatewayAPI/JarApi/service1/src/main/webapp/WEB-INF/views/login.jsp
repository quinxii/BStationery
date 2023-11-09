<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<div class="me-auto ms-auto w-25 mt-5 bg-dark-subtle p-4 rounded-5">
		<h1 class="text-dark-emphasis text-center">Login</h1>
		<form:form class="mt-3" action="/login" modelAttribute="account" method="post">
		  <div class="mb-3">
		    <form:input path="username" placeholder="Username" type="text" class="form-control"/>
		    <form:errors path="username" class="form-text text-danger" />
		    <c:if test="${not empty error_loginUsername}">
	  		  <div class="form-text text-danger" role="alert">
		  		${error_loginUsername}
			  </div>
	  	    </c:if>
		  </div>
		  <div class="mb-3">
		    <form:input path="password" placeholder="Password" type="password" class="form-control"/>
		    <form:errors path="password" class="form-text text-danger" />
		    <c:if test="${not empty error_loginPass}">
	  		  <div class="form-text text-danger" role="alert">
		  		${error_loginPass}
			  </div>
	  	    </c:if>
		  </div>
		  <div class="w-100 text-end">
		  	<button type="submit" class="btn btn-secondary">Login</button>
		  </div>
		</form:form>
	</div>
</body>
</html>
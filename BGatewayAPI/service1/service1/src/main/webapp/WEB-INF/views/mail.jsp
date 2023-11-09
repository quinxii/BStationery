<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send mail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<h1 class="text-primary-emphasis text-center mb-5 mt-3">Form send mail</h1>
	<form:form class="me-auto ms-auto w-50" action="/mail/send" method="post" enctype="multipart/form-data" modelAttribute="mail">
	  <c:if test="${not empty success_sendEmail}">
	  	<div class="alert alert-success" role="alert">
		  ${success_sendEmail}
		</div>
	  </c:if>
	  <div class="mb-3">
	    <form:input path="from" type="text" placeholder="From" class="form-control"/>
	    <form:errors path="from" class="form-text text-danger" />
	  </div>
	  <div class="mb-3">
	    <form:input path="to" type="email" placeholder="To" class="form-control"/>
	    <form:errors path="to" class="form-text text-danger" />
	  </div>
	  <div class="mb-3">
	    <form:textarea path="cc" type="text" placeholder="CC" class="form-control"/>
	    <form:errors path="cc" class="form-text text-danger" />
	  </div>
	  <div class="mb-3">
	    <form:textarea path="bcc" type="text" placeholder="BCC" class="form-control"/>
	    <form:errors path="bcc" class="form-text text-danger" />
	  </div>
	  <div class="mb-3">
	    <form:input path="subject" type="text" placeholder="Subject" class="form-control"/>
	    <form:errors path="subject" class="form-text text-danger" />
	  </div>
	  <div class="mb-3">
	    <form:input path="body" type="text" placeholder="Body" class="form-control"/>
	    <form:errors path="body" class="form-text text-danger" />
	  </div>
	  <div class="input-group mb-3">
		<input name="files" multiple="multiple" type="file" class="form-control" id="inputGroupFile02"/>
		<label class="input-group-text" for="inputGroupFile02">Tệp đính kèm</label>
		<form:errors path="attachments" class="form-text text-danger" />
	  </div>
	  <button type="submit" class="float-end btn btn-primary">Send</button>
	</form:form>
</body>
</html>
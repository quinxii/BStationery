<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>SEND YOUR EMAIL</h1>
	<form:form action="/mail/send" method="post" modelAttribute="mail">
		<c:if test="${not empty success_sendEmail }">
		${success_sendEmail}
		</c:if>
		<form:input path="from" type="text" placeholder="From"/>
		<form:errors path="from" />
		
		<form:input path="to" type="email" placeholder="TO"/>
		<form:errors path="to" />
		
		<form:input path="cc" type="text" placeholder="CC"/>
		<form:errors path="cc" />
		
		<form:input path="bcc" type="text" placeholder="BCC"/>
		<form:errors path="bcc" />
		
		<form:input path="subject" type="text" placeholder="Subject"/>
		<form:errors path="subject" />
		
		<form:input path="body" type="text" placeholder="Body"/>
		<form:errors path="body" />
		
		<input name="files" multiple="multiple" type="file" id="inputGroupFile02"/>
		<label>Tệp Đính Kèm</label>
		<form:errors path="attachments"/>
		<button type="submit">SEND EMAIL</button>
	</form:form>
</body>
</html>
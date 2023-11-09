<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<b>${uri}</b>
<ul class="list-group mt-3">
  <c:forEach var="item" items="${categories}">
	<li class="list-group-item">${item.name}</li>
  </c:forEach>
</ul>
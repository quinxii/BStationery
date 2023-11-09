<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%
 	DecimalFormat dcf = new DecimalFormat("#,##0.000");
	request.setAttribute("dcf",dcf);
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    <%@include file="/WEB-INF/css/style.css"%>
    
</style>
<title>User Information</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main-home">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
		
		<!-- Path -->
	    <div class="container">
	        <p class="path mt-4">
	            <a href="home">Home</a> / Orders
	        </p>
	    </div>
		<!-- Body -->
	    <div class="container">
	        <div class="row product-list bg-white my-4">
	            <div class="d-flex justify-content-end align-items-center px-5 pb-5 pt-4">
	                <form action="/" class="w-100">
	                    <div class="title">
	                        <h3 class="mb-4 mt-2">Your orders</h3>
	                    </div>
	                    <c:if test="${not empty orders}">
              				<c:forEach items="${orders}" var="order">
			                    <div class="card px-4 mb-3">
			                        <div class="w-100"> 
			                            <div class="d-flex justify-content-between align-items-center">
			                                <h4 class="mt-3 text-info">Order Id: ${order.orderId}</h4>
			                                <p  class="mt-3 text-secondary h6">Time: ${order.date}</p>
			                            </div>
			                            <div class="d-flex my-4 justify-content-between align-items-start">
			                                <div class="product-info d-flex justify-content-between align-items-center">
			                                    <div class="u-shopping-order__item-img-wrapper me-5">
			                                        <img class="img-fluid" src="${order.product.imageData}" alt="Image Description">
			                                    </div>
			                                    <div class="u-shopping-cart__item-info-wrapper me-5">
			                                        <span class="mb-1 me-5 h5">${order.product.name}</span>
			                                        <span class="d-block text-secondary fs-6 mt-2">Category: ${order.product.productCategory}</span>
			                                        <span class="d-block fs-6 me-4 mt-2">x${order.quantity}</span>
			                                    </div>
			                                </div>
			                                <div class="d-flex">
			                                    <a href="#" class="btn btn-outline-info p-2 me-3">See more</a>
			                                    <a href="cancel-order?id=${order.orderId}" class="btn btn-outline-danger px-3 py-2">Cancel</a>
			
			                                </div>
			                            </div>
			                            <div class="d-flex justify-content-end align-items-center w-100 mb-4">
			                                <span class="mb-0 me-4 h4 text-info">Total: </span>
			                                <span class="mb-0 h4 text-info">${order.product.price}₫</span>
			                            </div>
			                        </div>
			                    </div>
							</c:forEach>
						</c:if>
	                  </form>
	            </div>
	           
	        </div>
	    </div>
			
		<jsp:include page="/WEB-INF/view/footer/_footer.jsp"></jsp:include>
	</div>
	
	
	<!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"></script>
  
</body>
</html>

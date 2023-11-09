<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page import="org.btm.bstationeryafter.model.UserProfile" %> --%>
 
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
		
		<!-- Body -->
	    <div class="container">
	        <div class="row advertisement bg-white my-4">
	            <div class="col-lg-3 d-lg-block d-none navigation-wrapper pr-0 border-end" style="height: 450px;">
	                <div class="list-group list-group-flush my-4 mx-2">
	                    <div class="row me-5 d-flex justify-content-around align-items-center flex-nowrap py-3 mb-3 px-1">
	                        <div class="col-4">
	                            <img src="./images/user.png" alt="Avatar Logo" class="rounded-pill user-avatar">  
	                        </div>
	                        <div class="col text-nowrap">
	                            <jsp:include page="/WEB-INF/view/header/_userInfo_name.jsp"></jsp:include>
	                        </div>
	                    </div>
	                    <div class="menu-item list-group-item border-top">
	                        <jsp:include page="./menu/_userInfo_menu.jsp"></jsp:include>
	                    </div>
	                </div>
	            </div>
	            <div class="col-lg-9 col-12 pl-lg-0 d-block d-flex justify-content-start align-items-center px-5 py-5">
	                <form action="userAddress" method="get" class="w-100">
                    <div class="border-bottom mb-3">
                        <h4 class="mb-3">Your address</h4>
                        <button type="button" class="btn mb-3 btn btn-info text-white" data-bs-toggle="modal" data-bs-target="#myModal">
                            Add an address
                        </button>
                    </div>
                    <c:forEach var="address" items="${user.addresses}">
	                    <div class="row">
	                        <div class="col-10"> 
	                        	<!-- <p class="text-success">
	                        		<i class="far fa-check-circle me-1 fs-5"></i>
	                        		Default
	                       		</p> -->
	                       		
	                			<input type="hidden" name="addressId" value="${address.addressId}">
	                			<input type="hidden" name="userId" value="${address.userId}">
	                            <div class="mb-2">
	                                <label for="name" class="form-label fw-bolder">Name:</label>
	                                <span class="address-info" id="name">${address.nameOfAddress}</span>
	                            </div>
	                            <div class="mb-2">
	                                <label for="tel" class="form-label fw-bolder">Phone number:</label>
	                                <span class="address-info" id="tel">${address.phoneNumberOfAddress}</span>
	                            </div>
	                            <div class="mb-2">
	                                <label for="address" class="form-label fw-bolder">Address:</label>
	                                <span class="address-info" id="addressLine1">${address.addressLine1}, </span>
	                                <span class="address-info" id="addressLine2">${address.addressLine2}, </span>
	                                <span class="address-info" id="city">${address.city}</span>
	                            </div>
	                        </div>
	                        <div class="col-2"> 
	                            <div class="d-flex justify-content-end align-items-center mb-2 mt-4">
	                                <!-- <a href="#" class="address-info me-2 text-white px-4 btn btn-info btn-sm">
	                                    Edit
	                                </a>   -->
	                               <a href="userAddress?addressId=${address.addressId}" class="address-info me-2 text-white px-4 btn btn-info btn-sm" data-bs-toggle="modal" data-bs-target="#myUpdatedModal">
									    Edit									    
									</a>
	                                <a href="delete-address?addressId=${address.addressId}" class="address-info btn btn-danger px-3 btn-sm">
	                                    Delete    
	                                </a>
	                            </div>
	                        </div>
	                    </div>
	                    <hr>
					</c:forEach>
                  </form>
	            </div> 
	        </div>
	    </div>
	    <jsp:include page="/WEB-INF/view/modal/_address_update_modal.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/view/modal/_address_modal.jsp"></jsp:include>	
		<jsp:include page="/WEB-INF/view/footer/_footer.jsp"></jsp:include>
	</div>
	
	
	<!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"></script>
  
</body>
</html>
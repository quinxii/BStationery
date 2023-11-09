<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.btm.bstationeryafter.common.model.UserProfileMessage" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
 
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
	        <div class="row product-list bg-white my-4">
	            <div class="col-lg-3 d-lg-block d-none navigation-wrapper pr-0 border-end">
	                <div class="list-group list-group-flush my-4 mx-2">
	                    <div class="row me-5 d-flex justify-content-around align-items-center flex-nowrap py-3 mb-3">
	                        <div class="col-1 me-5">
	                            <img src="./images/user.png" alt="Avatar Logo" class="rounded-pill user-avatar">  
	                        </div>
	                        <div class="col-7 text-nowrap">
	                            <jsp:include page="/WEB-INF/view/header/_userInfo_name.jsp"></jsp:include>
	                        </div>
	                    </div>
	                    <div class="menu-item list-group-item border-top">
	                        <jsp:include page="./menu/_userInfo_menu.jsp"></jsp:include>
	                    </div>
	                </div>
	            </div>
	            <div class="col-lg-9 col-12 pl-lg-0 d-flex justify-content-between align-items-center px-5 py-5">
	                <form method="POST" action="${pageContext.request.contextPath}/userInfo" id="updateInfoForm">
					  <div class="row border-bottom d-flex justify-content-between align-items-center">
					  <div class="col-9">
					    <h4 class="mb-3">My Profile</h4>
					    <h6 class="mb-3 fw-normal">Manage and protect your account</h6>		  
					  </div>
					  <div class="col-3 d-flex justify-content-end h-25">
					    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#inactiveModal">Deactive Account</button>					    
				      </div>
					  </div>
					  <div class="row">
					    <div class="col-7">
					      <div class="mb-2 mt-4">
					        <label for="email" class="form-label">Email:</label>
					        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${user.email}" disabled>
					        <input type="hidden" name="originalUserEmail" value="${user.email}">
					      </div>
					      <div class="mb-2 mt-2">
					        <label for="name" class="form-label">Fullname:</label>
					        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${user.fullName}" required>
					      </div>
					      <div class="row mb-2 mt-2">
					        <div class="col">
					          <label for="phoneNumber" class="form-label">Phone Number:</label>
					          <input type="tel" class="form-control" id="phoneNumber" placeholder="Enter phone number" name="phone" value="${user.phone}" required>
					        </div>
					        <div class="col">
					          <label for="dob" class="form-label">Date of Birth:</label>
					          <input type="date" class="form-control" id="dob" placeholder="Enter date of birth" name="dob" 
					          value="<%= new SimpleDateFormat("yyyy-MM-dd").format(((UserProfileMessage) request.getAttribute("user")).getDob()) %>" required>
					        </div>
					        
					      </div> 
					      <div class="mb-2 mt-3 d-flex justify-content-between align-items-center w-100">
					      	<label for="gender" class="col form-label">Gender:</label>
					        <div class="col form-check">
					          <input type="radio" class="form-check-input me-3" id="maleGender" name="gender" value="true" checked disabled
					           <% if (String.valueOf(((UserProfileMessage) request.getAttribute("user")).isGender()).equals("true")) { %>checked<% } %>>
					          <label class="form-check-label">Male</label>
					        </div>
					        <div class="col form-check">
					          <input type="radio" class="form-check-input me-3" id="femaleGender" name="gender" value="false" disabled
					           <% if (String.valueOf(((UserProfileMessage) request.getAttribute("user")).isGender()).equals("false")) { %>checked<% } %>>
					          <label class="form-check-label">Female</label>
					        </div>
					      </div>
					      <button type="submit" class="btn btn-info w-100 mt-4 fs-6 text-white" onclick="alert('Update User Information Successfully!')">Save</button>
					    </div>
					    <div class="col-3 ms-3 d-lg-block d-none navigation-wrapper pr-0">
					      <div class="row ava-default d-flex justify-content-center align-items-center ms-3">
					        <img id="avatarImg" src="./images/user.png" alt="Avatar Logo" class="rounded-pill w-50 mt-5"> 
					      </div>
					      <div class="custom-file mt-5 ms-4 me-3">
					        <input type="file" class="custom-file-input btn btn-light" name="photo" accept="image/*" onchange="previewImage(event)">
					      </div>
					    </div>  
					  </div>
					</form>
	            </div> 
	        </div>
	    </div>
	  
		<jsp:include page="/WEB-INF/view/footer/_footer.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/view/modal/_deactivation_modal.jsp"></jsp:include>
		
	</div>
	<!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header -->

<nav class="navbar navbar-expand-sm navbar-dark bg-white">
	<button class="btn mobile-menu" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo">
	  <span style="font-size:28px;cursor:pointer" class="text-info">&#9776;</span>
	</button>
	
    <div class="container-fluid">
		
        <a class="navbar-brand text-black" href="home">
        	<img src="./images/logo.png" class="img-logo py-1 px-3" alt="BStationery_logo">
        </a>
        
		<div class="box">
	        <form class="search-place" action="search"  method="post">
	            <input class="form-control me-2 w-50" name="search" type="text" placeholder="Search">
	            <button type="submit" class="btn btn-search bg-info text-center">
	                <i class='fas fa-search fs-6 text text-white'></i>
	            </button>
	        </form>
<!-- 
        <button class="row me-5 d-flex justify-content-around align-items-center flex-nowrap border rounded p-2 bg-white" type="button">
            <div class="col-4">
                <img src="./images/england_flag.png" alt="Flag" class="rounded-pill language-image">
            </div>
            <div class="col">
                <span class="text-secondary">Language</span>
            </div>
        </button> -->
			<div class="box-1">
		        <a href="cart" class="row d-flex justify-content-around align-items-center flex-nowrap p-2 your-cart-btn me-4" type="button">  
		            <div class="col-4">
		                <img src="./images/cart.png" alt="Cart" class="rounded-pill cart-image">
		            </div>
		            <div class="col cart-title">
		            	<span class="text-secondary text-nowrap your-cart">
						    Your cart
						    <c:choose>
						        <c:when test="${sessionScope.cartSize == 0}">
						            <c:set var="displayStyle" value="display:none" />
						        </c:when>
						        <c:otherwise>
						            <c:set var="displayStyle" value="display:inline-block" />
						        </c:otherwise>
						    </c:choose>
						    <span class="badge bg-warning ms-2" style="${displayStyle}">${sessionScope.cartSize}</span>
						</span>
		            </div>
		        </a>
		
		        <div class="row d-flex justify-content-center align-items-center flex-nowrap">
		            <div class="col">
		            	<a href="userInfo">
		                	<img src="./images/user.png" alt="Avatar Logo" class="rounded-pill user-avatar">  
		            	</a>
		            </div>
		            <div class="col text-nowrap user-name">
		                <div class="row">
		                    <c:choose>
							    <c:when test="${not empty loginedUser.email}">
							        <a href="userInfo" class="sign_in-option text-info">
							            Hi ${loginedUser.fullName}!
							        </a>
							    </c:when>
							    <c:otherwise>
							        <a href="login" class="sign_in-option">
							            Log in
							        </a>
							    </c:otherwise>
							</c:choose>
		                </div>
		                <div class="row mt-1">
		                	<c:choose>
							    <c:when test="${not empty loginedUser.email}">
							        <a href="logout" class="log_out-option text-secondary">
		                    			Log out
		                   			</a>
							    </c:when>
							    <c:otherwise>
							        <a href="signup" class="log_out-option text-secondary">
							            Sign up
							        </a>
							    </c:otherwise>
							</c:choose>
		                </div>
		            </div>
		        </div>
			</div>
		</div>
 	</div>
</nav>
<jsp:include page="/WEB-INF/view/menu/_menu_mobile.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="org.btm.bstationeryafter.model.Cart" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>


 <%
 	@SuppressWarnings("unchecked")
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    <%@include file="/WEB-INF/css/style.css"%>
    
</style>
<title>Cart</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main-home">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
		
		<!-- Path -->
        <div class="container">
            <p class="path mt-4">
                <a href="home">Home</a> / Cart
            </p>
        </div>
		
		<!-- Body -->
	    <div class="container">
	        <div class="row product-list bg-white my-4">
	            <div class="col-lg-8 col-12 pl-lg-0 d-flex justify-content-end align-items-center px-5 pb-5 pt-4">
	                <form action="orderNow" method="post" class="w-100">
	                    <div class="title">
	                        <h3 class="mb-3">Your cart</h3>
	                    </div>
	                    <c:if test="${not empty cartList}">
            				<c:forEach var="cart" items="${cartList}">
                				<c:forEach var="cartItem" items="${cart.getCartItem()}">
	                				<div class="card px-3 mb-3">
				                        <div class="w-100"> 
				                            <div class="d-flex my-4 justify-content-between align-items-center">
				                                <div class="product-info d-flex justify-content-start align-items-center">
				                                    <div class="u-shopping-cart__item-img-wrapper me-5">
				                                         <img class="img-fluid cart-product-image" src="${cartItem.product.productImage}" alt="Image Description">
				                                    </div>
				                                    <div class="u-shopping-cart__item-info-wrapper">
				                                        <div class="d-flex justify-content-between align-items-center mb-1">
				                                            <span class="d-block mb-0 me-5 fs-6">${cartItem.product.productName}</span>
				                                        </div>
				                                    </div>
				                                </div>
				                                <div class="d-flex justify-content-between align-items-center me-2">
				                                    <span class="h5 me-4">${cartItem.product.productPrice }₫ </span>
				                                    <div class="quantity-box me-3">
				                                        <a href="quantity-inc-dec?action=dec&productId=${cartItem.product.productId }" class="quantity-button bg-transparent"><i class="fas fa-minus-square fs-3 text-info"></i></a>
				                                        <input type="text" id="quantity" class="quantity-input border" value="${cartItem.quantity }" readonly>
				                                        <a href="quantity-inc-dec?action=inc&productId=${cartItem.product.productId }" class="quantity-button bg-transparent"><i class="fas fa-plus-square fs-3 text-info"></i></a>
				                                    </div>
				                                    <a href="remove-from-cart?productId=${cartItem.product.productId}" class="btn btn-sm btn-danger">Remove</a>
				                                </div>
				                            </div>
				                        </div>
			                    	</div>
                				</c:forEach>
               				</c:forEach>
           				</c:if>
	                    
                  	</form>
          		</div>
	            <div class="col-lg-4 d-lg-block d-none navigation-wrapper py-4">
	                <div class="card-payment px-3 mb-3 mt-5 me-4">
	                    <div class="w-100"> 
	                        <div class="d-flex my-4 justify-content-between align-items-center">
	                            <div class="product-info d-flex justify-content-start align-items-center">
	                                <div class="u-shopping-cart__item-img-wrapper me-3">
	                                    <span class="d-block mb-0 me-5 fs-5">Total Funds:</span>
	                                </div>
	                            </div>
	                            <div class="d-flex justify-content-between align-items-center me-1">
	                                <span class="h5">${(total>0)?total:0 }₫ </span>
	                            </div>
	                        </div>
	                        <a href="payment" class="btn btn-info w-100 mb-4 text-white fw-bolder">Proceed to order</a>
	                    </div>
	                </div>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.btm.bstationeryafter.model.Cart" %>
 <%
 	@SuppressWarnings("unchecked")
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
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
<title>Payment</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main-home">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
		
		<!-- Path -->
    <div class="container">
        <p class="path mt-4">
            <a href="home">Home</a> / 
            <a href="cart">Cart</a> / Payment
        </p>
    </div>

    <!-- Body -->
    <div class="container">
        <div class="row advertisement bg-white my-4">
            <div class="col-lg-7 col-12 pl-lg-0 d-flex justify-content-end align-items-center px-5 pb-5 pt-4">
                <form action="/" class="w-100">
                    <div class="title mt-3">
                        <h3 class="mb-3">Delivery Information</h3>
                    </div>
                    <div class="row">
                        <div class="delivery-info"> 
                            <div class="mb-2 mt-4">
                              <label for="userId" class="form-label">userId:</label>
                              <input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId" value="${loginedUser.userId}">
                            </div>
                            <div class="mb-2 mt-2">
                                <label for="name" class="form-label">Name:</label>
                                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${loginedUser.name}">
                              </div>
                            <div class="mb-2 mt-2">
                              <label for="email" class="form-label">Email:</label>
                              <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${loginedUser.email}">
                            </div>
                            <div class="row mb-2 mt-2">
                              <div class="col">
                                <label for="tel" class="form-label">Phone Number:</label>
                                <input type="tel" class="form-control" id="tel" placeholder="Enter phone number" name="tel" value="${loginedUser.phoneNumber}">
                              </div>
                            </div>
                            
                            <div class="mb-2 mt-2">
							    <label for="address" class="form-label">Address:</label>
							    <select class="form-select" id="address" name="addressId">
							        <c:forEach items="${loginedUser.addresses}" var="address">
							            <option value="${address.addressId}">
							                ${address.nameOfAddress} - ${address.phoneNumberOfAddress}, ${address.addressLine1}, ${address.addressLine2}, ${address.city}
							            </option>
							        </c:forEach>
							    </select>
							</div>

                            <div class="card px-3 mt-5">
                                <div class="row w-100"> 
                                    <div class="d-flex my-3 justify-content-between align-items-center">
                                        <div class="product-info d-flex justify-content-start align-items-center">
                                            <div class="u-shopping-cart__item-img-wrapper me-3">
                                                <span class="d-block mb-0 me-5 h4">Total Funds:</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row w-100 m-0"> 
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="product-info d-flex justify-content-start align-items-center">
                                            <div class="u-shopping-cart__item-img-wrapper me-3">
                                                <span class="d-block mb-0 me-5 fs-6">Provisional</span>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center me-1">
                                            <span class="fs-6">${(total>0)?dcf.format(total):0 }₫</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row w-100 m-0"> 
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="product-info d-flex justify-content-start align-items-center">
                                            <div class="u-shopping-cart__item-img-wrapper me-3">
                                                <span class="d-block mb-0 me-5 fs-6">Shipping Fee</span>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center me-1">
                                            <span class="fs-6">0₫ </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row w-100 m-0"> 
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="product-info d-flex justify-content-start align-items-center">
                                            <div class="u-shopping-cart__item-img-wrapper me-3">
                                                <span class="d-block mb-0 me-5 h6">TOTAL</span>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center me-1">
                                            <span class="h5 text-info">${(total>0)?dcf.format(total):0 }₫ </span>
                                        </div>
                                    </div>
                                </div>
                                <a href="checkout" class="btn btn-info w-100 mt-3 mb-4 text-white fw-bolder">Place an order</a>
                            </div>
                            <!-- <button type="submit" class="btn sign_in_btn w-100 mt-4 fs-6 fw-bolder">Complete your order</button> -->
                        </div>
                    </div>
                  </form>
            </div>
            <div class="col-lg-5 d-lg-block d-none navigation-wrapper py-4 pe-5 mt-3">
                <c:forEach var="cart" items="${cartList}">
            		<c:forEach var="cartProduct" items="${cart.cartProducts}">
	                    <div class="card px-3 mb-3">
	                        <div class="w-100"> 
	                            <div class="d-flex my-4 justify-content-between align-items-center">
	                                <div class="product-info d-flex justify-content-start align-items-center">
	                                    <div class="u-shopping-cart__item-img-wrapper me-5">
	                                        <img class="img-fluid cart-product-image" src="${cartProduct.product.imageData}" alt="Image Description">
	                                    </div>
	                                    <div class="u-shopping-cart__item-info-wrapper">
	                                        <div class="d-flex justify-content-between align-items-center mb-1">
	                                            <span class="d-block mb-0 me-5 fs-6">${cartProduct.product.name}</span>
	                                        </div>
	                                    
	                                    </div>
	                                    
	                                </div>
	                                <div class="d-flex justify-content-between align-items-center me-2">
	                                	<input type="hidden" name="id" value="${cartProduct.product.id}" />
	                                    <span class="h5 me-4">${cartProduct.product.price }₫ </span>
	                                    <span class="text-secondary"><span>x</span>${cart.quantity}</span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                 </c:forEach>
                
                <!-- <div class="mb-3">
                    <div class="w-100"> 
                        <div class="my-3">
                            <h5>Order Notes</h5>
                            <textarea id="note" cols="65" name="note" rows="3"></textarea>
                        </div>
                    </div>
                </div> -->
                <div class="mt-4">
                    <div class="w-100"> 
                        <h5>Delivery Methods</h5>
                        <div class="my-3 border">
                            <div class="form-check d-flex justify-content-start align-items-center mb-3 mt-3 ms-3">
                                <input type="radio" class="form-check-input me-3" id="pickup" name="delivery-method" value="pickup" checked>
                                <i class="fas fa-store text-info fs-4 me-3"></i>
                                <label class="form-check-label" for="radio1">Pick up at store</label>
                            </div>
                            <hr class="opacity-10 text-secondary">
                            <div class="form-check d-flex justify-content-start align-items-center mb-3 ms-3">
                                <input type="radio" class="form-check-input me-3" id="delivery" name="delivery-method" value="delivery">
                                <i class="fas fa-shipping-fast text-info fs-4 me-3"></i>
                                <label class="form-check-label" for="radio2">Delivery</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mt-4">
                    <div class="w-100"> 
                        <h5>Payment Methods</h5>
                        <div class="my-3 border">
                            <div class="form-check d-flex justify-content-start align-items-center mb-3 mt-3 ms-3">
                                <input type="radio" class="form-check-input me-3" id="cash" name="payment-method" value="cash" checked>
                                <img src="https://s3-ap-southeast-1.amazonaws.com/pharmacity-ecm-asm-dev/payment-method/cash.webp" alt="cash image" class="rounded-1 payment-image me-3">
                                <label class="form-check-label" for="cash">Cash</label>
                            </div>
                            <hr class="opacity-10 text-secondary">
                            <div class="form-check d-flex justify-content-start align-items-center mb-3 ms-3">
                                <input type="radio" class="form-check-input me-3" id="momo" name="payment-method" value="momo">
                                <img src="https://hstatic.net/0/0/global/design/seller/image/payment/momo.svg?v=4" alt="momo image" class="rounded-1 payment-image me-3">
                                <label class="form-check-label" for="momo">Momo</label>
                            </div>
                        </div>
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
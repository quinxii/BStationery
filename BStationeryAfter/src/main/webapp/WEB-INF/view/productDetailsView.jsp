<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    <%@include file="/WEB-INF/css/style.css"%>
    
</style>
<title>Product Details Page</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="overflow-x: none;">
	<div id="main-details">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
		
		<!-- Body -->
        <jsp:include page="/WEB-INF/view/header/_subheader.jsp"></jsp:include>

        <!-- Path -->
        <%-- <div class="container">
            <p class="path mt-4">
                <a href="home">Home</a> / 
                <a href="productList">${productList[0].category.name}</a>
            </p>
        </div> --%>

        <!-- Details Item -->
        <form enctype="multipart/form-data" id="add-to-cart-form" action="payment" method="post" class="form_background form-inline margin-bottom-0">
            <input type="hidden" name="upc" value="${product.upc}" />
            <div class="container py-2 mb-3 card border-0 section-details pb-3">
                <div class="row">
                    <div class="product-detail-left product-images col-xs-12 col-sm-12 col-md-8 mx-auto col-lg-4">
                        <div class="pb-3 pt-0 col_large_default large-image">
                            <a class="link" href="#">
                                <img class="mt-2 w-100" src="${product.image}" alt="PRODUCT IMAGE">
                            </a>
                        </div>
                        <div class="col_large_default w-100 d-flex justify-content-between align-items-center">
                            <img class="product-image p-1" src="${product.image}" alt="FINE ART TOOLS">
                            <img class="product-image p-1" src="https://product.hstatic.net/1000230347/product/untitled-1_89dde406ca994b7dbec0bb100ba6df08.jpg" alt="PRODUCT IMAGE">
                            <img class="product-image p-1" src="https://product.hstatic.net/1000230347/product/biz-01_3c050c6c71a345a496ae6f1779f5075a.jpg" alt="PRODUCT IMAGE">
                            <img class="product-image p-1" src="https://product.hstatic.net/1000230347/product/biz-01_copy_81e46cbd408f4d4b9a738de6d2bc30a5_733f0efd1ef64959ab0cf96c60fe6ef7.jpg" alt="PRODUCT IMAGE">
                        </div>  
                    </div>  
                    <div class="col-xs-12 col-sm-12 col-lg-8 details-pro mt-3">
                        <h3 class="title-product fw-normal">${product.name} ${product.brand.name}</h3>
                        <div class="row me-1">
                            <div class="col-12 col-md-7 me-5">
                                <div class="group-status">
                                    <span class="first_status">
                                        Brand: 
                                            <span class="status_name available hasvariant">
                                                <span class="status_name available text-main">${product.brand.name}</span>
                                            </span>
                                    </span>
                                    <span class="line">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                                    <span class="first_status status_2">
                                        Status: 
                                            <span class="status_name available hasvariant">
                                                <span class="status_name available text-main"></span>
                                            </span>
                                    </span>
                                    <p class="product_sku first_status" style="margin-top: 5px;">
                                        Product code:
                                        <span class="status_name text-main"></span>
                                    </p>
                                </div>
                                <div class="price-box w-100">
                                    <span class="price fs-1 text-warning">${product.price}</span><span class="fs-1 text-warning">₫</span>
                                </div>
                                <div class="quantity-box mt-5">
                                    <span class="quantity-label">Quantity:</span>
                                    <a href="quantity-inc-dec?action=dec&upc=${product.upc}" class="quantity-button bg-transparent"><i class="fas fa-minus-square fs-3 text-info"></i></a>
                                    <input type="text" id="quantity" class="quantity-input border" value="1" readonly>
                                    <a href="quantity-inc-dec?action=inc&upc=${product.upc}" class="quantity-button bg-transparent"><i class="fas fa-plus-square fs-3 text-info"></i></a>
                                </div>
                                <div class="product-action mt-5 ms-2">
                                    <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
                                        <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-outline-info p-2 fs-6 me-3">ADD TO CART</a>
										<a href="add-to-cart?action=buy&upc=${product.upc}" class="col btn btn-sm btn-info text-white p-2 fs-6">BUY NOW</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-4 product-right">
                                <div class="product-policises-wrapper border border-info rounded p-3">
                                    <h5 class="m-0 mb-3">
                                        BStationery:
                                    </h5>
                                    <ul class="product-policises list-unstyled flex-column d-flex align-items-start m-0">
                                        <li class="media py-1 mb-2">
                                            <div class="media-body">
                                                <i class="fas fa-shipping-fast me-3 fs-4 text-main"></i>
                                                <span>National Delivery</span>
                                            </div>
                                        </li>
                                        <li class="media py-1 mb-2">
                                            <div class="media-body">
                                                <i class="fas fa-star me-3 fs-4 text-main"></i>
                                                <span>Genuine Products</span>
                                            </div>
                                        </li>
                                        <li class="media py-1 mb-2">
                                            <div class="media-body">
                                                <i class="fas fa-headset me-3 fs-4 text-main"></i>
                                                <span>Customer Support</span>
                                            </div>
                                        </li>
                                        <li class="media py-1 mb-2">
                                            <div class="media-body">
                                                <i class="fas fa-exchange-alt me-3 fs-4 text-main"></i>
                                                <span>Easy Returns</span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>              

                </div>
            </div>
        </form>

        <!-- Product Description -->
        <div class="container py-2 mb-3 card border-0"> 
            <div class="product-description p-3">
                <h3 class="text-main">Product Description</h3>
                <h6 class="mt-4 mb-3">Specifications:</h6>
                <table class="table table-bordered p-3">
                    <tbody>
                      <tr>
                        <th>Category name</th>
                        <td>${product.category.name}</td>
                      </tr>
                      <tr>
                        <th>Brand</th>
                        <td>${product.brand.name}</td>
                      </tr>
                    </tbody>
                </table>
                <p class="product-detail-description mt-4" style="text-align: justify;">${product.description}</p>
                <div class="row d-flex justify-content-between w-100">
                    <div class="pb-3 pt-0 w-50">
                        <a class="link" href="#">
                            <img class="mt-2 w-50" src="${product.image}" alt="FINE ART TOOLS">
                        </a>
                    </div>
                    <div class="pb-3 pt-0 w-50">
                        <a class="link" href="#">
                            <img class="mt-2 w-50" src="${product.image}" alt="FINE ART TOOLS">
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Similar Item -->
        <div class="container py-2 mb-3 card border-0"> 
            <div class="product-description p-3">
                <h3 class="similar-title"><a href="">Similar Products</a></h3>
                <div class="row product-items-container mt-2 p-2 d-flex justify-content-start align-items-center">
                	<c:forEach var="item" items="${similarProducts}" varStatus="loop">
                		<c:if test="${loop.index < 8}">
				            <div class="col-7 col-md-15 bg-white item me-1 ms-1 mt-2 card" style="width: 220px;">
				                <div class="item_product_main">
				                    <form action="#" method="post" class="variants product-action">
				                        <div class="product-thumbnail">
				                            <a class="image_thumb" href="productDetails?upc=${item.upc}" title="${item.name}">
				                                <img src="${item.image}" alt="${item.name}" class="w-100"  style="max-height: 194px;">
				                            </a>
				                        </div>
				                        <div class="product-info">
				                            <h3 class="product-name text-center mt-2">
				                                <a href="productDetails?upc=${product.upc}" title="${item.name}" class="product-name-link">${item.brand.name} ${item.name}</a>
				                            </h3>
				                            <div class="price-box text-center mt-5">
				                                <span class="price fs-5 text text-info fw-bolder">${item.price}</span>
				                                <span class="fs-6 text-info fw-bolder">₫</span>
				                            </div>
				                            <div class="product-action mt-2">
				                                <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
				                                    <a href="add-to-cart?action=buy&upc=${product.upc}" class="col btn btn-sm btn-info text-white ms-2 button-option me-1">BUY NOW</a>
				                                    <a href="productDetails?upc=${item.upc}" class="col btn btn-sm btn-outline-info me-2 button-option">VIEW</a>
				                                </div>
				                            </div>
				                        </div>
				                    </form>
				                </div>
				            </div>
				        </c:if>
		        </c:forEach>
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
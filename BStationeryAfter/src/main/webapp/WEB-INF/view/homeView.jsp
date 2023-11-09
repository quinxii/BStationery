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
<title>Home Page</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="overflow-x: hidden;">
	<div id="main-home">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
	    
        <!-- Body -->
        <jsp:include page="/WEB-INF/view/header/_main_subheader.jsp"></jsp:include>
        
        <!-- Advertisement -->
        <div class="container">
            <div class="row advertisement bg-white my-4">
                <div class="col-lg-3 d-lg-block d-none navigation-wrapper pr-0">
                    <ul class="navigation list-group list-group-flush">
                        <li class="menu-item list-group-item mt-1">
                            <a class="m-0 p-0 menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('Pen')">
                                <span>
                                    <i class='fas fa-pen-alt fa-9x fs-6 text me-3 text-info'></i>
                                    Pen
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('Book')">
                                <span>
                                    <i class='fas fa-book fs-6 text me-3 text-primary'></i>
                                    Book
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('Stationery')">
                                <span>
                                    <i class='fas fa-sticky-note fs-6 text me-3 text-success'></i>
                                    Stationery
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('School Supplies')">
                                <span>
                                    <i class='fas fa-eraser fs-6 text me-3 text-warning'></i>
                                    School Supplies
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('Fine Arts')">
                                <span>
                                    <i class='fas fa-palette fa-9x fs-6 text me-3 text-danger'></i>
                                    Fine Arts
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('Toy')">
                                <span>
                                    <i class='fas fa-car fa-10x fs-6 text me-3 text-info'></i>
                                    Toy
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('STEAM&DIY')">
                                <span>
                                    <i class='fas fa-cubes fs-6 text me-3 text-success'></i>
                                    STEAM & DIY
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                        <li class="menu-item list-group-item mt-1">
                            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList"
                             onclick="filterSelection('Gifts-Lifestyle')">
                                <span>
                                    <i class='fas fa-gift fs-6 text me-3 text-warning'></i>
                                    Gifts - Lifestyle
                                </span>
                                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-9 col-12 pl-lg-0 d-flex justify-content-end align-items-center p-0">
				    <!-- Carousel -->
					<div id="demo" class="carousel slide" data-bs-ride="carousel">
					
					  <!-- Indicators/dots -->
					  <div class="carousel-indicators">
					    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
					    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
					    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
					  </div>
					  
					  <!-- The slideshow/carousel -->
					  <div class="carousel-inner">
					    <div class="carousel-item active">
					      <img src="https://file.hstatic.net/1000230347/file/14_banner_1920x600_cta_52449c4ccee24a5c8bc44125ddb5969e.png" alt="Advertisement" class="d-block advertisement-image w-100">
					    </div>
					    <div class="carousel-item">
					      <img src="https://file.hstatic.net/1000230347/file/rd_tl_1920x600_40920aa732054ea684d5d7a38fa1b1da.jpg" alt="Advertisement" class="d-block advertisement-image w-100">
					    </div>
					    <div class="carousel-item">
					      <img src="https://file.hstatic.net/1000230347/file/4_banner_1920x600_7f284924e3944a8f8e27f333d23ec78c.png" alt="Advertisement" class="d-block advertisement-image w-100">
					    </div>
					  </div>
					  
					  <!-- Left and right controls/icons -->
					  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </button>
					  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </button>
					</div>
				</div>
            </div>
        </div>

        <!-- Art -->
        <div class="container py-2 mb-3 border-0 section-art">
            <a class="link" href="#">
                <img class="w-100 mt-2" src="https://file.hstatic.net/1000230347/file/1920_x_600_dcb00f9c8434456e8a0644cfa2f36234.jpg" alt="FINE ART TOOLS">
            </a>
            
            <div class="row d-flex justify-content-center align-items-center">
            
            </div>
            <div class="row product-items mt-3 px-3">
		        <c:forEach var="product" items="${productList}">
				    <div class="col-6 col-md-15 mx-2 mt-3 card" style="width: 240px;">
				        <div class="item_product_main">
				            <form action="orderNow" method="post" class="variants product-action">   
				                <div class="product-thumbnail">
				                    <a class="image_thumb" href="productDetails?upc=${product.upc}" title="${product.name}">
				                        <img src="${product.image}" alt="${product.name}" class="w-100 zoom" style="max-height: 204px;">
				                    </a>
				                </div>
				                <div class="product-info">
				                    <h6 class="product-name text-center mt-3">
				                        <a href="productDetails?upc=${product.upc}" title="${product.name}" class="product-name-link">${product.name}</a>
				                    </h6>
				                    <div class="price-box text-center mt-2">
				                        <span class="price fs-5 text text-info fw-bolder">${product.price}</span>
				                        <span class="fs-6 text-info fw-bolder">₫</span>
				                    </div>
				                    <div class="product-action mt-2">
				                        <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
				                            <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-info text-white ms-2 me-1">ADD</a>
				                            <a href="productDetails?upc=${product.upc}" class="col btn btn-sm btn-outline-info me-2 button-option">VIEW</a>
				                        </div>
				                    </div>
				                </div>
				            </form>
				        </div>
				    </div>
				</c:forEach>
   			</div>
        	
        	<div class="text-center py-3 col-12 d-flex justify-content-center align-items-center mt-3">
                <a style="background: #02bca4;color: #ffffff;" href="productList" title="Xem tất cả" class="btn px-3 view-all-btn">
                    View all
                    <i class="fas fa-chevron-right ms-2"></i>
                </a>
            </div>
        </div>

        <!-- School Supplies -->
        <div class="container py-2 mb-3 border-0 section-toy">
            <a class="link" href="#">
                <img class="w-100 mt-2" src="https://file.hstatic.net/1000230347/file/4_banner_1920x600_7f284924e3944a8f8e27f333d23ec78c.png" alt="SCHOOL SUPPLIES">
            </a>
            <div class="row product-items mt-3 px-3">
		        <c:forEach var="product" items="${productList}">
				    <div class="col-6 col-md-15 mx-2 mt-3 card" style="width: 240px; ">
				        <div class="item_product_main">
					        <form action="orderNow" method="post" class="variants product-action">   
				                <div class="product-thumbnail">
				                    <a class="image_thumb" href="productDetails?upc=${product.upc}" title="${product.name}">
				                        <img src="${product.image}" alt="${product.name}" class="w-100 zoom" style="max-height: 204px;">
				                    </a>
				                </div>
				                <div class="product-info">
				                    <h6 class="product-name text-center mt-3">
				                        <a href="productDetails?upc=${product.upc}" title="${product.name}" class="product-name-link">${product.name}</a>
				                    </h6>
				                    <div class="price-box text-center mt-2">
				                        <span class="price fs-5 text text-info fw-bolder">${product.price}</span>
				                        <span class="fs-6 text-info fw-bolder">₫</span>
				                    </div>
				                    <div class="product-action mt-2">
				                        <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
				                            <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-info text-white ms-2 me-1">ADD</a>
				                            <a href="productDetails?upc=${product.upc}" class="col btn btn-sm btn-outline-info me-2 button-option">VIEW</a>
				                        </div>
				                    </div>
				                </div>
				            </form>
				        </div>
				    </div>
				</c:forEach>
   			</div>
            <div class="text-center py-3 col-12 d-flex justify-content-center align-items-center mt-3">
                <a style="background: #fd7765;color: #ffffff;" href="productList" title="Xem tất cả" class="btn px-3 view-all-btn">
                    View all
                    <i class="fas fa-chevron-right ms-2"></i>
                </a>
            </div>
        </div>

        <!-- Stationery -->
        <div class="container py-2 mb-3 border-0 section-stationery">
            <a class="link" href="#">
                <img class="w-100 mt-2" src="https://file.hstatic.net/1000230347/file/12-13_banner_1920x600_cta_8307dac841a447f68df3a66d77093e68.png" alt="FINE ART TOOLS">
            </a>
            <div class="row product-items mt-3 px-3">
		        <c:forEach var="product" items="${productList}">
				    <div class="col-6 col-md-15 mx-2 mt-3 card" style="width: 240px; ">
				        <div class="item_product_main">
					         <form action="orderNow" method="post" class="variants product-action">   
				                <div class="product-thumbnail">
				                    <a class="image_thumb" href="productDetails?upc=${product.upc}" title="${product.name}">
				                        <img src="${product.image}" alt="${product.name}" class="w-100 zoom" style="max-height: 204px;">
				                    </a>
				                </div>
				                <div class="product-info">
				                    <h6 class="product-name text-center mt-3">
				                        <a href="productDetails?upc=${product.upc}" title="${product.name}" class="product-name-link">${product.name}</a>
				                    </h6>
				                    <div class="price-box text-center mt-2">
				                        <span class="price fs-5 text text-info fw-bolder">${product.price}</span>
				                        <span class="fs-6 text-info fw-bolder">₫</span>
				                    </div>
				                    <div class="product-action mt-2">
				                        <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
				                            <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-info text-white ms-2 me-1">ADD</a>
				                            <a href="productDetails?upc=${product.upc}" class="col btn btn-sm btn-outline-info me-2 button-option">VIEW</a>
				                        </div>
				                    </div>
				                </div>
				            </form>
				        </div>
				    </div>
				</c:forEach>
   			</div>

            <div class="text-center py-3 col-12 d-flex justify-content-center align-items-center mt-3">
                <a style="background: #62ccce;color: #ffffff;" href="productList" title="Xem tất cả" class="btn px-3 view-all-btn">
                    View all
                    <i class="fas fa-chevron-right ms-2"></i>
                </a>
            </div>
        </div>

        <!-- Toy -->
        <div class="container py-2 mb-3 border-0 section-schoolsupplies">
            <a class="link" href="#">
                <img class="w-100 mt-2" src="https://file.hstatic.net/1000230347/file/rd_tl_1920x600_40920aa732054ea684d5d7a38fa1b1da.jpg" alt="FINE ART TOOLS">
            </a>

            <div class="row product-items mt-3 px-3">
		        <c:forEach var="product" items="${productList}">
				    <div class="col-6 col-md-15 mx-2 mt-3 card" style="width: 240px;">
				        <div class="item_product_main">
				            <form action="orderNow" method="post" class="variants product-action">   
				                <div class="product-thumbnail">
				                    <a class="image_thumb" href="productDetails?upc=${product.upc}" title="${product.name}">
				                        <img src="${product.image}" alt="${product.name}" class="w-100 zoom" style="max-height: 204px;">
				                    </a>
				                </div>
				                <div class="product-info">
				                    <h6 class="product-name text-center mt-3">
				                        <a href="productDetails?upc=${product.upc}" title="${product.name}" class="product-name-link">${product.name}</a>
				                    </h6>
				                    <div class="price-box text-center mt-2">
				                        <span class="price fs-5 text text-info fw-bolder">${product.price}</span>
				                        <span class="fs-6 text-info fw-bolder">₫</span>
				                    </div>
				                    <div class="product-action mt-2">
				                        <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
				                            <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-info text-white ms-2 me-1">ADD</a>
				                            <a href="productDetails?upc=${product.upc}" class="col btn btn-sm btn-outline-info me-2 button-option">VIEW</a>
				                        </div>
				                    </div>
				                </div>
				            </form>
				        </div>
				    </div>
				</c:forEach>
   			</div>
            <div class="text-center py-3 col-12 d-flex justify-content-center align-items-center mt-3">
                <a style="background: #fd7765;color: #ffffff;" href="productList" title="Xem tất cả" class="btn px-3 view-all-btn">
                    View all
                    <i class="fas fa-chevron-right ms-2"></i>
                </a>
            </div>
        </div>
		
		<jsp:include page="/WEB-INF/view/footer/_footer.jsp"></jsp:include>
	</div>

  <!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"></script>
  <!-- Add Bootstrap CSS link (replace the path with your actual file) -->
	<script src="path/to/jquery.min.js"></script>
	<script src="path/to/popper.min.js"></script>
  
</body>
</html>
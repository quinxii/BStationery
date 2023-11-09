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
<title>Search</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main-home">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
		
		<!-- Path -->
        <div class="container">
            <p class="path mt-4">
                <a href="home">Home</a> / Search
            </p>
        </div>
		
		<!-- Body -->
	    <div class="container bg-white px-5 py-3">
	    	<h2 class="mt-2 text-info">Search Results</h2>
	        <div class="product-description container mb-3">
			    <div class="row product-items mb-2 d-flex flex-wrap">
			    	<c:choose>
					    <c:when test="${empty productList}">
					        <p class="fs-5 text-secondary mt-2 p-0">No product found.</p>
					        <div class="d-flex justify-content-center align-items-center">
					            <img src="https://img.freepik.com/premium-vector/woman-looking-new-business-career-opportunities-person-looking-into-future-choosing-direction-development-curious-characters-looking-through-binoculars-business-research-web-surfing_458444-1053.jpg?size=626&ext=jpg&ga=GA1.2.45355716.1687403748&semt=ais" class="w-50">
					        </div>
					    </c:when>
					    <c:otherwise>
							<c:forEach var="product" items="${productList}">
							    <c:if test="${not empty product}">
							    	<div class="col-5 col-md-15 me-2 ms-1 mt-2 card" style="width: 230px;">
								        <div class="item_product_main">
								            <form action="orderNow" method="post" class="variants product-action">
								                <%-- <div class="product-thumbnail filterDiv ${product.category.name}"> --%>
								                <div class="product-thumbnail">
								                    <a class="image_thumb" href="productDetails?upc=${product.upc}" title="${product.name}">
								                        <img src="${product.image}" alt="${product.name}" class="w-100 zoom" style="max-height: 204px;">
								                    </a>
								                </div>
								                <div class="product-info">
								                    <h6 class="product-name text-center mt-2 mb-2" style="max-height: 60px;">
								                        <%-- <a href="productDetails?upc=${product.upc}" title="${product.name}" class="product-name-link">${product.name} ${product.brand.name}</a> --%>
								                        <a href="productDetails?upc=${product.upc}" title="${product.name}" class="product-name-link">${product.name}</a>
								                    </h6>
								                    <div class="price-box text-center mt-4">
								                        <span class="price fs-5 text text-info fw-bolder">${product.price}</span>
								                        <span class="fs-6 text-info fw-bolder">₫</span>
								                    </div>
								                    <div class="product-action mt-2">
								                        <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
								                            <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-info text-white ms-2 me-1">ADD</a>
								                            <button type="button" class="col btn btn-sm btn-outline-info me-2 button-option" data-bs-toggle="modal" data-bs-target="#quickViewModal">
														    	VIEW
														    </button>
								                        </div>
								                    </div>
								                </div>
								            </form>
								        </div>
								    </div>
							    </c:if>
						   </c:forEach>	
					   </c:otherwise>
				   </c:choose>
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


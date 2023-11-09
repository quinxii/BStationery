<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
    <%@include file="/WEB-INF/css/style.css"%>
    <%@include file="/WEB-INF/css/quickViewStyle.css"%>
    
</style>
<title>Product List Page</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main-details">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>
		
		<!-- Body -->
       	<jsp:include page="/WEB-INF/view/header/_subheader.jsp"></jsp:include>

        <!-- Path -->
        <%-- <div class="container">
            <p class="path mt-4">
                <a href="/home">Home</a> / ${productList[0].category.name}
            </p>
        </div> --%>

        <!-- Product Type -->
        <div class="container">
            <div class="row product-list bg-white my-4 p-2">
             	 <div class="col-lg-2 col-12 d-lg-block d-none navigation-wrapper py-1 ps-2">
                    <div class="row px-2 py-3 border-bottom">
                        <h6 class="text-info fw-bolder">PRODUCT TYPE</h6>
                        <form action="/action_page.php">
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something">
                                <label class="form-check-label" for="check1">Ballpoint pen</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check2" name="option2" value="something">
                                <label class="form-check-label" for="check2">Pencil</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check1" name="option3" value="something">
                                <label class="form-check-label" for="check1">Highlighter</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check2" name="option4" value="something">
                                <label class="form-check-label" for="check2">Lettering pen</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check1" name="option5" value="something">
                                <label class="form-check-label" for="check1">Gel pen</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check2" name="option6" value="something">
                                <label class="form-check-label" for="check2">Eraser pen</label>
                            </div>
                        </form>
                    </div>
                    <div class="row px-2 py-3 border-bottom">
                        <h6 class="text-info fw-bolder">TRADEMARK</h6>
                        <form action="/action_page.php">
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something">
                                <label class="form-check-label" for="check1">Thien Long</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check2" name="option2" value="something">
                                <label class="form-check-label" for="check2">Diem 10</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check1" name="option3" value="something">
                                <label class="form-check-label" for="check1">Flexoffice</label>
                            </div>
                            <div class="form-check my-2"> 
                                <input type="checkbox" class="form-check-input" id="check2" name="option4" value="something">
                                <label class="form-check-label" for="check2">Colorkit</label>
                            </div>
                            <div class="form-check my-2">
                                <input type="checkbox" class="form-check-input" id="check1" name="option5" value="something">
                                <label class="form-check-label" for="check1">Others</label>
                            </div>
                        </form>
                    </div>
                    <div class="row px-2 py-3">
                        <h6 class="text-info fw-bolder">PRICE</h6>
                        <form action="/action_page.php">
	                        <div class="form-check my-2"> 
	                            <input type="checkbox" class="form-check-input" id="check2" name="option4" value="something">
	                            <label class="form-check-label" for="check2">Price under 100,000&#8363;</label>
	                        </div>
	                        <div class="form-check my-2">
	                            <input type="checkbox" class="form-check-input" id="check1" name="option5" value="something">
	                            <label class="form-check-label" for="check1">100.000<span>&#8363;</span> - 300.000<span>&#8363;</span></label>
	                        </div>
	                        <div class="form-check my-2"> 
	                            <input type="checkbox" class="form-check-input" id="check2" name="option4" value="something">
	                            <label class="form-check-label" for="check2">300.000<span>&#8363;</span> - 500.000<span>&#8363;</span></label>
	                        </div>
	                        <div class="form-check my-2">
	                            <input type="checkbox" class="form-check-input" id="check1" name="option5" value="something">
	                            <label class="form-check-label" for="check1">500.000<span>&#8363;</span> - 700.000<span>&#8363;</span></label>
	                        </div>
	                        <div class="form-check my-2"> 
	                            <input type="checkbox" class="form-check-input" id="check2" name="option4" value="something">
	                            <label class="form-check-label" for="check2">700.000<span>&#8363;</span> - 1.000.000<span>&#8363;</span></label>
	                        </div>
	                        <div class="form-check my-2">
	                            <input type="checkbox" class="form-check-input" id="check1" name="option5" value="something">
	                            <label class="form-check-label" for="check1">Price over 1,000,000<span>&#8363;</span></label>
	                        </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-10 col-12 pl-lg-0 product-list-view">
                    <div class="row py-3 px-4">
                        <h4 class="text-right">Product List</h4>
                            <div id="sort-by" class="mt-3">
                                <label class="left">
                                    <span>Sort by: </span>
                                </label>
                                <ul class="ul_col ml-2 mb-0 filter-url d-inline">
                                    <li class="active me-2 p-2 border-sort">
                                        <a class="link text-sort" href="?sort=az">Names A &rarr; Z</a>
                                    </li>
                                    <li class="active me-2 p-2 border-sort">
                                        <a class="link text-sort" href="?sort=za">Names Z &rarr; A</a>
                                    </li>
                                    <li class="active me-2 p-2 border-sort">
                                        <a class="link text-sort" href="?sort=price_inc">Incremental price</a>
                                    </li>
                                    <li class="active me-2 p-2 border-sort">
                                        <a class="link text-sort" href="?sort=price_dec">Descending price</a>
                                    </li>
                                    <li class="active me-2 p-2 border-sort">
                                        <a class="link text-sort" href="?sort=new_arrival">New arrivals</a>
                                    </li>
                                </ul>
                            </div>
                            
							<jsp:include page="/WEB-INF/view/menu/_menu_sortby_mobile.jsp"></jsp:include>
							
                            <div class="product-description">
							    <div class="row product-items mt-3 p-2">
							        <c:forEach var="product" items="${productList}">
									    <div class="col-5 col-md-15 me-2 ms-1 mt-2 card" style="width: 240px;">
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
									</c:forEach>
				    			</div>
							</div>
                	</div>      
            	</div>
        	</div>
		</div>
		
		<jsp:include page="/WEB-INF/view/footer/_footer.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/view/modal/_quick_view_modal.jsp"></jsp:include>
	</div>

  <!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"></script>
  
  <script>
	  let slideIndex = 1;
	  showSlides(slideIndex);
	  
	  function plusSlides(n) {
	    showSlides(slideIndex += n);
	  }
	  
	  function currentSlide(n) {
	    showSlides(slideIndex = n);
	  }
	  
	  function showSlides(n) {
	    let i;
	    let slides = document.getElementsByClassName("mySlides");
	    let dots = document.getElementsByClassName("demo");
	    let captionText = document.getElementById("caption");
	    if (n > slides.length) {slideIndex = 1}
	    if (n < 1) {slideIndex = slides.length}
	    for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";
	    }
	    for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	    }
	    slides[slideIndex-1].style.display = "block";
	    dots[slideIndex-1].className += " active";
	    captionText.innerHTML = dots[slideIndex-1].alt;
	  }
  </script>
</body>
</html>


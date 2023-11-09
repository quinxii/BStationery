<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid bg-main">
   <ul class="nav mx-5">
     <button class="dropbtn ms-5 me-5">
	     <a href="productList" style="text-decoration: none;" class="text-white">
		  	<i class="fa fa-regular fa-bars text-white me-3"></i>
		    Product List     
	     </a>
  	 </button>
     <li class="col-4 nav-item utility">
         <a class="nav-link text-white d-flex justify-content-center align-items-center text-nowrap" href="user-orders">
             <img src="./images/shipping_icon.png" alt="shipping_icon" class="shipping-image me-3">
             <span>Check your order</span>
         </a>
     </li>

     <li class="col-1 nav-item utility">
         <a class="nav-link text-white d-flex justify-content-center align-items-center text-nowrap" href="user-orders">
             <img src="https://theme.hstatic.net/1000230347/1000782290/14/policy_header_image_1.png?v=15611" alt="promotion_icon" class="shipping-image me-3">
             <span>Promotions Guide</span>
         </a>
     </li>

   </ul>
</div>
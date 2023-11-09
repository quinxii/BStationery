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
   <title>Login</title>
   <link rel="icon" href="./images/logo.png" type="image/icon type">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="overflow: hidden;">
  <div id="main-body">
  	  <jsp:include page="/WEB-INF/view/header/_login_header.jsp"></jsp:include>
	  
	  <div class="form-background p-4 mx-5">
	     <form method="POST" action="${pageContext.request.contextPath}/login">
		       <h4 class="mb-4">Sign In</h4>
		       <div class="mb-2">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
                <p id="result"></p>
               </div>
		       <div class="mb-3">
		         <label for="userPwd" class="form-label">Password:</label>
		         <input type="password" class="form-control" id="userPwd" placeholder="Enter password" name="userPwd" required>
		       </div>
		       <div class="form-check mb-3">
		         <label class="form-check-label">
		           <input class="form-check-input" type="checkbox" name="rememberMe" value="Y"> Remember me
		         </label>
		       </div>
		       
		       <button type="submit" class="sign_in_btn w-100 mb-3">Sign In</button>
		       
		       <div class="form-forget-password text-center mb-3">
		         <a href="#">Forgotten your password?</a>
		       </div>
			   <p class="text-danger">${errorString}</p>
		       <div class="form-line mb-3">
		         <div class="row">
		           <div class="col-5"><hr></div>
		           <div class="col-2 brand-name text-secondary text-center opacity-50 fs-7">OR</div>
		           <div class="col-5"><hr></div>
		         </div>
		       </div>
		       
		       <div class="d-flex text-center my-2 w-100 justify-content-between mb-4">
	       			<a href="https://accounts.google.com/o/oauth2/auth?scope=email
					&redirect_uri=http://localhost:8080/BStationeryAfter/login-google&response_type=code&client_id=816363409708-mtt8vhcvnaav1fj49o1obfe72l9ec0h8.apps.googleusercontent.com&approval_prompt=force" class="btn border border-outline-secondary  rounded-0 w-50 me-3">
    					<img src="https://static-00.iconduck.com/assets.00/google-icon-2048x2048-czn3g8x8.png" class="rounded-0 me-3" style="width: 20px;">Google
    				</a>  
    				<a href="https://www.facebook.com/dialog/oauth?client_id=359123991240252
    				&redirect_uri=https://localhost:8080/BStationeryAfter/login-facebook" class="btn border border-outline-secondary rounded-0 w-50">
    					<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Facebook_Logo_%282019%29.png/1200px-Facebook_Logo_%282019%29.png" class="rounded-0 me-3" style="width: 23px;">Facebook    				
    				</a>
				</div>
		
		       <div class="form-sign_up mb-2 d-flex justify-content-around align-items-center">
		         <label class="form-check-label mx-2 opacity-50">
		           Create your new account
		         </label>
		         <a href="signup" class="btn btn-outline-info sign_up_btn w-25 mx-2 bg-white">Sign Up</a>
		       </div>
		     </form>
	  </div>
      <jsp:include page="/WEB-INF/view/footer/_login_footer.jsp"></jsp:include>
  </div>
  
  <!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

  <script src="/WEB-INF/script/email-validation.js"></script>
</body>
</html>
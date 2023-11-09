<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <style>
    	<%@include file="/WEB-INF/css/style.css"%>
	</style>
   <title>Sign Up</title>
   <link rel="icon" href="./images/logo.png" type="image/icon type">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="overflow: hidden;">
  <div id="main-body">
  	  <jsp:include page="/WEB-INF/view/header/_login_header.jsp"></jsp:include>

	  <div class="form-background p-4 mx-5">
	     <form id="signupForm" method="POST" action="${pageContext.request.contextPath}/signup">
		       <h4 class="mb-4">Sign Up</h4>
		       
		       <div class="mb-2">
                <label for="email" class="form-label"><span class="text-danger h6">*</span>Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
                <p id="result"></p>
               </div>
		
		       <div class="mb-2">
		         <label for="name" class="form-label"><span class="text-danger h6">*</span>Fullname:</label>
		         <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required>
		       </div>

		       <div class="mb-2">
		         <label for="pwd" class="form-label"><span class="text-danger h6">*</span>Password:</label>
		         <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="userPwd" required>
		       </div>
		       <div class="mb-2">
		         <label for="pwd" class="form-label"><span class="text-danger h6">*</span>Confirm Password:</label>
		         <input type="password" class="form-control" id="confirmPwd" placeholder="Confirm password" name="confirmPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
		         title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
	       		 <span id="passwordError" class="text-danger"></span>	
		       </div>
		
		       <div class="row mb-2">
                <div class="col">
                  <label for="phoneNumber" class="form-label"><span class="text-danger h6">*</span>Phone Number:</label>
                  <input type="tel" class="form-control" id="tel" placeholder="Enter phone number" name="phoneNumber" required>
                </div>
                <div class="col">
                  <label for="dob" class="form-label"><span class="text-danger h6">*</span>Date of Birth:</label>
                  <input type="date" class="form-control" id="dob" placeholder="Enter date of birth" name="dob">
                </div>
              </div>
              
              <div class="d-flex justify-content-between align-items-center w-100">  
                <label for="text" class="col form-label"><span class="text-danger h6">*</span>Gender:</label>
                  <div class="col form-check">
                    <input type="radio" class="form-check-input" id="radio1" name="gender" value="1">Male
                    <label class="form-check-label" for="radio1"></label>
                  </div>
                  <div class="col form-check">
                    <input type="radio" class="form-check-input" id="radio2" name="gender" value="0">Female
                    <label class="form-check-label" for="radio2"></label>
                  </div>
              </div>
		       <p class="text-danger" id="errorString">${errorString}</p>
		       <button type="submit" class="btn btn-info text-white w-100 my-1">Sign Up</button>
	  		</form>
	  </div>
	  
      <jsp:include page="/WEB-INF/view/footer/_login_footer.jsp"></jsp:include>
  </div>
  
  <!-- Bootstrap JavaScript -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" ></script>

  <!-- Font Awesome JavaScript -->
  <script src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script>
	document.addEventListener("DOMContentLoaded", function validation() {
	    const form = document.getElementById("signupForm");
	    const emailField = document.getElementById("email");
	    const passwordField = document.getElementById("pwd");
	    const confirmPasswordField = document.getElementById("confirmPwd");
	    const errorString = document.getElementById("errorString");
	
	    form.addEventListener("submit", function (event) {
	        let isValid = true;
	
	        // Email validation
	        if (!isValidEmail(emailField.value)) {
	            isValid = false;
	            document.getElementById("result").innerText = "Invalid email format.";
	            document.getElementById("result").style.color = "red";
	        } else {
	            document.getElementById("result").innerText = "";
	        }
	
	        // Password validation 
	        if (!isValidPassword(passwordField.value)) {
	            isValid = false;
	            document.getElementById("passwordError").innerText = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters";
	            document.getElementById("passwordError").style.color = "red";
	        } else {
	            document.getElementById("passwordError").innerText = "";
	        }
	        
	     	// Confirm Password validation 
	        if (!isValidPassword(confirmPasswordField.value)) {
	            isValid = false;
	            document.getElementById("passwordError").innerText = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters";
	            document.getElementById("passwordError").style.color = "red";
	        } else {
	            document.getElementById("passwordError").innerText = "";
	        }
	
	        // Password and Confirm password validation
	        if (passwordField.value !== confirmPasswordField.value) {
	            isValid = false;
	            document.getElementById("passwordError").innerText = "Passwords do not match.";
	            document.getElementById("passwordError").style.color = "red";
	        }
	
	        if (!isValid || (errorString && errorString.textContent.trim() !== "") {
	            event.preventDefault(); // Prevent form submission if validation fails
	        } else {
	        	alert('Sign Up Successfully!');
	        }
	    });
	
	    function isValidEmail(email) {
	        // You can use a regular expression for email validation
	        const emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,})+$/;
	        return emailRegex.test(email);
	    }
	
	    function isValidPassword(password) {
	        // You can customize the password validation criteria as needed
	        const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
	        return passwordRegex.test(password);
	    }
	});
   </script>

</body>
</html>
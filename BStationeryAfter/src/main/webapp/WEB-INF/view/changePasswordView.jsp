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
<title>Change Password</title>
<link rel="icon" href="./images/logo.png" type="image/icon type">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main-home">
		<jsp:include page="/WEB-INF/view/header/_header.jsp"></jsp:include>

	    <div class="container mt-5">
	        <div class="row product-list bg-white my-4">
	            <div class="col-lg-3 d-lg-block d-none navigation-wrapper pr-0 border-end">
	                <div class="list-group list-group-flush my-4 mx-2">
	                    <div class="row me-5 d-flex justify-content-around align-items-center flex-nowrap mb-3 px-1">
		                        <div class="col-4">
		                            <img src="./images/user.png" alt="Avatar Logo" class="rounded-pill user-avatar">  
		                        </div>
		                        <div class="col text-nowrap">
		                            <jsp:include page="/WEB-INF/view/header/_userInfo_name.jsp"></jsp:include>
		                        </div>
		                    </div>
		                    <div class="menu-item list-group-item border-top">
		                        <jsp:include page="./menu/_userInfo_menu.jsp"></jsp:include>
		                    </div>
	                </div>
	            </div>
	            <div class="col-lg-9 col-12 pl-lg-0 d-flex justify-content-center align-items-center px-5 py-3">
	                <div class="row advertisement bg-white">
	                    <div class="col-lg-7 pl-lg-0 d-flex justify-content-center align-items-center pt-2">
	                        <form action="changePassword" method="post" class="w-100" id="changePasswordForm" onsubmit="return validateForm();">
	                        	<input type="hidden" name="originalEmail" value="${user.email}">
	                        	<input type="hidden" class="form-control" id="userPwd" name="userPwd" value="${loginedUser.userPwd}">
	                        	
	                            <div class="title text-center text-info">
	                                <h3 class="mt-5">Change Password</h3>
	                            </div>
	                            <div class="row d-flex justify-content-center align-items-center px-5 pb-5 mt-5">
	                                <div class="delivery-info"> 
                                        <div id="step1">
									    	<p>Please input your current password:</p>
									        <input type="password" class="form-control" id="currentPassword" placeholder="Current Password" name="currentPassword">
									        <div style="overflow:auto;">
										    	<div style="float:right;">
									        		<button type="button" class="btn btn-info text-white px-4 mt-3" onclick="nextStep(1)">Next</button>
									        	</div>
								        	</div>
									    </div>
									    
									    <div id="step2" style="display:none;">
									        <p>Reset Password:</p>
									        <p><input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="New Password"></p>
									        <p><input type="password" class="form-control" id="confirmNewPassword" placeholder="Confirm New Password"></p>
									        <div style="overflow:auto;">	
										    	<div style="float:right;">
									        		<button type="submit" class="btn btn-info text-white px-4 mt-2" onclick="nextStep(2)">Submit</button>
									        	</div>
								        	</div>
									    </div>
									    
									  	<div id="page" style="text-align:center;margin-top:40px;">
									    	<span class="step active-step"></span>
									    	<span class="step inactive-step"></span>
									  	</div>
	                                </div>   
	                            </div>
	                        </form>
	                    </div>

	                    <div class="col-lg-5 d-lg-block navigation-wrapper d-flex justify-content-center align-items-center">
	                        <img src="./images/change_password.png" alt="changePassword_bg" class="w-100 py-5 mt-5"> 
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
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/blueimp-md5/2.18.0/js/md5.min.js"></script>
  
  <script>
        let currentStep = 1;

        function nextStep(step) {
            console.log('Step:', step);

            if (step === 1) {
                // Step 1: Verify the current password
            	const currentPassword = document.getElementById('currentPassword').value;
                const userPassword = document.getElementById('userPwd').value;

                // Simulate server-side verification (replace this with actual verification logic)
                // Hash the current password and store it in the checkPassword variable using MD5
                const hashedCurrentPassword = hashPassword(currentPassword);
                const isCurrentPasswordValid = checkCurrentPassword(hashedCurrentPassword, userPassword);

                if (isCurrentPasswordValid) {
                    currentStep = 2;
                    document.getElementById('step1').style.display = 'none';
                    document.getElementById('step2').style.display = 'block'; // Corrected the typo
                } else {
                    alert('Current password is invalid. Please try again.');
                }
            } else if (step === 2) {
                updateStepColors();
            }
        }

        function checkCurrentPassword(currentPassword, userPassword) {
            const validPassword = userPassword; // Replace with the actual valid password
            return currentPassword === validPassword;
        }
        
        // Simulated server-side function to check if the current password is valid
        function hashPassword(password) {
	        return md5(password);
	    }
        
        function updateStepColors() {
            // Get all step elements
            const steps = document.querySelectorAll('.step');

            // Loop through the steps and update their classes
            steps.forEach((step, index) => {
                if (index === currentStep - 1) {
                    step.classList.add('active-step'); // Apply the "active-step" class to the current step
                } else {
                    step.classList.remove('active-step'); // Remove the "active-step" class from inactive steps
                }
            });
        }
        function validateForm() {
            const currentPassword = document.getElementById('currentPassword').value;
            const newPassword = document.getElementById('newPassword').value;
            const confirmNewPassword = document.getElementById('confirmNewPassword').value;
            const passwordPattern = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;

            if (!newPassword || !confirmNewPassword) {
                alert('New password and confirmation cannot be empty. Please enter both passwords.');
                return false;
            }

            if (!passwordPattern.test(newPassword)) {
                alert('New password must contain at least one number and one uppercase and lowercase letter and be at least 8 characters long.');
                return false;
            }

            if (newPassword !== confirmNewPassword) {
                alert('New passwords do not match. Please try again.');
                return false;
            }

            // If all conditions are met, allow the form to submit
            alert('Password changed successfully!');
            return true;
        }


    </script>
</body>
</html>
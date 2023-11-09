<!-- Success Modal -->
<div class="modal fade" id="successModal">
	<div class="modal-dialog modal-dialog-centered">
	   <div class="modal-content">
			<form method="POST" action="${pageContext.request.contextPath}/user-info" id="userUpdateForm">
		    	<input type="hidden" name="email" value="${user.email}">
      				<input type="hidden" name="enabled" value="false">	
      				
   				<!-- Modal header -->		
			   	<div class="modal-header">
		          <h5 class="modal-title">Update your information</h5>
		          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		        </div>
		        
			    <!-- Modal body -->
			    <div class="modal-body d-flex justify-content-between align-items-center">
			       <p>Are you sure you want to <strong>update</strong> your information?</p>
			    </div>
			      
			    <!-- Modal footer -->
			    <div class="modal-footer">
			       <button type="button" class="btn btn-secondary opacity-50" data-bs-dismiss="modal">Cancel</button>
			       <button type="submit" class="btn btn-info">
			       	Confirm
				   </button>
			    </div>   
		  	</form>
	    </div>
	</div>
</div>
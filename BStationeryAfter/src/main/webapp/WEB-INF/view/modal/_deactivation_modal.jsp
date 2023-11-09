<!-- Deactive Modal -->
<div class="modal fade" id="inactiveModal">
	<div class="modal-dialog modal-dialog-centered">
	   <div class="modal-content">
			<form method="POST" action="${pageContext.request.contextPath}/user-deactivation" id="userDeactivateForm">
		    	<input type="hidden" name="email" value="${user.email}">
      				<input type="hidden" name="enabled" value="false">	
      				
   				<!-- Modal header -->		
			   	<div class="modal-header">
		          <h5 class="modal-title">Deactive your account</h5>
		          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		        </div>
		        
			    <!-- Modal body -->
			    <div class="modal-body d-flex justify-content-between align-items-center">
			       <p>Are you sure you want to <strong>deactivate</strong> this account?</p>
			    </div>
			      
			    <!-- Modal footer -->
			    <div class="modal-footer">
			       <button type="button" class="btn btn-secondary opacity-50" data-bs-dismiss="modal">Cancel</button>
			       <button type="submit" class="btn btn-danger">
			       	Deactivate
				   </button>
			    </div>   
		  	</form>
	    </div>
	</div>
</div>
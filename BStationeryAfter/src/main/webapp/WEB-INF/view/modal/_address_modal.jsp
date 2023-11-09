 <!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-lg modal-dialog-centered">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header px-4">
          <h4 class="modal-title text-info">Add a new address</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body px-4">
            <form action="userAddress" method="post">
            	<input type="hidden" name="userId" value="${user.userId}">
            	<input type="hidden" name="addressId" value="${address.addressId}">
                <div class="mb-3">
                  <label for="name" class="form-label">Name:</label>
                  <input type="text" class="form-control" id="name" placeholder="Enter name" name="nameOfAddress" required>
                </div>
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number:</label>
                    <input type="tel" class="form-control" id="phoneNumber" placeholder="Enter phone number" name="phoneNumberOfAddress" required>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address:</label>
                    <input type="text" class="form-control" id="addressLine1" placeholder="Building, House No., Street Name" name="addressLine1" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" id="addressLine2" placeholder="Ward, District" name="addressLine2" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" id="city" placeholder="City" name="city" required>
                </div>
                <div class="form-check mb-3">
                    <label class="form-check-label">
                      <input class="form-check-input" type="checkbox" name="default"> Set as default
                    </label>
                  </div>
                <button type="submit" class="btn btn-info text-white mb-3 w-100">Add an address</button>
              </form>
        </div>
      </div>
    </div>
  </div>
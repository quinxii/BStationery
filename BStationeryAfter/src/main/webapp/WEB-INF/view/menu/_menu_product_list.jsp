<div class="dropdown mx-5">
  <button class="dropbtn">
  	<a href="productList" style="text-decoration: none;" class="text-white">
	  	<i class="fa fa-regular fa-bars text-white me-3"></i>
	    Product List     
    </a>
  </button>
  <div class="dropdown-content">
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Pen')">
      <span>
        <i class='fas fa-pen-alt fa-9x fs-6 me-3 text-info'></i>
        Pen
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Book')">
      <span>
        <i class='fas fa-book fs-6 me-3 text-primary'></i>
        Book
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Stationery')">
      <span>
        <i class='fas fa-sticky-note fs-6 me-3 text-success'></i>
        Stationery
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('School Supplies')">
      <span>
        <i class='fas fa-eraser fs-6 me-3 text-warning'></i>
        School Supplies
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Fine Arts')">
      <span>
        <i class='fas fa-palette fa-9x fs-6 me-3 text-danger'></i>
        Fine Arts
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Toy')">
      <span>
        <i class='fas fa-car fa-10x fs-6 me-3 text-info'></i>
        Toy
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('STEAM&DIY')">
      <span>
        <i class='fas fa-cubes fs-6 me-3 text-success'></i>
        STEAM & DIY
      </span>
    </a>
    
    <a class="dropdown-item d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Gifts - Lifestyle')">
      <span>
        <i class='fas fa-gift fs-6 me-3 text-warning'></i>
        Gifts - Lifestyle
      </span>
    </a>
  </div>
</div>
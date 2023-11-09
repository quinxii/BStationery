<div id="hidden-menu-sortby-mobile">
	<div class="menu-sortby-mobile mt-3">
		<div class="dropdown">
	       <label class="left me-3">
	           <span class="">Sort by: </span>
	       </label>
	       <button class="sort-dropdown">
	           Sort by
	           <i class="fas fa-chevron-down float-right ms-3"></i>
	       </button>
	       <div class="sort-dropdown-content">
	           <a class="dropdown-item d-flex justify-content-between align-items-center" href="?sort=az">
	               Names A &rarr; Z
	           </a>
	         
	           <a class="dropdown-item d-flex justify-content-between align-items-center" href="?sort=za">
	               Names Z &rarr; A
	           </a>
	         
	           <a class="dropdown-item d-flex justify-content-between align-items-center" href="?sort=price_inc">
	               Incremental price
	           </a>
	           
	           <a class="dropdown-item d-flex justify-content-between align-items-center" href="?sort=price_inc">
	               Descending price
	           </a>
	           
	           <a class="dropdown-item d-flex justify-content-between align-items-center" href="?sort=new_arrival">
	               New arrivals
	           </a>
	       </div>
	   </div>
	
	   <div class="filter" data-bs-toggle="offcanvas" data-bs-target="#filter-list">
	   <button class="sort-dropdown px-0 ps-3 border">
	       <i style="font-size:20px" class="fa me-2">&#xf0b0;</i>
           <span class="left me-3">Filter </span>
	   </button>
	    </div>
	</div>
</div>


<div class="offcanvas offcanvas-end px-3 filter-menu" id="filter-list" style="width: 300px;">
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
                <label class="form-check-label" for="check2">Price under 100,000<span>&#8363;</span></label>
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

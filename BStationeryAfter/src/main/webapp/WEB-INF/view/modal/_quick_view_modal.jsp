<!-- The Modal -->
<div class="modal" id="quickViewModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form enctype="multipart/form-data" id="add-to-cart-form" action="payment" method="post" class="form_background form-inline mb-4 d-flex justify-content-between align-items-center">
            <input type="hidden" name="upc" value="${product.upc}" />
            <div class="container mt-3" style="width:350px;">
                <div class="mySlides">
                    <img src="https://product.hstatic.net/1000230347/product/33_95fcbd9d09874090ba2a64d036991605_1024x1024.jpg" style="width:100%">
                </div>
                
                <div class="mySlides">
                    <img src="https://product.hstatic.net/1000230347/product/combo-20-but-bi-flexoffice-fo-03_72ff28c18b3140d7affe05acb72905e8.jpg" style="width:100%">
                </div>
                
                <div class="mySlides">
                    <img src="https://product.hstatic.net/1000230347/product/b3_2bf571031ba44630afa91b3528a808aa_aa8ee1a9c8b745d5908cf4e89be42011.jpg" style="width:100%">
                </div>
                    
                <div class="mySlides">
                    <img src="https://product.hstatic.net/1000230347/product/but_bi_flexoffice_fo-03_db6d4e76460240a8893e1873a31c370c_a6b2d370329b42bbbc6b67fdda9f161a.jpg" style="width:100%">
                </div>
                    
                <a class="prev" onclick="plusSlides(-1)">
                	<i class="fas fa-chevron-right fa-rotate-180"></i>
                </a>
                <a class="next" onclick="plusSlides(1)">
					<i class="fas fa-chevron-right"></i>                
                </a>
                
                <div class="row-image mt-3">
                    <div class="column border p-2 rounded me-2">
                      <img class="product-image cursor" src="https://product.hstatic.net/1000230347/product/33_95fcbd9d09874090ba2a64d036991605_1024x1024.jpg" style="width:100%" onclick="currentSlide(1)" alt="Bút Bi Flexoffice FO-03">
                    </div>
                    <div class="column border p-2 rounded me-2">
                      <img class="product-image cursor" src="https://product.hstatic.net/1000230347/product/combo-20-but-bi-flexoffice-fo-03_72ff28c18b3140d7affe05acb72905e8.jpg" style="width:100%" onclick="currentSlide(2)" alt="Bút Bi Flexoffice FO-03">
                    </div>
                    <div class="column border p-2 rounded me-2">
                      <img class="product-image cursor" src="https://product.hstatic.net/1000230347/product/b3_2bf571031ba44630afa91b3528a808aa_aa8ee1a9c8b745d5908cf4e89be42011.jpg" style="width:100%" onclick="currentSlide(3)" alt="Bút Bi Flexoffice FO-03">
                    </div>
                    <div class="column border p-2 rounded me-2">
                      <img class="product-image cursor" src="https://product.hstatic.net/1000230347/product/but_bi_flexoffice_fo-03_db6d4e76460240a8893e1873a31c370c_a6b2d370329b42bbbc6b67fdda9f161a.jpg" style="width:100%" onclick="currentSlide(4)" alt="Bút Bi Flexoffice FO-03">
                    </div>
                </div>
            </div>
            <div class="details-pro me-4">
                <h3 class="fw-normal mb-3"><a href="productDetails" class="title-product">Ballpoint Pen</a></h3>
                <div class="row me-1">
                    <div class="me-5">
                        <div class="group-status">
                            <span class="first_status">
                                Brand: 
                                    <span class="status_name availabel hasvariant">
                                        <span class="status_name availabel text-main">Thien Long</span>
                                    </span>
                            </span>
                            <span class="line">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                            <span class="first_status status_2">
                                Status: 
                                    <span class="status_name availabel hasvariant">
                                        <span class="status_name availabel text-main">In stock</span>
                                    </span>
                            </span>
                            <p class="product_sku first_status" style="margin-top: 5px;">
                                Product code:
                                <span class="status_name text-main">123456789123</span>
                            </p>
                        </div>
                        <div class="price-box w-100">
                            <span class="price fs-1 text-warning">4.000</span><span class="fs-1 text-warning">&#8363;</span>
                        </div>
                        <div class="quantity-box mt-5">
                            <span class="quantity-label">Quantity:</span>
                            <a href="quantity-inc-dec?action=dec&upc=${product.upc}" class="quantity-button bg-transparent border-0"><i class="fas fa-minus-square fs-3 text-info"></i></a>
                            <input type="text" id="quantity" class="quantity-input border" value="1" readonly>
                            <a href="quantity-inc-dec?action=inc&upc=${product.upc}" class="quantity-button bg-transparent border-0"><i class="fas fa-plus-square fs-3 text-info"></i></a>
                        </div>
                        <div class="product-action mt-5 ms-2">
                            <div class="row d-flex justify-content-evenly align-items-center mb-3 mt-3">
                                <a href="add-to-cart?upc=${product.upc}" class="col btn btn-sm btn-outline-info p-2 fs-6 me-3">ADD TO CART</a>
                                <a href="add-to-cart?action=buy&upc=${product.upc}" class="col btn btn-sm btn-info text-white p-2 fs-6">BUY NOW</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>              
        </form>
      </div>
    </div>
  </div>
</div>
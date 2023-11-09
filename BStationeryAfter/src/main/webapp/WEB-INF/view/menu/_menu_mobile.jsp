<div class="offcanvas offcanvas-start" id="demo" style="width: 300px;">
  <div class="offcanvas-header bg-info">
    <h4 class="offcanvas-title text-white">Product List</h4>
  </div>
  <div class="offcanvas-body py-0 px-1">
    <ul class="navigation list-group">
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="m-0 p-0 menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Pen')">
            <span>
                <i class='fas fa-pen-alt fa-9x fs-6 text me-3 text-info'></i>
                Pen
            </span>
            <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
        </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Book')">
                <span>
                    <i class='fas fa-book fs-6 text me-3 text-primary'></i>
                    Book
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Stationery')">
                <span>
                    <i class='fas fa-sticky-note fs-6 text me-3 text-success'></i>
                    Stationery
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('School Supplies')">
                <span>
                    <i class='fas fa-eraser fs-6 text me-3 text-warning'></i>
                    School Supplies
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Fine Arts')">
                <span>
                    <i class='fas fa-palette fa-9x fs-6 text me-3 text-danger'></i>
                    Fine Arts
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Toy')">
                <span>
                    <i class='fas fa-car fa-10x fs-6 text me-3 text-info'></i>
                    Toy
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('STEAM&DIY')">
                <span>
                    <i class='fas fa-cubes fs-6 text me-3 text-success'></i>
                    STEAM & DIY
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
        <li class="menu-item list-group-item list-group-item-action" style="border: none;">
            <a class="menu-item__link d-flex justify-content-between align-items-center" href="${pageContext.request.contextPath}/productList" onclick="filterSelection('Gifts-Lifestyle')">
                <span>
                    <i class='fas fa-gift fs-6 text me-3 text-warning'></i>
                    Gifts - Lifestyle
                </span>
                <i class="fas fa-chevron-right float-right" data-toggle-submenu=""></i>
            </a>
        </li>
    </ul>

    <hr class="opacity-25">

    <ul class="navigation list-group menu-content p-0">
        <li class="menu-item list-group-item" style="border: none;">
              <a class="menu-item__link d-flex justify-content-start align-items-center" href="user-orders" onclick="filterSelection('Gifts-Lifestyle')">
                  <img src="./images/shipping_icon.png" alt="shipping_icon" class="shipping-image me-3">
                  Check your order
              </a>
        </li>
        <li class="menu-item list-group-item" style="border: none;">
              <a class="menu-item__link d-flex justify-content-start align-items-center" href="user-orders" onclick="filterSelection('Gifts-Lifestyle')">
                  <img src="https://theme.hstatic.net/1000230347/1000782290/14/policy_header_image_1.png?v=15611" alt="promotion_icon" class="shipping-image me-3">
                  Promotions Guide
              </a>
        </li>
    </ul>
  </div>
</div>
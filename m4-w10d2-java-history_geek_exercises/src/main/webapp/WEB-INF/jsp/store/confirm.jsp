<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="confirmation-page">
	<h2>Thank you for your order</h2>
	<p>Your items will be shipping soon.</p>
	<div id="order-data">
		<div id="shipping-info">
			<h4>Shipping Address</h4>
			<p>
				${confirmationViewModel.order.nameOnCard} <br />
				${confirmationViewModel.order.shippingAddress1} <br />
<%-- 				${confirmationViewModel.order.getCity() confirmationViewModel.order.getState(), confirmationViewModel.order.getPostalCode()} <br /> --%>
			</p>
		</div>
		<div id="payment-info">
			<h4>Payment Info</h4>
		</div>
		<div id="order-summary">
			<h4>Order Summary</h4>
			<div class="row">
				<span class="left">Item(s) Subtotal:</span> <span class="right">${confirmationViewModel.order.subTotal}</span>
			</div>
			<div class="row">
				<span class="left">Shipping &amp; Handling:</span> <span class="right">${confirmationViewModel.order.shipping}</span>
			</div>
			<div class="row">
				<span class="left">Tax:</span> <span class="right">${confirmationViewModel.order.tax}</span>
			</div>
			<div class="row">
				<span class="left">Grand Total:</span> <span class="right">${confirmationViewModel.order.total}</span>
			</div>
        	<c:url value="/store" var="storeHref" />
        	<p><a href="${storeHref}">Continue Shopping</a></p>
		</div>
	</div>
	<div id="order-items">
		<c:forEach var="product" items="${confirmationViewModel.products}">
		<tr>
			<div class="order-item">
				<div class="product-image">
				   	<c:url value="/img/products/" var="imgHref" />
			        <img src="${imgHref}${product.imageName}" title="${product.name}" />
				</div>
				<div class="product-data">
					<c:url value="/store" var="storeHref" />
					<a class="name" href="${storeHref}/detail/${product.sku}">${product.name}</a>

					<span class="price">$8.99</span>
					<span>Qty: 1</span>
					<form action="${storeHref}/addToCart?${product.sku}&amp;quantity=1" id="form0" method="post"> 
						<button>Buy again</button>
					</form>
				</div>
				<div class="product-actions">
					<button>Track package</button>
					<button>Return or replace item</button>
					<button>Get help with order</button>
				</div>
			</div>
		</tr>
		</c:forEach>
	
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

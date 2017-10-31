<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="shopping-cart">
	<c:choose>
		<c:when test="${empty shoppingCart.items}">
			<h3>Your shopping cart is empty.</h3>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<td></td>
						<td></td>
						<td>Price</td>
						<td>Quantity</td>
						<td>Subtotal</td>
					</tr>
				</thead>
				<c:forEach var="cartItem" items="${shoppingCart.items}">
					<tr>
						<td class="image">
						   	<c:url value="/img/products/" var="imgHref" />
					        <img src="${imgHref}${cartItem.product.imageName}" title="${product.name}" />
						</td>
						<td class="title">
							<c:url value="/store/detail" var="storeHref" />
							<h3><a class="name" href="${storeHref}/${cartItem.product.sku}">${cartItem.product.name}</a></h3>
						</td>
						<td class="price">
							${cartItem.product.price}
						</td>
						<td class="quantity">
							<c:url var="formAction" value="/store/updateCart" />
							<form action="${formAction}" id="form0" method="post">
								<input id="sku" name="sku" type="hidden" value="${cartItem.product.sku}" />
								<input id="quantity" name="quantity" type="number" value="${cartItem.quantity}" /> 
								<button>Update Cart</button>
							</form>
						</td>
						<td class="subtotal">
							${cartItem.price}
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
						<p>Total: <span class="price">${shoppingCart.subTotal}</span></p>
						<c:url value="/store/checkout" var="storeHref" />
						<a class="button" href="${storeHref}">Checkout</a>
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

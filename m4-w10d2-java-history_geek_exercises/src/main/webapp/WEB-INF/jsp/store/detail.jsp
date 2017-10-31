<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="product-detail">
   	<c:url value="/img/products/" var="imgHref" />
	<div class="product-image">
        <img src="${imgHref}${product.imageName}" title="${product.name}" />
	</div>		
	<div class="product-data">
		<h3>${product.getName()}</h3>
		<p class="attribute">List Price: <span class="price">${product.price}</span></p>
		<p class="attribute">Weight: <span class="weight">${product.weight} oz</span></p>
		<p class="description">${product.description}</p>
	</div>
	<c:url var="formAction" value="/store/addToCart" />
	<form action="${formAction}" id="form0" method="post">
		<input id="sku" name="sku" type="hidden" value="${product.sku}" /> 
		<div>
			<select id="quantity" name="quantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
		</div>
		<button>Add To Cart</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

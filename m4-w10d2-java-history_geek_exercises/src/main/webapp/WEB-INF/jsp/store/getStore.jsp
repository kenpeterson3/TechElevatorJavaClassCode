<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2>Gift Shop</h2>

<div id="products">
<c:forEach var="product" items="${products}">
	<div class="product-card">
    	<c:url value="/store/detail/" var="storeHref" />
    	<c:url value="/img/products/" var="imgHref" />
        <a href="${storeHref}${product.sku}"><img src="${imgHref}${product.imageName}" /></a>
		<a class="name" href="${storeHref}${product.sku}">
			${product.name}
		</a>
        <p class="price">${product.price}</p>
	</div>
</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


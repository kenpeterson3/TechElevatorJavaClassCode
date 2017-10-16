<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common/header.jspf"%>

<div class="flexContainer">

	<c:forEach items="${products}" var="product">
		<div class="flexContainerTile">
			<c:url var="productLink"
				value="productDetail?productId=${product.productId}" />
			<a href="${productLink}"><img src="img/${product.imageName}"
				class="productImage" /></a>
			<div class="flexContainerTextTiles">
				<h4 class="link">
					<a href="${productLink}"><c:out value="${product.name}" /></a>
				</h4>
			</div>
			<div class="price">
			<c:out value="${product.topSeller? ' Best Seller!':''}" />
			</div>
			by
			<c:out value="${product.manufacturer}" />
			<br>
			<div class="blue">
			<c:choose>
			<c:when test="${product.remainingStock < 5}">
			Only <c:out value="${product.remainingStock}" /> left!
			</c:when>
			</c:choose>
			</div>
			<div class="price">
				$
				<c:out value="${product.price}" />
			</div>
			<div>
				Weight
				<c:out value="${product.weightInLbs}" />
				lbs
			</div>
			<fmt:formatNumber value="${product.averageRating}"
				maxFractionDigits="0" var="formattedRating" />
			<img id="star" src="img/${formattedRating}-star.png"
				class="ratingTiles" />


		</div>

	</c:forEach>
</div>

<%@ include file="common/footer.jspf"%>
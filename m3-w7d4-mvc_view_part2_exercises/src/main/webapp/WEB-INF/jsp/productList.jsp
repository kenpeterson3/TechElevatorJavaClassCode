<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common/header.jspf"%>


<div>


	<c:forEach items="${products}" var="product">
		<div class="containerList">
			<div class="containerListPics">
				<c:url var="productLink"
					value="productDetail?productId=${product.productId}" />
				<a href="${productLink}"><img src="img/${product.imageName}"
					class="productImageList" /></a>
			</div>

			<div class="containerListInfo">
				<span class="link">
					<a href="${productLink}"><c:out value="${product.name}" />
					<span class="red"><c:out value="${product.topSeller? ' Best Seller!':''}" /></span></a>
				</span><br>
				by
				<c:out value="${product.manufacturer}" />
				<br> <span class="price"> $ <c:out
						value="${product.price}" />
				</span><br> Weight
				<c:out value="${product.weightInLbs}" />
				lbs <br>
				<fmt:formatNumber value="${product.averageRating}"
					maxFractionDigits="0" var="formattedRating" />
				<img id="star" src="img/${formattedRating}-star.png"
					class="ratingTilesList" />
			
			</div>
		</div>
		<hr>
	</c:forEach>
</div>

<%@ include file="common/footer.jspf"%>
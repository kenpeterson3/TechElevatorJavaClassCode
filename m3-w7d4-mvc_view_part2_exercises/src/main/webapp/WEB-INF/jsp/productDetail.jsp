<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common/header.jspf"%>

<div class="productDetailsMain">

	<div class="containerDetailsPics">
		<img src="img/${product.imageName}"
			class="productImageList" />
	</div>

	<div class="textDetails">
		<c:out value="${product.name}" /> <span class="red"><c:out
						value="${product.topSeller? ' Best Seller!':''}" /></span><br>

		by <c:out value="${product.manufacturer}" />
		<br>

		<fmt:formatNumber value="${product.averageRating}"
			maxFractionDigits="0" var="formattedRating" />
		<img id="star" src="img/${formattedRating}-star.png"
			class="ratingTilesList" /><br> <span class="price"> $ <c:out
				value="${product.price}" />
		</span><br> Weight
		<c:out value="${product.weightInLbs}" />
		lbs <br>

		<c:out value="${product.description}"></c:out>



	</div>

</div>

<%@ include file="common/footer.jspf"%>
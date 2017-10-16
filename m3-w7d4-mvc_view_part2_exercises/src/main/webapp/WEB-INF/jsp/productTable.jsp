<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common/header.jspf" %>
		
			<table id="productTable">
			
				<tr>
					<th>&nbsp;</th>
						<c:forEach items="${products}" var="product">
							<c:url var="productLink" value="productDetail?productId=${product.productId}"/>
								<td><a href="${productLink}"><img src="img/${product.imageName}" class="productImage"></a></td>
						</c:forEach>
				</tr>
				<tr class="gray">
					<th>Name</th>
						<c:forEach items="${products}" var="product">
							<td class="link"><a href="${productLink}"><c:out value="${product.name}" /></a></td>
						</c:forEach>
				</tr>
				
				<tr>
					<th>Rating</th>
						<c:forEach items="${products}" var="product">
					<td ><fmt:formatNumber value="${product.averageRating}" maxFractionDigits="0" var="formattedRating"/>
						<img src="img/${formattedRating}-star.png" class="rating"/>
					</td>
				</c:forEach>
				</tr>
				<tr>	
				<tr class="gray">
					<th>Mfr</th>
						<c:forEach items="${products}" var="product">
							<td><c:out value="${product.manufacturer}" /></td>
						</c:forEach>
				</tr>
				<tr>	
					<th>Price</th>
						<c:forEach items="${products}" var="product">
							<td class="price" ><c:out value="${product.price}" /></td>
						</c:forEach>
				</tr>
				<tr>
				<tr class="gray">
					<th>wt.(in lbs)</th>
						<c:forEach items="${products}" var="product">
							<td><c:out value="${product.weightInLbs}" /></td>
						</c:forEach>
				</tr>			
			</table>
       
 <%@ include file="common/footer.jspf" %>
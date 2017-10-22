<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Squirrel Cigar Party</title>
    <c:url value="/css/squirrel.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
	
    <header>

        <h1>Squirrel Cigar Party For Dummies</h1>
        <img src="img/forDummies.png" class="centered"/>
    </header>

<section class="centeredPanel">
	<h2><strong>Reviews for Squirrel Cigar Party For Dummies</strong></h2>
	<c:url var="newReviewUrl" value="/newReview"/>
	<span class="centered"> <a href="${newReviewUrl }">Leave a Review</a></span>
		<ul>
		<c:forEach items="${allReviews }" var="review">
			
				
				<li><c:out value="${review.title}"/> (<c:out value="${review.username}"/>)</li>
				<li><c:out value="${review.dateSubmitted}"/></li>
				
				
				<c:forEach begin="1" end="${review.rating}" step="1">
				<img src="img/star.png" />
				</c:forEach>
				
				<li><c:out value="${review.text}"/></li>
				<br>
				<hr>
		</c:forEach>
		</ul>
	
</section>
<p class="centered" > Copyright Squirrel Inc 2017</p>
</body>
</html>


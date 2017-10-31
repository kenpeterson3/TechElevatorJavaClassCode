<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jsp" %>

	<h2>League Members</h2>
		<c:url var="destinyAdminUrl" value="/destinyAdmin"/>
		<span class="centered"> <a href="${destinyAdminUrl }">Add Members,Wins and Losses</a></span>
	
		<ul>
		<c:forEach items="${membersList}" var="member">
			<li><c:out value="${member.firstName }"/> <c:out value="${member.lastName }"/> 
			Wins:<c:out value="${member.wins }"/> Losses:<c:out value="${member.losses }"/>
			
		
		
		</c:forEach>
		</ul>
		
<%@include file="common/footer.jsp" %>
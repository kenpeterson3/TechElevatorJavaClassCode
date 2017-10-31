<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jsp" %>
	<c:url var="rankingsUrl" value="/rankings"/>
	<span class="centered"> <a href="${rankingsUrl }">View Current Rankings</a></span>
	
	<h2>Add Wins and Losses</h2>
	<c:forEach items="${memberList}" var="member">
		<c:url var="rankingsUrl" value="/rankings"/>
	 	<form:form method="POST" action="${rankingsUrl }" modelAttribute="member"> 
		<ul>
			<li><c:out value="${member.firstName }"/> <c:out value="${member.lastName }"/> 
			
			<form:label path="wins">Wins:</form:label>
			<form:input path="wins" placeholder="wins" type="number" />
			<form:errors path="wins" cssClass="error"/>
			
			<form:label path="losses">Losses:</form:label>
			<form:input path="losses" placeholder="losses" type="number" />
			<form:errors path="losses" cssClass="error"/>
			
			<input style="color: white; background-color: blue;" type="submit" value="Submit"/>
		</ul>
		</form:form>
		</c:forEach>
		
		<c:url var="rankingsUrl" value="/rankings"/>
	<form:form method="POST" action="${rankingsUrl }" modelAttribute="member">
			
	<h2><strong>Add New Member</strong></h2>	
		
	<div>
		<form:label path="firstName">First Name:</form:label>
		<form:input path="firstName" placeholder="enter first name"/>
		<form:errors path="firstName" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>
	
	<div>
		<form:label path="lastName">Last Name:</form:label>
		<form:input path="lastName" placeholder="enter last name"  />
		<form:errors path="lastName" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>	
	<div>	
		<form:label path="wins">Wins:</form:label>
		<form:input path="wins" placeholder="wins" type="number" />
		<form:errors path="wins" cssClass="error"/>
	</div><br>	
	<div>	
		<form:label path="losses">Losses:</form:label>
		<form:input path="losses" placeholder="losses" type="number" />
		<form:errors path="losses" cssClass="error"/>
	</div><br>
	<div>
		<input style="color: white; background-color: blue;" type="submit" value="Submit"/>
	</div>
		</form:form>
<%@include file="common/footer.jsp" %>
	

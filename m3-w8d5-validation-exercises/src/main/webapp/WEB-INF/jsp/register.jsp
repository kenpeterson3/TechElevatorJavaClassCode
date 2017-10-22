<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="Login Page"/>
<%@include file="common/header.jspf" %>

<h2>New User Registration</h2>


<c:url var="loginUrl" value="/register"/>
<form:form method="POST" action="${registerUrl }" modelAttribute="registration">
	
	<div>
		<label for="firstName">First Name</label>
		<form:input path="firstName" placeholder="enter first name"/>
		<form:errors path="firstName" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>
		
	<div>
		<label for="lastName">Last Name</label>
		<form:input path="lastName" placeholder="enter last name"/>
		<form:errors path="lastName" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>

	<div>
		<label for="email">Email</label>
		<form:input path="email" placeholder="enter Email"/>
		<form:errors path="email" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>	
	
	<div>
		<label for="confirmEmail">Confirm Email</label>
		<form:input path="confirmEmail" placeholder="confirm Email address"/>
		<form:errors path="confirmEmail" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>
	
		<div>
		<label for="password">Password</label>
		<form:input path="password" placeholder="enter password" type="password" />
		<form:errors path="password" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>
	
	<div>
		<label for="passwordCheck">Confirm Password</label>
		<form:input path="passwordCheck" placeholder="confirm password" type="password" />
		<form:errors path="passwordCheck" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>	
	
	<div>
		<label for="birthDate">Birthday</label>
		<form:input path="birthDate" placeholder="birthdate mm/dd/yyyy"/>
		<form:errors path="birthDate" cssClass="error"/>
		<span style="color: red;" >*</span>	
	</div><br>
	
	<div>
		<label for="ticket"># of Tickets</label>
		<form:input path="ticket" placeholder="enter # of tickets" type="number" min="1" max="10"/>
		<form:errors path="ticket" cssClass="error"/>
		<span style="color: red;" >*</span>
	</div><br>
	
	<div>
		<input style="color: white; background-color: blue;" type="submit" value="Submit"/>
	</div>
</form:form>
<%@include file="common/footer.jspf" %>
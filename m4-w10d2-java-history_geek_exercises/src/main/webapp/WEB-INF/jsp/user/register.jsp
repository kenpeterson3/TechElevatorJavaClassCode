<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="register">
<h2>Register</h2>
<c:url var="formAction" value="/user/register" />
<form id="form0" method="POST" action="${formAction}">
	<div>
		<input type="text" name="email" id="email" value="" placeholder="joe@history.com" /><br/>
	</div>
	<div>
		<input type="password" name="password" id="password" placeholder="password" /><br/>
	</div>
	<div>
		<input type="password" name="confirmPassword" id="confirmPassword" placeholder="type password again" /><br/>
	</div>
	<button>Register</button>
</form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

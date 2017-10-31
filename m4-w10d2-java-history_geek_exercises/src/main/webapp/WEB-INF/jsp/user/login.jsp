<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="login">
<h2>Login</h2>
<c:url var="formAction" value="/user/login" />
<form id="form0" method="POST" action="${formAction}">
	<div>
		<input type="text" name="email" id="email" placeholder="email" value=""/><br/>
	</div>
	<div> 
		<input type="password" name="password" id="password" placeholder="password" /><br/>
	</div>
	<button>Login</button>
</form>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

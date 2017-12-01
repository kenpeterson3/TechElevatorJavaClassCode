<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>

<c:url var="formAction" value="/users" />
<form method="POST" action="${formAction}">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="userName">User Name: </label>
				<input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" id="password" name="password" placeHolder="Password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />	
			</div>
			<button type="submit" class="btn btn-default">Create User</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>
		
<c:import url="/WEB-INF/jsp/footer.jsp" />
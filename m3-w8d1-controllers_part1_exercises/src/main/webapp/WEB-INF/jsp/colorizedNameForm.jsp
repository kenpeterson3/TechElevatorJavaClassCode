<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/colorizedResult" var="formAction"/>
		<form action="${formAction}" method="GET">
			<h2>Enter Name</h2>
			<div>
				<label>First Name:</label>
				<input type= "text" name="firstName" id="firstName"/>
			</div>
			
			<div>
				<label>Last Name:</label>
				<input type= "text" name="lastName" id="lastName"/>
			</div>
			
			<h2>Choose Color</h2>
			<div>
				<input type= "checkbox" name="red"  id="red" value="true" />Red
			</div>
			<div>
				<input type= "checkbox" name="blue"  id="blue" value="true"  />Blue
			</div>
			<div>
				<input type= "checkbox" name="green"  id="green" value="true" />Green
			</div>
			
			<div>
				<input type= "submit" />
			</div>
		</form>
		
	</body>
</html>
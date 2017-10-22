<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/xOrderedResult" var="formAction"/>
		<form action="${formAction}" method="GET">
			<h1>Enter Name</h1>
			<div>
			<label>First Name:</label>
			<input type= "text" name="firstName" id="firstName"/>
			</div>
			<div>
			<label>Middle Name:</label>
			<input type= "text" name="middleName" id="middleName"/>
			</div>
			<div>
			<label>Last Name:</label>
			<input type= "text" name="lastName" id="lastName"/>
			</div>
			<h2>Choose Order</h2>
			<div>
			<input type= "radio" name="order" value="FML" checked/>First MI Last
			</div>
			<div>
			<input type= "radio" name="order" value="FL"/>First Last
			</div>
			<div>
			<input type= "radio" name="order" value="LFM"/>Last, First MI 
			</div>
			<div>
			<input type= "radio" name="order" value="LF"/>Last, First
			</div>
			<div>
			<input type= "submit" />
			</div>
		</form>
		
	</body>
</html>
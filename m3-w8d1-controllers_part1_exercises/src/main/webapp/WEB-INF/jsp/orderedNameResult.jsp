<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
	 	<h2>Ordered Name</h2>
	 	First Name:
	 	<c:out value="${param.firstName }"/><br>
		Middle Name:
	 	<c:out value="${param.middleName }"/><br>
	 	Last Name:
	 	<c:out value="${param.lastName }"/><br>
	 	Ordered:
	 	<c:out value="${nameOrder}"></c:out>
	</body>
</html>

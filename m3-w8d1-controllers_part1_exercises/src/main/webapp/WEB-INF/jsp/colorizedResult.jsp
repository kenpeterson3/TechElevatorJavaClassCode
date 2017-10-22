<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
	 	<h2>Colored Name</h2>
	 	First Name:
	 	<c:out value="${colorizedName.firstName}"/><br>
	 	Last Name:
	 	<c:out value="${colorizedName.lastName}"/><br>
	 	
	 	<c:if test="${colorizedName.red}" >
	 	<br><div style= "color: red;"> <c:out value="${colorizedName.firstName}"/><c:out value="${colorizedName.lastName}"/></div>
	 	</c:if>
	 	<c:if test="${colorizedName.blue}" >
	 	<br><div style= "color: blue;"> <c:out value="${colorizedName.firstName}"/><c:out value="${colorizedName.lastName}"/></div>
	 	</c:if>
	 	<c:if test="${colorizedName.green}" >
	 	<br><div style= "color: green;"> <c:out value="${colorizedName.firstName}"/><c:out value="${colorizedName.lastName}"/></div>
	 	</c:if>
	</body>
</html>
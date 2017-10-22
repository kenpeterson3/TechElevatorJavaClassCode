<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
	 	<h2>FizzBuzz Revisited</h2>
	 	Divisible by:
	 	<c:out value="${fizzBuzz.divisor1}"/><br>
	 	Divisible by:
	 	<c:out value="${fizzBuzz.divisor2}"/><br>
	 	Divisible by both:
	 	<c:out value="${fizzBuzz.divisor1} and ${fizzBuzz.divisor2}"/><br><br>
	 	Alternative Fizz:
	 	<c:out value="${fizzBuzz.alternateFizz}"/><br>
	 	Alternative Buzz:
	 	<c:out value="${fizzBuzz.alternateBuzz}"/><br><br>
	 	
	 	<c:forEach items = "${fizzBuzz.runFizzBuzz()}" var="num">
	 	<c:out value="${num}"/><br>
	 	</c:forEach>
	</body>
</html>
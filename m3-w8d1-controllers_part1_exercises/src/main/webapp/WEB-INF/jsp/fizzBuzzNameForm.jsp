<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/fizzBuzzResult" var="formAction"/>
		<form action="${formAction}" method="GET">
			<h2>FizzBuzz Revisited</h2>
			<div>
				<label>Divisible By:</label><br>
				<input type= "text" name="divisor1" id="divisor1"/>
			</div>
			<div>
				<label>Divisible By:</label><br>
				<input type= "text" name="divisor2" id="divisor2"/>
			</div>
			<div>
				<label>Alternative Fizz:</label><br>
				<input type= "text" name="alternateFizz" id="alternateFizz"/>
			</div>
			<div>
				<label>Alternative Buzz:</label><br>
				<input type= "text" name="alternateBuzz" id="alternateBuzz"/>
			</div>
			
		
			<div>
				<label>Number 1:</label>
				<input type= "text" name="nums" />
			</div>
			<div>
				<label>Number 2:</label>
				<input type= "text" name="nums" />
			</div>
			<div>
				<label>Number 3:</label>
				<input type= "text" name="nums" />
			</div>
			<div>
				<label>Number 4:</label>
				<input type= "text" name="nums" />
			</div>
			<div>
				<label>Number 5:</label>
				<input type= "text" name="nums" />
			</div>
			
			<div>
				<input type= "submit" />
			</div>
		</form>
		
	</body>
</html>
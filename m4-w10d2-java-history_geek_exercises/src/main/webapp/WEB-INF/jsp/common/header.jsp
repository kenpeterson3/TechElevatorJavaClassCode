<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width" />
    <title>History Geek</title>
    
    <c:url value="/css/style.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">

    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Lato">
    <script src="https://use.fontawesome.com/b6042e8b1f.js"></script>

    <c:url value="/js" var="jsHref" />
    <script src="${jsHref}/jquery-3.1.1.js"></script>
    <script src="${jsHref}/jquery.validate.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>
    <!-- BOOTSTRAPPER -->
    <script src="${jsHref}/setup/bootstrapper.js"></script>
    <!-- EXERCISES -->
    <script src="${jsHref}/exercises/dom-exercises.js"></script>
    <script src="${jsHref}/exercises/event-exerises.js"></script>
    <script src="${jsHref}/exercises/validation-exercises.js"></script>
    <script src="${jsHref}/exercises/api-exercises.js"></script>

</head>

<body>
    <header>
    	<c:url value="/" var="homePageHref" />
    	<c:url value="/img/geek.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="History Geek logo" />
        </a>
        <h1>History Geek</h1>
    </header>
    <nav>
        <ul>
        	<c:url value="/usPresidents" var="usPresidentsHref" />
        	<c:url value="/store" var="storeHref" />
			<c:url value="/game/game/10" var="gameHref" />
        	<c:url value="/user/login" var="loginHref" />
        	<c:url value="/user/register" var="registerHref" />
        	<c:url value="/user/logout" var="logoutHref" />
        	<c:url value="/chat" var="chatHref" />
			<c:url value="/store/viewCart" var="viewCartHref" />
            <li><a href="${homePageHref}">Home</a></li>
            <li><a href="${usPresidentsHref}">US Presidents</a></li>
            <li><a href="${storeHref}">Store</a></li>
            <li><a href="${gameHref}">Game</a></li>
            <c:choose>
            	<c:when test="${empty sessionScope.email}">
					<li class="right-aligned"><a href="${loginHref}">Login</a></li>
					<li class="right-aligned"><a href="${registerHref}">Register</a></li>
            	</c:when>
            	<c:otherwise>
					<li><a href="${chatHref}">Chat</a></li>
					<li class="right-aligned"><a href="${logoutHref}">Logout</a></li>
					<li class="right-aligned"><a href="${viewCartHref}">View Cart</a></li>
            	</c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <main>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url value="/js" var="jsHref" />
<script src="${jsHref}/sockjs.min.js"></script>
<script src="${jsHref}/stomp.min.js"></script>
<script src="${jsHref}/exercises/websocket-exercises.js"></script>

<div id="chatroom">

    <div id="messages">
        <h3>History</h3>
        <!-- Messages go here -->
        <div id="history">
            <c:forEach items="${messages}" var="message">
                <p class="message">
                    <span class="username"><c:out value="${message.userName}"/></span>
                    <span class="time"><fmt:formatDate value="${message.sentDateAsDate}" pattern="h:mm a"/></span> <br />
                    <c:out value="${message.message}"/>
                </p>
            </c:forEach>
        </div>
        <div id="newMessageForm">
        	<form action="#" id="chatForm">
        		<textarea name="message"></textarea>
        		<button>Send</button>
        	</form>
        </div>
    </div>
    <div id="members">
        <h3>Active Members</h3>
        <!-- Members List goes here -->
        <ul>            
        </ul>
    </div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />

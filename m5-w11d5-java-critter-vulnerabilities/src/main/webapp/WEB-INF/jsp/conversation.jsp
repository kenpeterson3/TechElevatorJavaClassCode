<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Private Conversation with ${conversation.withUser}</h2>

<ol class="message-list">
	<c:forEach items="${conversation.messages}" var="message">
		<c:choose>
			<c:when test="${conversation.forUser == message.fromUsername}">
				<c:set var="fromto" value="from" />
			</c:when>
			<c:otherwise>
				<c:set var="fromto" value="to" />
			</c:otherwise>
		</c:choose>
		<li class="message ${fromto}">
			<span class="username">${message.fromUsername}</span>
			<span class="message-text">${message.text}</span>
			<time class="timeago" datetime="${message.createTime}">${message.createTime}</time>
		</li>
	</c:forEach>
</ol>

<c:import url="/WEB-INF/jsp/footer.jsp" />
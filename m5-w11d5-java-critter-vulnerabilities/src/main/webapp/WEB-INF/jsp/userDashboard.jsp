<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Latest Private Messages</h2>
<ol class="message-list">
	<c:forEach var="conversation" items="${conversations}">
		<li class="message">
			<c:url var="conversationHref" value="/users/${conversation.forUser}/conversations/${conversation.withUser}" />
			<span class="username"><a href="${conversationHref}">${conversation.withUser}</a></span>
			<span class="message-text">${conversation.latestMessage.text}</span>
			<time class="timeago" datetime="${conversation.latestMessage.createTime}">${conversation.latestMessage.createTime}</time>
		</li>
	</c:forEach>
</ol>

<c:import url="/WEB-INF/jsp/footer.jsp" />
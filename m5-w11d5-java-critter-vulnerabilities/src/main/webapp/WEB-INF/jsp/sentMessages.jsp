<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Sent Messages</h2>

<ol class="message-list">
	<c:forEach items="${messages}" var="message">
		<li class="message">
			<c:if test="${not empty message.toUsername}">
				<c:url var="conversationHref" value="/users/${message.fromUsername}/conversations/${message.toUsername}" />
				<span class="username">
					<a href="${conversationHref}">@${message.toUsername}</a>
				</span>
			</c:if>
			<span class="message-text">${message.text}</span>
			<time class="timeago" datetime="${message.createTime}">${message.createTime}</time>
		</li>
	</c:forEach>
</ol>

<c:import url="/WEB-INF/jsp/footer.jsp" />
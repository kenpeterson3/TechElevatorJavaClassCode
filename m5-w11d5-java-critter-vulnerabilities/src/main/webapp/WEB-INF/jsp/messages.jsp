<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Latest Messages From ${param.userName}</h2>

<ol class="message-list">
	<c:forEach items="${messages}" var="message">
		<li class="message">
			<span class="message-text">${message.text}</span>
			<time class="timeago" datetime="${message.createTime}">${message.createTime}</time>
		</li>
	</c:forEach>
</ol>

<c:import url="/WEB-INF/jsp/footer.jsp" />
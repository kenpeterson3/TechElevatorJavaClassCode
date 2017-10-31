<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="game">
    <h2>Pirate Explorer </h2>
    <button id="btnRestart">Restart</button>

    <table id="gameboard">
    
		<c:forEach var="row" begin="0" end="${gridSize - 1}">
			<tr id="row_${row}" class="gamerow">
				<c:forEach var="column" begin="0" end="${gridSize - 1}">
					<c:set var="cellID" value="row_${row}_column_${column}" />
					<c:set var="ceLLClass" value="gamecell" />
						<c:if test="${(row == 0) && (column == 0)}">
							<c:set var="ceLLClass" value="${ceLLClass} ship" />
						</c:if>
						<c:if test="${(row == gridSize - 1) && (column == gridSize - 1)}">
							<c:set var="ceLLClass" value="${ceLLClass} treasure" />
						</c:if>
						<c:if test="${(((row*column) + (column+1)) % 7 == 0)}">
							<c:set var="ceLLClass" value="${ceLLClass} iceberg" />
						</c:if>
						<c:if test="${(((row * column) + (column + 1)) % 13 == 0)}">
							<c:set var="ceLLClass" value="${ceLLClass} pirate" />
						</c:if>
               		<td id="${cellID}" class="${ceLLClass}"></td>
				</c:forEach>
			</tr>
		</c:forEach>

    </table>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


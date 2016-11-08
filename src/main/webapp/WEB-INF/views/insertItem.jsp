<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Insert Item Form" />
</jsp:include>
<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Insert Item Form</h2>
 
	<form:form method="POST" modelAttribute="item">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input class="form-control" path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="price">Price: </label> </td>
				<td><form:input class="form-control" path="price" id="price"/></td>
				<td><form:errors path="price" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="imgLink">Image: </label> </td>
				<td><form:input class="form-control" path="imgLink" id="imgLink"/></td>
				<td><form:errors path="imgLink" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" class="btn btn-lg btn-primary" value="Add"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='allitems' />">List of All Items</a>
<jsp:include page="bottom.jsp" />
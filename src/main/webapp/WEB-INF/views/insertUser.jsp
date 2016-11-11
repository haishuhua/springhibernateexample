<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Register" />
</jsp:include>

	<h2>Insert User Form</h2>
 
	<form:form method="POST" modelAttribute="user" class="form-horizontal" action="welcome">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input class="form-control" path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="wechatnumber">WeChat: </label> </td>
				<td><form:input class="form-control" path="wechatnumber" id="wechatnumber"/></td>
				<td><form:errors path="wechatnumber" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td><label for="password">Password: </label> </td>
				<td><form:input class="form-control" path="password" id="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="address">Address: </label> </td>
				<td><form:input class="form-control" path="address" id="address"/></td>
				<td><form:errors path="address" cssClass="error"/></td>
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
	<jsp:include page="bottom.jsp" />
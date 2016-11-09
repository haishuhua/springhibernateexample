<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Register" />
</jsp:include>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

	<h2>List of Items</h2>	
	<table  class="table">
		<tr>
			<td>Name(Click to edit)</td><td>Price</td><td>Image</td><td>DELETE</td>
		</tr>
		<c:forEach items="${Items}" var="item">
			<tr>
			<td><a href="<c:url value='/edit-${item.name}-item' />">${item.name}</a></td>
			<td>${item.price}</td>
			<td><a href="">${item.imgLink}</a></td>
			<td><a href="<c:url value='/delete-${item.name}-item' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/insertItem' />">Add New Item</a>
<jsp:include page="bottom.jsp" />
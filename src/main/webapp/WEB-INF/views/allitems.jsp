<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List All Items</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Items</h2>	
	<table>
		<tr>
			<td>Name</td><td>Price</td><td>Image</td>
		</tr>
		<c:forEach items="${Items}" var="item">
			<tr>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td><a href="<c:url value='/edit-${item.name}-item' />">${item.imgLink}</a></td>
			<td><a href="<c:url value='/delete-${item.name}-item' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/insertItem' />">Add New Item</a>
</body>
</html>
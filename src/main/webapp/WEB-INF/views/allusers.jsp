<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List All Users</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Users</h2>	
	<table>
		<tr>
			<td>Name</td><td>Address</td><td>WeChat</td>
		</tr>
		<c:forEach items="${Users}" var="user">
			<tr>
			<td>${user.name}</td>
			<td>${user.address}</td>
			<td><a href="<c:url value='/edit-${user.wechatnumber}-user' />">${user.wechatnumber}</a></td>
			<td><a href="<c:url value='/delete-${user.wechatnumber}-user' />">delete</a></td>
			
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/insertUser' />">Add New Item</a>
</body>
</html>
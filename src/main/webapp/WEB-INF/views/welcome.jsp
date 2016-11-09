<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Login" />
</jsp:include>
<h1>Welcome Form:</h1>
<h2>wechatnumber: ${wechatnumber}</h2>

<div class="topTen">
	<table>
		<th>Items</th>
		<th>Sold</th>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
		<tr>item1<td>sold1</td></tr>
	</table>

</div>

<jsp:include page="bottom.jsp" />
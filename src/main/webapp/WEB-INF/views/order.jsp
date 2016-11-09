<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Template" />
</jsp:include>
	<form>
	<h1>Order Here:</h1>
	<table>
	
	<th>Item</th><th>Quantity</th><th>Price</th>
	<tr><td>Item</td><td>Quantity</td><td>Price</td></tr>
	</table>
	<input type="button" value="Add one more">
	
	</form>
<jsp:include page="bottom.jsp" />
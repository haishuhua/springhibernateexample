<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Template" />
</jsp:include>

<form>
	<h1>Order Here:</h1>
	<table class="table">
		<tr>
			<th>Item</th>
			<th>Price</th>
			<th>Img</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td><select name="item1">
					<c:forEach items="${itemsList}" var="item">
						<option value="${item.id}|${item.price}|${item.imgLink}">
						${item.name}
						</option>
					</c:forEach>
			</select></td>
			<td><span name="item1Price"></span></td>
			<td><img name="item1Img" src="" /></td>



			<td><select name="quantity1"><c:forEach var="i"
						begin="1" end="10">
						<option value="${i}">${i}</option>
					</c:forEach></select></td>
		</tr>
	</table>
	<input type="button" value="Add one more">
	<img src="<s:url value="/resources/images/yapei.jpg" />" />
</form>

<script type="text/javascript">
	$('select').on('change', function() {
		var selectid = this.name;
		var item = this.value.split('|');
		var price = item[1];
		console.log('<s:url value="/resources/images/yapei.jpg" />');
		var imgLink = "/SpringHibernateExample/resources/images/"+item[2];
		$("span[name=" + selectid + "Price]").html(price);
		$("img[name=" + selectid + "Img]").attr("src", imgLink);
	});
</script>
<jsp:include page="bottom.jsp" />
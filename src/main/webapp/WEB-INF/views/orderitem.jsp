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
		<tr id="trorder1">
			<td><select name="order1">
					<c:forEach items="${itemsList}" var="item">
						<option value="${item.id}|${item.price}|${item.imgLink}">
						${item.name}
						</option>
					</c:forEach>
			</select></td>
			<td><span name="order1Price"></span></td>
			<td><img name="order1Img" src="" /></td>
			<td><select name="order1Quantity"><c:forEach var="i"
						begin="1" end="10">
						<option value="${i}">${i}</option>
					</c:forEach></select></td>
		</tr>
	</table>
	<input type="button" value="Add one more" id="addOneMore">
	<img src="<s:url value="/resources/images/yapei.jpg" />" />
</form>

<script type="text/javascript">
	var count=1;	
	$('select').on('change', function() {
		var selectid = this.name;
		var item = this.value.split('|');
		var price = item[1];
		console.log('<s:url value="/resources/images/yapei.jpg" />');
		var imgLink = "/SpringHibernateExample/resources/images/"+item[2];
		$("span[name=" + selectid + "Price]").html(price);
		$("img[name=" + selectid + "Img]").attr("src", imgLink);
	});

	$('#addOneMore').click(function() {
        count=count+1;
		var tempStr= $( "#trorder1" ).clone().html().replace('order1','order'+count);
        tempStr= tempStr.replace('order1','order'+count);
        tempStr= tempStr.replace('order1','order'+count);
        tempStr= tempStr.replace('order1','order'+count);
        //console.log(tempStr);;
        $( ".table" ).append("<tr name='trorder"+count+"' >"+tempStr+"</tr>" );
        //.replace('item1','item'+count).appendTo( ".table" );
	});
	

	
</script>
<jsp:include page="bottom.jsp" />
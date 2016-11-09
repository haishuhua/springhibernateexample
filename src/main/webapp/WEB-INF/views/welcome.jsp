<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Welcome" />
</jsp:include>
<h1>Welcome Form:</h1>

<h2>Wechatnumber: ${wechatnumber} Points:</h2>
<h3>Check my orders</h3>
<h3>Earn points</h3>
<div class="topTen">
	<div class="newItems">
		<h1>
		New Items
		</h1>
		<table class="table">
		<tr><th>Item</th><th>Description</th><th>Price</th><th>Img</th></tr>
		<tr><td>item1</td><td>description</td><td>price</td><td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj4ArIGBSSZ2VDcXv-gOkj5f-49Uxpl682Jn5kNIBw-gGkrmsg"/></td></tr>
		<tr><td>item1</td><td>description</td><td>price</td><td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj4ArIGBSSZ2VDcXv-gOkj5f-49Uxpl682Jn5kNIBw-gGkrmsg"/></td></tr>
		<tr><td>item1</td><td>description</td><td>price</td><td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj4ArIGBSSZ2VDcXv-gOkj5f-49Uxpl682Jn5kNIBw-gGkrmsg"/></td></tr>
		<tr><td>item1</td><td>description</td><td>price</td><td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj4ArIGBSSZ2VDcXv-gOkj5f-49Uxpl682Jn5kNIBw-gGkrmsg"/></td></tr>
		<tr><td>item1</td><td>description</td><td>price</td><td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj4ArIGBSSZ2VDcXv-gOkj5f-49Uxpl682Jn5kNIBw-gGkrmsg"/></td></tr>
		</table>
	</div>
	
	<h2>Top 10 items</h2>
	<table class="class">
		<tr><th>Items</th><th>Sold</th></tr>
		<tr><td>item1</td><td>sold1</td></tr>
		<tr><td>item1</td><td>sold1</td></tr>
	</table>

</div>

<jsp:include page="bottom.jsp" />
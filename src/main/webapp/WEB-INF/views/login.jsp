<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="Login" />
</jsp:include>


<h1>Login Form:</h1>
<form action="welcome" method="post" class="form-horizontal">
	<input type="text" value="" placeholder="Enter WeChat Number"
		class="form-control;col-xs-3" name="wechatnumber"> <br /> <br />
	<input type="password" value="" placeholder="Enter Password"
		class="form-control;col-xs-3" name="password"> <br /> <br />
	<input type="submit" value="Login" class="btn btn-lg btn-primary">
</form>

<jsp:include page="bottom.jsp" />
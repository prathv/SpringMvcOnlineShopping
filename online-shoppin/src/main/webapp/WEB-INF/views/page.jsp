<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<p>${contextRoot}</p>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Awesome - ${title}</title>
<script>
	window.menu = '${title}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>
<div class="wrapper">

	<body>

		<%@ include file="./shared/navbar.jsp"%>
		<div class="content">
			<!-- Page Content  -->
			<c:if test="${userClickHome == true}">
				<%@ include file="./home.jsp"%>
			</c:if>


			<c:if test="${userClickAbout == true}">
				<%@ include file="./about.jsp"%>
			</c:if>

			<c:if test="${userClickCategoryProducts == true or userClickAllProducts == true}">
				<%@ include file="./listProducts.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@ include file="./contact.jsp"%>
			</c:if>
		</div>
		
		<div class="container footer">
		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>
		</div>
	</body>
</div>
</html>

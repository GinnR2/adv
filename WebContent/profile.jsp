<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Profile</title>


<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>





<link rel="stylesheet" href="css/index.css">




</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<div id="content-wrap">


		<div class="container-fluid" style="max-width: 960px; margin: 0 auto">
			<div class="row">
				<div id="productCards"></div>
			</div>
		</div>

		
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>



	<script src="js/profile.js"></script>
</body>
</html>
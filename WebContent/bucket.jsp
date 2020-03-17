<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>



<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/bucket.css">


<title>Index.jsp corp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="content-wrap">
		<div class="row" style="max-width:960px;margin: 0 auto">
					
				<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">

				<table id="myTable">
				  <tr class="header">
				    <th style="width:60%;">Name</th>
				    <th style="width:40%;">Country</th>
				  </tr>
				  
				</table>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- <script src="js/index.js"></script> -->
	<script src="js/bucket.js"></script>


</body>
</html>
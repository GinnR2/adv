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


<title>Index.jsp corp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>



	<form class="create_product" style="max-width: 960px; margin: 0 auto">
		<div class="form-group">
			<label for="p_name">Product Name</label> <input type="text"
				class="form-control p_name" placeholder="Name">
		</div>
		<div class="form-group">
			<label for="p_desc">Product description</label> <input type="text"
				class="form-control p_desc" placeholder="Desc">
		</div>
		<div class="form-group">
			<label for="price">Price</label> <input type="text"
				class="form-control price" placeholder="0.00">
		</div>
		<div class="form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Check me
				out</label>
		</div>
		<button type="button" class="btn btn-primary create">Create</button>
		<br>
		<div class="alert alert-warning">
			<strong>Success!</strong>
		</div>
	</form>



	<div id="content-wrap"></div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="js/ajax.js"></script>



</body>
</html>
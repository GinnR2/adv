<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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



		<div class="container-fluid single-product"
			style="max-width: 960px; margin: 0 auto">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">${product.name}</h5>
						<h6 class="card-subtitle mb-2 text-muted">${product.price}</h6>
						<p class="card-text">${product.desc}</p>



						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#buyProductModal">buy product</button>
					</div>
				</div>
			</div>
		</div>



		<!-- Modal -->
		<div class="modal fade" id="buyProductModal" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Are You sure that You want to buy
						this product?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button type="button" product-id="${product.id}"
							class="btn btn-primary buy-product">Buy</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>



	<script src="js/ajax.js"></script>
</body>
</html>
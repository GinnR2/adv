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



<link rel="stylesheet" href="css/login.css">


<title>Index.jsp corp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>




	<div class="container py-5 plate" id="form">
		<div class="row">
			<div class="col-md-12">

				<div class="row">
					<div class="col-md-6 mx-auto">

						<div class="card border-secondary registerplate">
							<div class="card-header">
								<h3 class="mb-0 my-2">-</h3>
							</div>
							<div class="card-body">

								<form action='register' class="form" role="form"
									autocomplete="off">
									<div class="form-group">
										<label for="inputName">Name</label> <input type="text"
											class="form-control name" placeholder="full name">
									</div>
									<div class="form-group">
										<label for="inputName">Surname</label> <input type="text"
											class="form-control surname" placeholder="full surname">
									</div>
									<div class="form-group">
										<label for="inputEmail3">Email</label> <input type="email"
											class="form-control email" placeholder="email@gmail.com">
									</div>
									<div class="form-group">
										<label for="inputPassword3">Password</label> <input
											type="password" class="form-control password"
											placeholder="password"
											title="At least 6 characters with letters and numbers">
									</div>
									<div class="form-group">
										<label for="inputVerify3">Verify</label> <input
											type="password" class="form-control cpassword"
											placeholder="password (again)">
									</div>
									<div class="form-group">
										<button type="button"
											class="btn btn-success btn-lg float-right register">Register</button>
										<a href="#form" class="to tolog">To Login</a>
									</div>
								</form>

								<form action='login' class="form" role="form" autocomplete="off"
									id="login">

									<div class="form-group">
										<label for="inputEmail3">Email</label> <input type="email"
											class="form-control email" placeholder="email@gmail.com">
									</div>
									<div class="form-group">
										<label for="inputPassword3">Password</label> <input
											type="password" class="form-control password"
											placeholder="password"
											title="At least 6 characters with letters and numbers">
									</div>

									<div class="form-group">

										<button type="button"
											class="btn btn-success btn-lg float-right login">Login</button>
										<!-- <button type="button" class="btn btn-primary btn-lg float-right toreg">To Register</button> -->
										<a href="#form" class="to toreg">To Register</a>

									</div>
								</form>

								<div class="alert alert-warning">
									<strong>Success!</strong>
								</div>

							</div>
						</div>


					</div>
				</div>
				<!--/row-->

			</div>
			<!--/col-->
		</div>
		<!--/row-->
	</div>
	<!--/container-->

	<div id="content-wrap">
		<!-- all other page content -->
	</div>




	<jsp:include page="footer.jsp"></jsp:include>

	<script src="js/login.js"></script>
	


</body>
</html>
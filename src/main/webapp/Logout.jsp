<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<!-- Fixed Header -->
	<header class="bg-dark text-white text-center py-3 fixed-top">
		<div class="row">
			<div class="col-3 d-flex align-items-center">
			<img src="resources/statics/zz.jpg" alt="Company Logo"
				class="img-fluid rounded-circle ms-5" style="max-width: 60px">			
			</div>
			
			<div class="col-sm-8 mt-3 d-flex justify-content-end">
			  <a href="${pageContext.request.contextPath}/gotoLoginPage" class="btn btn-primary me-3">Login</a>
			</div>
		</div>
	</header>
	
	
		<!-- Main Content -->
	<section style = "margin-top:97px; margin-bottom:20px">
		<div class="container mt-5">
			<h1>you have logged out successfully</h1>
			<h1> please login again...</h1>
			<h1>Thank you!</h1>
		</div>
	</section>
	
	
	
	<!-- Fixed Footer -->
	<footer class="bg-dark text-white text-center py-3 fixed-bottom">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
</body>
</html>
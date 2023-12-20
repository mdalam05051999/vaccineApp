<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body class = "bg-body-secondary">
	<!-- Fixed Header -->
	<header class="bg-dark text-white text-center py-3 fixed-top">
		<div class="row">
			<div class="col-3 d-flex align-items-center">
			<img src="resources/statics/zz.jpg" alt="Company Logo"
				class="img-fluid rounded-circle ms-5" style="max-width: 60px">			
			</div>
			
			<div class="col-sm-8 mt-3 d-flex justify-content-end">
			  <a href="gotoregisterPage" class="btn btn-primary me-3">Register</a>
			</div>
		</div>
	</header>
	
	<!-- Main Content -->
	<section style = "margin-top:97px; margin-bottom:20px">
		<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <h2 class="mb-4">Login Form</h2>
             <h4 class = "text-danger">${no}</h4>
            <form action = "${pageContext.request.contextPath}/getLoginData">
                <label class="form-label" for = "emailid">Email</label>
                <input type="text" name="email" value="" class="form-control" id="emailid" placeholder="Enter Your Email" required><span id="emailError" style="color: red;"></span>
                
                <br>
                <label class="form-label" for = "password">Password</label>
                <input type="password" name="password" value="" class="form-control" id="password" placeholder="Enter Password" required><span id="passwordError" style="color: red;"></span>
    			
    			<br>
    			<input type="submit" value="Submit" class="btn btn-primary m-2" onclick = "return validateform()">
    			<span style = "margin:20px">Don't have an account? <a href="gotoregisterPage">Register here</a></span>
    			<span style = "margin:115px; margin-bottom:50px">Forgot Password? <a href="gotoResetPassword">Reset</a></span>
            </form>
        </div>
    </div>
</div>
	</section>
	
	<!-- Fixed Footer -->
	<footer class="bg-dark text-white text-center py-3 fixed-bottom">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
    
    
    
    
    <script src = "resources/Login.js"></script>
</body>
</html>
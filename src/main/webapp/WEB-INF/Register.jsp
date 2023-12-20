<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" 
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />	
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
			  <a href="gotoLoginPage" class="btn btn-primary">Login</a>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<section style = "margin-top:97px; margin-bottom:20px">
		<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <h2 class="mb-4">Registration Form</h2>
            <h4 class = "text-success">${responseMessage}</h4>
            <h4 class = "text-danger">${eresponseMessage}</h4>
            <h4 class = "text-success">${emailresponseMessage}</h4>
            <h4 class = "text-danger">${emailErrorresponseMessage}</h4>
            <form action = "saveRegisterEntity">
                <label class="form-label" for = "username">Username</label>
                <input type="text" name="username" value="" class="form-control" id="username" placeholder="username" required><span id="usernameError" style="color: red;"></span>
                
                <br>
                <label class="form-label" for = "emailid">Email</label>
                <input type="text" name="email" value="" class="form-control" id="emailid" placeholder="Enter Your Email" required><span id="emailError" style="color: red;"></span>
                
                <br>
                <label class="form-label" for = "password">Password</label>
                <input type="password" name="password" value="" class="form-control" id="password" placeholder="Enter Password" required><span id="passwordError" style="color: red;"></span>
                
                <br>
                <label class="form-label" for = "confirmPassword">Confirm Password</label>
                <input type="password" name="confirmPassword" value="" class="form-control" id="confirmPassword" placeholder="Confirm Your Password"  required><span id="confirmPasswordError" style="color: red;"></span>
                
                <br>
                <label class="form-label" for = "mobileNumber">Mobile Number</label>
                <input type="text" name="mobileNumber" value="" class="form-control" id="mobileNumber" placeholder="Enter your Mobile Number" required><span id="mobileError" style="color: red;"></span>
                
                <br>
               <label class="form-label" for="gender">Gender</label><br><span id="genderError" style="color: red;"></span>
			    <div class="form-check">
			        <input class="form-check-input" type="radio" name="gender" id="male" value="male" required>
			        <label class="form-check-label" for="male">Male</label>
			    </div>
			    <div class="form-check">
			        <input class="form-check-input" type="radio" name="gender" id="female" value="female" required>
			        <label class="form-check-label" for="female">Female</label>
			    </div>
			    <div class="form-check">
			        <input class="form-check-input" type="radio" name="gender" id="other" value="other" required>
			        <label class="form-check-label" for="other">Other</label>
			    </div>

   			 <label class="form-label" for="dob">Date Of Birth</label><br><span id="dobError" style="color: red;"></span>
    			<input type="date" name="dob" class="form-control" id="dob" required>
    			
    			<input type="submit" value="Register" class="btn btn-primary m-2" onclick = "return validateform()">
    			<span style = "margin:20px">Already have an account? <a href="gotoLoginPage">Login here</a></span>
            </form>
        </div>
    </div>
</div>
	</section>

	<!-- Fixed Footer -->
	<footer class="bg-dark text-white text-center py-3">
		<p>&copy; 2023 Your Website. All rights reserved.</p>
	</footer>
	
	<script src = "resources/Register.js"></script>
</body>
</html>
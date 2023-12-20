<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	
	<link href="resources/Welcome.css" rel="stylesheet" type="text/css">	
</head>
<body style = "background-color:#D6EAF8">
    <!-- Fixed Header -->
	<header class="bg-dark text-white text-center py-3 fixed-top">
		<div class="row">
			<div class="col-3 d-flex align-items-center">
			<img src="resources/statics/zz.jpg" alt="Company Logo"
				class="img-fluid rounded-circle ms-5" style="max-width: 60px">			
			</div>
			<div class="col-sm-8 mt-3 d-flex justify-content-end">
			  <a href="gotoregisterPage" class="btn btn-primary me-3">Register</a>
			  <a href="gotoLoginPage" class="btn btn-primary">Login</a>
			</div>
		</div>
	</header>

    <!-- Main Content -->
	<section style="margin-top: 50px">
		
		<marquee class = "mt-5 text-danger"><strong>The COVID-19 virus may survive on surfaces for several hours, but simple disinfectants can kill it. Virus can be transmitted to others from someone who is infected but not showing symptoms. Together, we can slow the spread of COVID-19 by making a conscious effort to keep a physical distance between each other.</strong></marquee>
		
		<h1 class = "welcome" style = "color:#660033; font-family:bolder; font-style:italic">Welcome</h1>

		<div class="slideshow-container">

			<div class="mySlides fade">
				<div class="numbertext">1 / 3</div>
				<img src="resources/statics/doctor.jpg" style="width: 100%; height: 30vh">
				<div class="text">Caption Text</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">2 / 3</div>
				<img src="resources/statics/research.jpg" style="width: 100%; height: 30vh">
				<div class="text">Caption Two</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">3 / 3</div>
				<img src="resources/statics/vaccine.jpg" style="width: 100%; height: 30vh">
				<div class="text">Caption Three</div>
			</div>
			
			<div class="mySlides fade">
				<div class="numbertext">4/ 5</div>
				<img src="resources/statics/covishield.jpg" style="width: 100%; height: 30vh">
				<div class="text">Caption Four</div>
			</div>
			
			<div class="mySlides fade">
				<div class="numbertext">5 / 6</div>
				<img src="resources/statics/covaxin.jpg" style="width: 100%; height: 30vh">
				<div class="text">Caption Five</div>
			</div>
			
			<div class="mySlides fade">
				<div class="numbertext">5 / 6</div>
				<img src="resources/statics/sputnikv.jpg" style="width: 100%; height: 30vh">
				<div class="text">Caption Six</div>
			</div>

		</div>
		<br>

		<div style="text-align: center">
			<span class="dot"></span> 
			<span class="dot"></span> 
			<span class="dot"></span> 
			<span class="dot"></span> 
			<span class="dot"> </span>
			<span class="dot"></span>
		</div>
	</section>
	
	<section>
		<div class="card ms-4 mt-4 bg-warning" style="width: 87rem; height: 28vh">
		  <div class="card-body">
		    <h5 class="card-title text-danger">TAP ACADEMY</h5>
		    <p class="card-text">-> This Vaccination drive is conducting by Tap Academy so Please Create an account and Add four family Member then Come for vaccination on exact date which the date will send to you by Mail and through call.</p>
		    <Strong class="card-text"># Before Coming for vaccine follow these instructions.</Strong>
		    <p class="card-text">1) Masks should be used as part of a comprehensive strategy of measures to suppress transmission and save lives; the use of a mask alone is not sufficient to provide an adequate level of protection against COVID-19.</p>
		    <p class="card-text">2) Strict precautions are in place to help ensure the safety of all COVID-19 vaccines. <a href = "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public">Know More</a></p>
		  </div>
		</div>
	</section>
	
	


	<footer class="bg-dark text-white text-center py-3 fixed-bottom">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
    
    <script src = "resources/Welcome.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
   <%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
  %>

    
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
	
	<link href="resources/HomePage.css" rel="stylesheet" type="text/css">	
	
</head>
<body>
	
	<!-- Fixed Header -->
	<header class="bg-dark text-white text-center py-3 fixed-top">
		<div class="row">
			<div class="col-3 d-flex align-items-center">
			<img src="resources/statics/zz.jpg" alt="Company Logo"
				class="img-fluid rounded-circle ms-5" style="max-width: 60px">	
			<a href="addMember" class="btn btn-success ms-5">AddMember</a>			
		</div>
			<form action = "logout" class="col-sm-8 mt-3 d-flex justify-content-end">
			  <strong class="bg-color me-3"><%=session.getAttribute("userEmail")%></strong>
			 	 <%
				    String userEmail = (String) session.getAttribute("userEmail");
				    if (userEmail == null || userEmail.equals("")) {
				    %>
				        <a href="${pageContext.request.contextPath}/WEB-INF/Login.jsp"></a>
				    <%
				    } else {
				    %>
				        <a href="javascript:go()" class="btn btn-primary">Logout</a>
				    <%
				    }
				  %>
			</form>
		</div>
	</header>
	
	<!-- Main Content -->
	<section class="card-container">
	
		<div class="card bg-warning border border-success border-2">
		  <img src="resources/statics/group.jpg" alt="Avatar">
		  <div class="container">
		    <h4 class = "mt-4"><b>You Have Added Member</b></h4> 
		    <h1 style="text-align:center"><c:out value="${memberCounts}" /></h1>
		  </div>
		</div>
		
		<div class="card bg-primary border border-warning border-2 text-white">
		  <img src="resources/statics/covaxin.jpg" alt="Avatar">
		  <div class="container">
		    <h4><b> Covishield</b></h4> 
		    <p>The Oxford AstraZeneca COVID-19 vaccine, sold under the brand names Covishield,The vaccine is stable at refrigerator temperatures and has a good safety profile. <a href = "https://en.wikipedia.org/wiki/Oxford%E2%80%93AstraZeneca_COVID-19_vaccine" class = "text-black">Know More</a></p> 
		  </div>
		</div>
		
		<div class="card border border-primary border-2">
		  <img src="resources/statics/covishield.jpg" alt="Avatar">
		  <div class="container">
		    <h4><b>Covaxin</b></h4> 
		    <p>Covaxin (development name, BBV152)is a whole inactivated virus-based COVID-19 vaccine developed by Bharat Biotech in collaboration with the Indian Council of Medical Research - National Institute of Virology. <a href = "https://en.wikipedia.org/wiki/Covaxin" class = "text-black">Know More</a></p> 
		  </div>
		</div>
		
		<div class="card bg-secondary border border-danger border-2 text-white">
		  <img src="resources/statics/sputnikv.jpg" alt="Avatar">
		  <div class="container">
		    <h4><b>Sputnik V</b></h4> 
		    <p>The vaccine can be formulated in two ways: as a ready-to-use solution in water that is frozen at the common home-freezer storage temperature of −18 °C or 0 °F or lower. <a href = "https://en.wikipedia.org/wiki/Sputnik_V_COVID-19_vaccine" class = "text-black">Know More</a></p> 
		  </div>
		</div>
		
		
		
	</section>
	
	
	
	<!-- Fixed Footer -->
	<footer class="bg-dark text-white text-center py-3 fixed-bottom">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
    
    <script src = "resources/Login.js"></script>
    
    
	<script>
	    function go() {
	        window.location.replace("${pageContext.request.contextPath}/logout");
	        alert("You have been logged out successfully!");
	    }
	</script>
   
</body>
</html>
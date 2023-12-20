<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddMember</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	
<link href="resources/Welcome.css" rel="stylesheet" type="text/css">	
</head>
<body class = "bg-body-secondary">
	<!-- Fixed Header -->
	<header class="bg-dark text-white text-center py-3 fixed-top">
		<div class="row">
			<div class="col-3 d-flex align-items-center">
			<img src="${pageContext.request.contextPath}/resources/statics/zz.jpg" alt="Company Logo"
				class="img-fluid rounded-circle ms-5" style="max-width: 60px">	
			<a href="${pageContext.request.contextPath}/getAllMember" class="btn btn-success ms-5" onclick = "toggleTable()">View Member</a>			
		</div>
	
				<div class="col-sm-8 mt-3 d-flex justify-content-end">
			  <a href="${sessionScope.originalUrl}" class="btn btn-primary">HOME Page</a>

			</div>
		
		</div>
	</header>
	
	<!-- Main Content -->
	<section style = "margin-top:97px; margin-bottom:20px">
		<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <h2 class="mb-4">Add  Member</h2>
             <h4 class = "text-success">${yes}</h4>
            <h4 class = "text-danger">${no}</h4>
            <form action = "saveAddMember">
            	<label class="form-label" for = "memberName">Member Name</label>
                <input type="text" name="memberName" value="" class="form-control" id="memberName" placeholder="Member Name" required><span id="memberNameError" style="color: red;"></span>
                
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
			    
			    <br>
   			 <label class="form-label" for="dob">Date Of Birth</label><br><span id="dobError" style="color: red;"></span>
    			<input type="date" name="dob" class="form-control" id="dob" required>
                
                 <br>
                <label class="form-label" for="idProof">ID Proof</label>
                <select name="idProof" id="idProof" class="form-select" required>
                    <option value="">Select ID Proof</option>
                    <option value="adhar_card">Adhar_Card</option>
                    <option value="pan_card">PANCard</option>
                    <option value="driving_licence">Driving_Licence</option>
                    <option value="passport">Passport</option>
                    <option value="voter_id_card">Voter_ID_Card</option>
                </select>
                <input type="text" name="idProofNo" value="" class="form-control" id="idProofNo" placeholder="Enter ID Number" required><span id="idProofNoError" style="color: red;"></span><span id="idProofError" style="color: red;"></span>
                <br>
                <label class="form-label" for="vaccineType">Vaccine Type</label>
                <select name="vaccineType" id="vaccineType" class="form-select" required>
                    <option value="">Select Vaccine Type</option>
                    <option value="covishield">Covishield</option>
                    <option value="covaxin">Covaxin</option>
                    <option value="sputnik_v">SputnikV</option>
                </select>
                <select name="dose" id="dose" class="form-select" required>
                    <option value="">Select Dose</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select><span id="doseError" style="color: red;"></span></select><span id="vaccineError" style="color: red;"></span>
                <input type="submit" value="Add" class="btn btn-success mt-2 form-control" onclick = "return validateform()">
            </form>
        </div>
    </div>
</div>
		
		<c:if test="${not empty allMember}">
			<table id = "addMemberTable" class="text-center table table-hover border border-warning border-1 mt-5 w-75 mx-auto w-auto">
				<thead>
					<tr>
						<th scope="col">MEMBER_ID</th>
						<th scope="col">MEMBER_NAME</th>
						<th scope="col">MEMBER_GENDER</th>
						<th scope="col">MEMBER_DOB</th>
						<th scope="col">MEMBER_IDPROOF</th>
						<th scope="col">MEMBER_IDPROOF_NO</th>
						<th scope="col">MEMBER_VACCINETYPE</th>
						<th scope="col">MEMBER_DOSE</th>
						<th scope="col">Delete</th>
						<th scope="col">Update</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach  var="allMembers" items="${allMember}">
							<tr>
							<th scope="row"><c:out value="${allMembers.memberID}" /></th>
							<td><c:out value="${allMembers.memberName}" /></td>
							<td><c:out value="${allMembers.memberGender}" /></td>
							<td><c:out value="${allMembers.memberDOB}" /></td>
							<td><c:out value="${allMembers.memberIdProof}" /></td>
							<td><c:out value="${allMembers.memberIdProofNo}" /></td>
							<td><c:out value="${allMembers.memberIVaccineType}" /></td>
							<td><c:out value="${allMembers.memberDose}" /></td>	
							<td><a href = "${pageContext.request.contextPath}/deleteMemberByIdProof/${allMembers.memberID}" class="btn btn-outline-danger" onclick = "return confirm('Are you sure? you want to delete this Member?')">Delete</a></td>
							<td><a href = "${pageContext.request.contextPath}/editMember/${allMembers.memberID}" class="btn btn-outline-warning">Update</a></td>						
						</tr>
						</c:forEach>
				</tbody>			
		</table>
		</c:if>
	</section>
	
	
	<!-- Fixed Footer -->
	<footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
    
    
    <!-- External Javascript -->
    <script src = "resources/AddMember.js"></script>
    
    
    <!-- Javascript for prevent back button -->
    <script>
			function toggleTable() {
				var table = document.getElementById("addMemberTable");
				table.style.display = (table.style.display === "none") ? "table" : "none";
			}
		</script>
		
		
	<!-- Javascript for Delete -->	
	<script>
			function toggleTable() {
				var table = document.getElementById("airportTable");
				table.style.display = (table.style.display === "none") ? "table" : "none";
			}
		</script>
    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit AddMember</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Welcome.css">	
</head>
<body>
	<!-- Fixed Header -->
	<header class="bg-dark text-white text-center py-3 fixed-top">
		<div class="row">
			<div class="col-3 d-flex align-items-center">
			<img src="${pageContext.request.contextPath}/resources/statics/zz.jpg" alt="Company Logo"
				class="img-fluid rounded-circle ms-5" style="max-width: 60px">				
		</div>
		</div>
	</header>
	
	<!-- Main Content -->
	<section style = "margin-top:97px; margin-bottom:20px">
		<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <h2 class="mb-4">Edit Add  Member</h2>
             <h4 class = "text-success">${yes}</h4>
            <h4 class = "text-danger">${no}</h4>
   <form action="${pageContext.request.contextPath}/updateMember/${memberID}" method="post">
    <label class="form-label" for="memberName">Member Name</label>
    <input type="text" name="memberName" value="${NAME}" class="form-control" id="memberName" placeholder="Member Name" required><span id="memberNameError" style="color: red;"></span>

    <br>
    <label class="form-label" for="gender">Gender</label><br><span id="genderError" style="color: red;"></span>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gender" id="male" value="male" ${GENDER == 'male' ? 'checked' : ''} required>
        <label class="form-check-label" for="male">Male</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gender" id="female" value="female" ${GENDER == 'female' ? 'checked' : ''} required>
        <label class="form-check-label" for="female">Female</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gender" id="other" value="other" ${GENDER == 'other' ? 'checked' : ''} required>
        <label class="form-check-label" for="other">Other</label>
    </div>

    <br>
    <label class="form-label" for="dob">Date Of Birth</label><br><span id="dobError" style="color: red;"></span>
    <input type="date" name="dob" class="form-control" id="dob" value="${DOB}" required>

    <br>
    <label class="form-label" for="idProof">ID Proof</label>
    <select name="idProof" id="idProof" class="form-select" required>
        <option value="">Select ID Proof</option>
        <option value="adhar_card" ${IDPROOF == 'adhar_card' ? 'selected' : ''}>Adhar_Card</option>
        <option value="pan_card" ${IDPROOF == 'pan_card' ? 'selected' : ''}>PANCard</option>
        <option value="driving_licence" ${IDPROOF == 'driving_licence' ? 'selected' : ''}>Driving_Licence</option>
        <option value="passport" ${IDPROOF == 'passport' ? 'selected' : ''}>Passport</option>
        <option value="voter_id_card" ${IDPROOF == 'voter_id_card' ? 'selected' : ''}>Voter_ID_Card</option>
    </select>
    <input type="text" name="idProofNo" value="${IDPROOFNO}" class="form-control" id="idProofNo" placeholder="Enter ID Number" required><span id="idProofNoError" style="color: red;"></span><span id="idProofError" style="color: red;"></span>

    <br>
    <label class="form-label" for="vaccineType">Vaccine Type</label>
    <select name="vaccineType" id="vaccineType" class="form-select" required>
        <option value="">Select Vaccine Type</option>
        <option value="covishield" ${VACCINETYPE == 'covishield' ? 'selected' : ''}>Covishield</option>
        <option value="covaxin" ${VACCINETYPE == 'covaxin' ? 'selected' : ''}>Covaxin</option>
        <option value="sputnik_v" ${VACCINETYPE == 'sputnik_v' ? 'selected' : ''}>SputnikV</option>
    </select>
    <select name="dose" id="dose" class="form-select" required>
        <option value="">Select Dose</option>
        <option value="1" ${DOSE == 1 ? 'selected' : ''}>1</option>
        <option value="2" ${DOSE == 2 ? 'selected' : ''}>2</option>
        <option value="3" ${DOSE == 3 ? 'selected' : ''}>3</option>
    </select><span id="doseError" style="color: red;"></span><span id="vaccineError" style="color: red;"></span>

    <input type="submit" value="Update" class="btn btn-success mt-2 form-control" onclick="return validateform()">
</form>


        </div>
    </div>
</div>
	</section>
	
	
	<!-- Fixed Footer -->
	<footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
    
    
    <!-- External Javascript -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/AddMember.js"></script>
</body>
</html>
function validateform() {
	var memberName = document.getElementById("memberName").value;
	var gender = document.querySelector('input[name="gender"]:checked');
	var dob = document.getElementById('dob').value;
	var idProof = document.getElementById('idProof').value;
	var idProofNo = document.getElementById('idProofNo').value;
	var vaccineType = document.getElementById('vaccineType').value;
	var dose = document.getElementById('dose').value;




	//var memberNameRegex = /^[a-zA-Z]{3,30}$/; // This will match any string of at least 3 alphabetic characters




	var memberNameError = document.getElementById("memberNameError");
	var genderErrorSpan = document.getElementById("genderError");
	var dobErrorSpan = document.getElementById("dobError");
	var idProofError = document.getElementById("idProofError");
	var idProofNoError = document.getElementById("idProofNoError");
	var vaccineError = document.getElementById("vaccineError");
	var doseError = document.getElementById("doseError");




	var isValid = true;

	// Validate memberName
	if (!memberName) {
		memberNameError.textContent = "Name should not be Empty";
		isValid = false;
	} else {
		memberNameError.textContent = "";
	}

	//Validate Gender
	if (!gender) {
		genderErrorSpan.textContent = "Please select a gender.";
		isValid = false;
	}
	else {
		genderErrorSpan.textContent = "";
	}

	//Validate DOB
	if (!dob) {
		dobErrorSpan.textContent = "Please select a date of birth.";
		isValid = false;
	}
	else {
		dobErrorSpan.textContent = "";
	}

	//Validate idProof
	if (idProof.value === null) {
		idProofError.textContent = "Please select IDProof and Enter ID Number.";
		isValid = false;
	}
	else {
		idProofError.textContent = "";
	}

	//Validate idProofNo
	if (!idProofNo) {
		idProofNoError.textContent = "Please select IDProof and Enter ID Number.";
		isValid = false;
	}
	else {
		idProofNoError.textContent = "";
	}

	// Validate vaccineType
	if (!vaccineType) {
		vaccineError.textContent = "Please select Vaccine Type and Select Dose.";
		isValid = false;
	} else {
		vaccineError.textContent = "";
	}

	//Validate dose
	if (!dose) {
		doseError.textContent = "Please select VaccineType and Select Dose.";
		isValid = false;
	}
	else {
		doseError.textContent = "";
	}


	return isValid;
}
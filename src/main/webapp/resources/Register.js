function validateform() {
        var username = document.getElementById("username").value;
        var email = document.getElementById("emailid").value;
        var mobileNumber = document.getElementById("mobileNumber").value;
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        var gender = document.querySelector('input[name="gender"]:checked');
        var dob = document.getElementById('dob').value;
        
        var usernameRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var mobileRegex = /^[0-9]{10}$/;
        var passwordRegex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$/;

        var usernameErrorSpan = document.getElementById("usernameError");
        var emailErrorSpan = document.getElementById("emailError");
        var mobileErrorSpan = document.getElementById("mobileError");
        var passwordErrorSpan = document.getElementById("passwordError");
        var confimPasswordErrorSpan = document.getElementById("confirmPasswordError");
        var genderErrorSpan = document.getElementById("genderError");
        var dobErrorSpan = document.getElementById("dobError");
        

        var isValid = true;

        // Validate Username
        if (!usernameRegex.test(username)) {
            usernameErrorSpan.textContent = "Please enter a valid username including @gmail.com";
            isValid = false;
        } else {
            usernameErrorSpan.textContent = "";
        }

        // Validate Email
        if (!emailRegex.test(email)) {
            emailErrorSpan.textContent = "Please enter a valid Email including @gmail.com";
            isValid = false;
        } else {
            emailErrorSpan.textContent = "";
        }

        // Validate Mobile Number
        if (!mobileRegex.test(mobileNumber)) {
            mobileErrorSpan.textContent = "Please enter 10 digit valid Mobile Number.";
            isValid = false;
        } else {
            mobileErrorSpan.textContent = "";
        }
        
        //Validate Password
        if(!passwordRegex.test(password))
        {
        	passwordErrorSpan.textContent = "Password must contain one digit from 1 to 9, one lowercase letter, one uppercase letter, and it must be 8-16 characters long."
        	isValid = false;
        } else{
        	passwordErrorSpan.textContent = "";
        }
        
        //Validate Confirm Password
        if(password != confirmPassword)
        {
        	confimPasswordErrorSpan.textContent = "Passwords does not match.";
        	isValid = false;
        }
        else{
        	confimPasswordErrorSpan.textContent = "";
        }
        
      	//Validate Gender
      	if(!gender)
    	{
      		genderErrorSpan.textContent = "Please select a gender.";
      		isValid = false;
    	}
      	else{
      		genderErrorSpan.textContent = "";
        }
      	
      //Validate DOB
      if(!dob)
    	{
    	  dobErrorSpan.textContent = "Please select a date of birth.";
      		isValid = false;
    	}
      	else{
      		dobErrorSpan.textContent = "";
        }
      	

        return isValid;
    }
function validateform()
    {
    	var email = document.getElementById("emailid").value;
    	var password = document.getElementById('password').value;
    	
    	var emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    	var passwordRegex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$/;
    	
    	var emailErrorSpan = document.getElementById("emailError");
    	var passwordErrorSpan = document.getElementById("passwordError");
    	
    	 var isValid = true;
    	 
    	  // Validate Email
            if (!emailRegex.test(email)) {
                emailErrorSpan.textContent = "Please enter a valid Email including @gmail.com";
                isValid = false;
            } else {
                emailErrorSpan.textContent = "";
            }
            
            //Validate Password
            if(!passwordRegex.test(password))
            {
            	passwordErrorSpan.textContent = "Password must contain one digit from 1 to 9, one lowercase letter, one uppercase letter, and it must be 8-16 characters long."
            	isValid = false;
            } else{
            	passwordErrorSpan.textContent = "";
            }
            
            return isValid;
    }
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Sign Up</title>

    <SCRIPT TYPE="text/javascript">

	function clearStatus() { status = ""; }

	function checkRegistration() {
		var login = document.registerForm.login;
		if (login.value == "") {
			alert("Missing login.");
		return(false);
		}
		if (login.value.length < 2) {
			alert("Wrong login length.");
		return(false);
        }
		var password = document.registerForm.password;
		if (password.value == "") {
			alert("Missing password.");
		return(false);
		}
		if (password.value.length < 5) {
			alert("Wrong password length.");
		return(false);
        }
		var name = document.registerForm.name;
		if (name.value == "") {
			alert("Missing name.");
		return(false);
		}
		if (name.value.length < 2) {
			alert("Wrong name length.");
		return(false);
        }
		var lastname = document.registerForm.lastname;
		if (lastname.value == "") {
			alert("Missing lastname.");
		return(false);
		}
		if (lastname.value.length < 2) {
			alert("Wrong lastname length.");
		return(false);
        }

		var email = document.registerForm.email;
		if (email.value == "") {
			alert("Missing email.");
		return(false);
		}

        if ( !/^[a-zA-Z][a-zA-Z0-9._-]*@[a-zA-Z][a-zA-Z0-9._-]*\.[a-zA-Z][a-zA-Z0-9]*$/.test(email.value) ) {
				alert("Wrong email format.");
			return(false);
		}
		var phone = document.registerForm.phone;
		if (phone.value == "") {
			alert("Missing phone.");
		return(false);
		}
        if ( !/^(\+?7|8)\d{10}$/.test(phone.value) ) {
			alert("Wrong phone format.");
		return(false);
		}

  // Format looks OK. Submit form.
		return(true);
	}
	</SCRIPT>

    <style type="text/css">

	body {
    		height: 100%;
    		background: radial-gradient(circle farthest-corner at 100px 50px, aqua, darkblue ); //aqua, darkblue #FBF2EB, #352A3B
    		background-repeat: no-repeat;
    		background-size: cover;
    		background-attachment: fixed;
    	}

    	.box {
    		overflow: hidden;
    		position: absolute;
    		top: 0px;
    		left: 0px;
    		width: 100%;
    		height: 100%;
    		padding: 250px 600px;
    		cursor: move;
    		box-sizing: border-box;
    	}


	.h-form-item {
		position: relative;
		z-index: 100;
		font-size: 20px;
		margin-bottom: 5px; /* Отступ снизу */
	}

	.field {
		clear:both;
		text-align:right;
		line-height:25px;
	}
	.main {float:left}

	input{
		z-index: 100;
		font-family: "Roboto Slab", serif;
		font-size: 17px;
		width: 280px; /* Ширина блока с текстом */
		margin-left: 10px; /* Расстояние между полем и текстом */
		border: 1px solid #abadb3; /* Рамка вокруг текстового поля */
		border-radius: 4px;
		margin-bottom: 5px; /* Отступ снизу */
	}
	.field_signup{
		font-family: "Roboto Slab", serif;
		font-size: 17px;
		width: auto; /* Ширина блока с текстом */
		margin-left: 10px; /* Расстояние между полем и текстом */
		margin-top: 50px; /* Отступ снизу */
		text-align:right;
	}

	</style>
</head>
<body>
<div class = "box">
    <form action="" method="POST" NAME="registerForm" onSubmit="return(checkRegistration())">
        <div class="h-form-item">
            <div class="main">
                <div class="field">
                    <label for="login">Login :</label>
                    <input type="text" name="userlogin"  id="login" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="Password">Password :</label>
                    <input type="Password" name="password" id="password" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="name">Name :</label>
                    <input type="text" name="firstname" id="firstname" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="middlename">Middle Name :</label>
                    <input type="text" name="middlename" id="middlename" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="lastname">Last Name :</label>
                    <input type="text" name="lastname" id="lastname" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="birthday">birthday(yyyy-MM-dd):</label>
                    <input type="text" name ="birthday" id ="birthday" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="passport">Passport:</label>
                    <input type="text" name ="passport" id ="passport" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="passportorg">Organization:</label>
                    <input type="text" name ="passportorg" id ="passportorg" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="passportdate">Passport Data:</label>
                    <input type="text" name ="passportdate" id ="passportdate" onBlur="clearStatus()"/>
                </div>

                <div class="field">
                    <label for="email">E-mail :</label>
                    <input type="text" id="email" name="email" onBlur="clearStatus()"/>
                </div>
                <div class="field">
                    <label for="Phone">Phone :</label>
                    <input type="text" id ="Phone" name="telephone" onBlur="clearStatus()"/>
                </div>
                <div class="field_signup">
                    <input type="submit" value="Registration user" />
                    <br><br>
                     <input type="button" value="Admin Menu" onclick="window.location.href='/afterlogin';"/>
                     <h4><a href="/logout">Logout</a></h4>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>Sign Up</title>
	<style type="text/css">
  		<%@include file="main.css" %>
  		<%@include file="fonts/iconic/css/material-design-iconic-font.min.css" %>
    </style>

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" >
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="SignUpSubmit" method="post">
					

					<span class="login100-form-title p-b-34 p-t-27">
						Create Account
					</span>
					<br>

					<div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="fistName" placeholder="First Name">
						
					</div>
					
					<div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="lastName" placeholder="Last Name">
					</div>
					
					<div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="username" placeholder="UserId">
					</div>
					
					<div class="wrap-input100 validate-input" >
						<input class="input100" type="text" name="emailID" placeholder="Email Id">
					</div>

					<div class="wrap-input100 validate-input" >
						<input class="input100" type="password" name="setPassword" placeholder="Set Password">
					</div>
					
					<div class="wrap-input100 validate-input" >
						<input class="input100" type="password" name="confirmPassword" placeholder="Confirm Password">
					</div>

					<br>
					<div id="Error" style="display:none"> <%= request.getAttribute("error") %></div>
					
					<br><br>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							SIGN UP
						</button>
					</div>

					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<script type="text/javascript"> <%= request.getAttribute("errorDisplay") %> 
		
	</script>


</body>
</html>
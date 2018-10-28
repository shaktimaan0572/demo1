<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>Login Page</title>
	<style type="text/css">
  		<%@include file="main.css" %>
  		<%@include file="fonts/iconic/css/material-design-iconic-font.min.css" %>
    </style>
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" >
			<div class="wrap-login100" >
				<form class="login100-form validate-form">
					
					<span class="login100-form-title p-b-34 p-t-27" >
						UserId = <span id="username"><%= request.getAttribute("username") %> </span>
					</span>
					<br><br>
					
					<span class="login100-form-title p-b-34 p-t-27" >
						Choose the Game Mode
					</span>
					<br><br>
					
					<div class="container-login100-form-btn " >
						<button class="login100-form-btn" style="font-size: 22px;min-width: 258px;height: 70px;" formaction="SingleGame" formmethod="post">
							Single Player
						</button>
					</div>
					<br><br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" style="font-size: 22px;min-width: 258px;height: 70px;" formaction="Mutiplayer" formmethod="post">
							Multiplayer
						</button>
					</div>
					<br><br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" formaction="leaderBoard" formmethod="get">
							Go To LeaderBoard
						</button>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>


</body>
</html>
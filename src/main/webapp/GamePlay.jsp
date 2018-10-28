<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<title>Login Page</title>
	<style type="text/css">
  		<%@include file="main.css" %>
  		<%@include file="button.css" %>
  		<%@include file="fonts/iconic/css/material-design-iconic-font.min.css" %>
    </style>
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" >
			<div class="wrap-login100">
				<form class="login100-form validate-form" id="GameSubmitted" action="GameSubmit">
					
					<span class="login100-form-title p-b-34 p-t-27" >
						UserId: <%= request.getAttribute("username") %> 
					</span>
					
					<span class="login100-form-title p-b-34 p-t-27" >
						Your Score: <span id="score1">0</span>
					</span>
					
					<br><br>
					<span class="login100-form-title p-b-34 p-t-27" >
						Computer Score: <span id="score2">0</span>
					</span>
					
					<br><br>
					<span class="login100-form-title p-b-34 p-t-27" >
						<span id="player"></span>Your Point: <span id="point">0</span>
					</span>
					<br><br>
					<span class="login100-form-title p-b-34 p-t-27">
						<ul>
							<li>
							<span class="round green" id="RollDice" >Roll Dice<span class="round" >Dice Rolling.</span></span></li>
						</ul>						
					</span>
					
					<br><br>
					<span class="login100-form-title p-b-34 p-t-27">
						<span id="player"></span>Computer Point: <span id="point1">0</span>
					</span>
					<br><br>
					<span class="login100-form-title p-b-34 p-t-27">
						<span id="result"> </span>
					</span>
					<br><br>			
					<input type="hidden" name="result" id="result1" value="" />
					<input type="hidden" name="score1" id="score11" value="" />
					<input type="hidden" name="score2" id="score21" value="" />
					
					
					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<script type="text/javascript">
		var point=0;
		var yourscore=0;
		var opponentScore=0;
		var noOfRoll=3;
		
				//document.getElementById("point").innerHTML = 1+  Math.ceil(Math.random()*5) + "s";
			document.getElementById("RollDice").onclick = function()
			{	
				point=1+  Math.ceil(Math.random()*5);
				document.getElementById("point").innerHTML = point ;
				//document.getElementById("player").innerHTML = "Your " ;				
				yourscore+=point;
				document.getElementById("score1").innerHTML=yourscore;
				//document.getElementById("RollDice").click();				
				point=1+  Math.ceil(Math.random()*5);
				document.getElementById("point1").innerHTML = point ;
				//document.getElementById("player1").innerHTML = "Computer " ;
							
				opponentScore+=point;
				document.getElementById("score2").innerHTML=opponentScore;
				
				noOfRoll--;
								
				if(noOfRoll==0){
					var string="";
				
					
					if(yourscore>opponentScore){
						string="YOU WIN";
						//document.getElementById("Gameresult").innerHTML=String;
					}
					else{
						string="YOU LOOSE";
						//document.getElementById("Gameresult").innerHTML=String;
					}
					document.getElementById("result").innerHTML=string;
					
					
					document.getElementById('result1').value = string;
					document.getElementById('score11').value = yourscore;
					document.getElementById('score21').value = opponentScore;
					
		
					document.getElementById("GameSubmitted").submit();
			}
				
				
			}
			
		
	</script>


</body>
</html>
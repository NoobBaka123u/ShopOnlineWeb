<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%if(request.getAttribute("message")!=null) %>
	<div class="container">
		<div class="account">
			<h2 class="account-in">Register</h2>
			<%=request.getAttribute("message") %>
				<form action="register" method="post">
				<div>
				
					<span>First Name*</span>
					<input type="text" name="firstName">
				</div> 	
				<div>			
					<span class="name-in">Last Name*</span>
					<input type="text" name="lastName"> 
				</div>			
				<div> 	
					<span class="mail">Email*</span>
					<input type="text" name="email"> 
				</div>
				<div> 	
					<span class="username">Username*</span>
					<input type="text" name="username"> 
				</div>
				<div> 
					<span class="word">Password*</span>
					<input type="password" name="password">
				</div>				
					<input type="submit" value="Register"> 
				</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
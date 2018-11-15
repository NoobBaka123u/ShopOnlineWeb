<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<div class="account">
			<h2 class="account-in">Account</h2>
				<form action="login" method="post">
				<div>
					<span>Username</span>
					<input type="text" name="username">
				</div> 	
				
				<div> 
					<span class="word">Password</span>
					<input type="password" name="password">
				</div>				
					<input type="submit" value="Login"> 
					
				</form>
				<a href="register">Create new account</a>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
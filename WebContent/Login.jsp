<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Plasma Donation - Covid19</title>

<!-- Importing external CSS file -->
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>

 <!-- Importing Header JSP -->
                  
<jsp:include page="LoginHeader.jsp" /> 

<!-- 
<h3>login </h3>
 -->



    <!-- Creating Login Form -->
 
  <form action="login" method="post">
 
  <div class="container" style="width: 50%;">
    <label for="uname"><b>Email</b></label>
    <input type="text" placeholder="Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password"  placeholder=" Password" name="password" required>
        
    <button type="submit" class="btn btn-success">Login</button>
    <p>New User? <a class="register-link" href="Register.jsp">Register</a></p>
  </div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User HomePage</title>

<!-- Importing BootStrap via CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <!-- Importing External CSS -->
<link rel="stylesheet" href="Header.css">

<script type="text/javascript">
    history.pushState(null, null, location.href);
    history.back();
    history.forward();
    window.onpopstate = function () { history.go(1); };
</script>
</head>
<body>


<!-- Retriving UserName from Session Object -->

<%

String user = null;
  
 user = (String) session.getAttribute("userName");
 if(user == null){
	 user = "userName";
 }

%>


<!-- Top Header for User and Admin -->
<div class="row">
  <div class="logo">
  <a href="#"><img alt="logo" src="img/UCM.png" width="250" height="100"></a>
  </div>
  <div class="navbar">
     <a href="#" style="font-size: 35px;color: white;text-decoration: none;padding-left: 10px">University of Central Missouri</a>
    <div class="navbar-right" style="padding-right: 20px">
    <a href="#" style="color: white;text-decoration: none;padding-right: 60px">Plasma Donation of Covid-19</a>
    <a href="#" style="color: white;text-decoration: none;padding-right: 40px"><%=user %></a>
    <a href="LandingPage.jsp" style="color: white;text-decoration: none;">Logout</a>
    </div>
  </div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Header</title>

<!-- Improting Bootstrap via CDN -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <!-- Importing CSS -->  
   
<link rel="stylesheet" href="Header.css">

<script type="text/javascript">
    history.pushState(null, null, location.href);
    history.back();
    history.forward();
    window.onpopstate = function () { history.go(1); };
</script>
</head>
<body>

<!--  Navigation bar -->

<div class="row">
  <div class="logo">
  <a href="LandingPage.jsp"><img alt="logo" src="img/UCM.png" width="250" height="100"></a>
  </div>
  <div class="navbar">
     <a href="LandingPage.jsp" style="font-size: 35px;color: white;text-decoration: none;padding-left: 10px">University of Central Missouri</a>
    <div class="navbar-right" style="padding-right: 20px">
    <a href="#" style="color: white;text-decoration: none;padding-right: 40px">Plasma Donation of Covid-19</a>
    <a href="Login.jsp" style="color: white;text-decoration: none;">Login</a>
    </div>
  </div>
</div>
</body>
</html>
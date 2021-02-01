<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>

<!-- Importing external css -->

<link rel="stylesheet" href="Main.css">
</head>
<body>

<!-- Importing header jsp -->

<jsp:include page="MainHeader.jsp" />  


<!-- Side Navigation bar -->

<div class="row">
  <div class="column_left">
   <ul>
  <li><a class="link " href="AffectedGraph.jsp">Affected & Recovered Students & Staff Statistics</a></li>
  <li><a class="link" href="RequestPlasmaGraph.jsp">Request Plasma Users Statistics</a></li>
  <li><a class="link" href="DonatePlasmaGraph.jsp">Donate Plasma Users Statistics</a></li> 
  <li><a class="link active" href="">Contact us</a></li> 
  <li><a class="link" href="Precautions.jsp">Precautions to be taken</a></li> 
  <li><a class="link" href="FAQ.jsp">FAQs related to Plasma</a></li> 
</ul>
  </div>
  <div>
  
  
<!-- Contact Information display -->  
  
  <div>
   <h1><b><font  style="padding-left: 400px">Contact Information </font></b></h1>
   <div class="row" style="padding-top: 50px">
  <div class="column column-contact-left">
                   <p style="padding-left: 40px;font-weight: bold;"><u><font>MAIL:</font></u></p>
                  <p >P.O.Box  800</p>
                   <p>Warrensburg,  MO 64093</p>
  </div>
  <div class="column column-contact-middle" >
   <p style="padding-left: 10px;font-weight: bold;"><u><font>Phone Numbers:</font></u></p>
        <p>877-729-8266</p>
        <p>660-543-4111</p>
  </div>
  <div class="column column-contact-right"  >
    <p style="padding-left: 60px;font-weight: bold;"><u><font>Email:</font></u></p>
    <p>ucmplasmadonation@gmail.com</p>
  </div>
</div>
 
 </div>
  
  </div>
  </div>
</body>
</html>
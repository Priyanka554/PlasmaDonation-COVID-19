<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Landing Page</title>

<!-- Importing External CSS -->
<link rel="stylesheet" href="Main.css">

</head>
<body>

<!-- Importing header jsp -->
<jsp:include page="MainHeader.jsp" />  


<!-- Side Navigation bar -->

<div class="row">
  <div class="column_left">
   <ul>
  <li><a class="link" href="AffectedGraph.jsp">Affected & Recovered Students & Staff Statistics</a></li>
  <li><a class="link" href="RequestPlasmaGraph.jsp">Request Plasma Users Statistics</a></li>
  <li><a class="link" href="DonatePlasmaGraph.jsp">Donate Plasma Users Statistics</a></li> 
  <li><a class="link" href="ContactUs.jsp">Contact us</a></li> 
  <li><a class="link" href="Precautions.jsp">Precautions to be taken</a></li> 
  <li><a class="link" href="FAQ.jsp">FAQs related to Plasma</a></li> 
</ul>
  </div>
  
  
  
<!-- Video Play -->
 <div >
  <iframe src="https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fwww.facebook.com%2FUCentralMO%2Fvideos%2F653266625588717%2F&show_text=false&width=560&autoplay=1"
   width="900" 
   height="600" 
   style="border:none;margin-left:60px !important;
   overflow:hidden" scrolling="no" frameborder="0" allowfullscreen="true" autoplay="true"; clipboard-write; encrypted-media; picture-in-picture; web-share" allowFullScreen="true"></iframe>
 </div>
  </div>
</body>
</html>
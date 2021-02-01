<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <!-- Importing packages of sql -->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Plasma Graph</title>

<!-- Importing External CSS -->

<link rel="stylesheet" type="text/css" href="Admin.css">

<!-- Importing BootStrap -->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
 
 
 <!-- JavaScript code for displaying Graph --> 
 
  <script type="text/javascript">
  google.charts.load('current', {'packages':['bar']});
  google.setOnLoadCallback(drawChart);
  function drawChart() {
	  
	  <!-- Ajax call for fetching data -->
	  
    var jsonData = $.ajax({
      url: "requestplasmagraph",
      dataType:"json",
      async: false
      }).responseText;
     
    // Create our data table out of JSON data loaded from server.
    
    var data = new google.visualization.DataTable();
    console.log(jsonData)
    data.addColumn('string', 'Date');
        data.addColumn('number', 'Count');
         for (var prop in JSON.parse(jsonData)) {
        	 
        	 data.addRow([prop,JSON.parse(jsonData)[prop]]);
        	}

         if (data.getNumberOfRows() == 0) {
        	 $("#covid-cases").append("Sorry, not data available")
         } 
         else {

    var chart = new google.charts.Bar(document.getElementById('covid-cases'));

    var options = {
            bar: { groupWidth: '85%' },
            chart: {
              title: 'Request Plasma Graph',  
            }
          };

    chart.draw(data, options);
         }
  }

    </script>
</head>
<body>

<!-- Importing header jsp -->

<jsp:include page="MainHeader.jsp" />

<!-- Side Navigation bar -->

<div class="row">
  <div class="column_left">
   <ul>
  <li><a class="link " href="AffectedGraph.jsp">Affected & Recovered Students & Staff Statistics</a></li>
  <li><a class="link active" href="">Request Plasma Users Statistics</a></li>
  <li><a class="link" href="DonatePlasmaGraph.jsp">Donate Plasma Users Statistics</a></li> 
  <li><a class="link" href="ContactUs.jsp">Contact us</a></li> 
  <li><a class="link" href="Precautions.jsp">Precautions to be taken</a></li> 
  <li><a class="link" href="FAQ.jsp">FAQs related to Plasma</a></li> 
</ul>
  </div>
  
  <!-- Graph -->
  <div>
   <div id="covid-cases" style="width: 500px; height: 500px;padding-left: 100px;"></div>
  </div>
  </div>
</body>
</html>
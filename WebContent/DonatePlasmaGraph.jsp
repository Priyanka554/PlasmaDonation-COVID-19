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
<title>Donate Plasma Graph</title>

<!-- Importing External CSS -->

<link rel="stylesheet" type="text/css" href="Admin.css">

<!-- Importing BootStrap and AJAX via CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
  
  
  <!-- JavaScript code for Google Chart for display bar graph -->
  
  <script type="text/javascript">
  google.charts.load('current', {'packages':['bar']});
  google.setOnLoadCallback(drawChart);
  function drawChart() {
    
    var jsonData = $.ajax({
      url: "donateplasmagraph",
      dataType:"json",
      async: false
      }).responseText;

<!--  Sorting Data
    const orderedJsonData = {};
    Object.keys(JSON.parse(jsonData)).sort().forEach(function(key) {
    	orderedJsonData[key] = orderedJsonData[key];
    });
    console.log(orderedJsonData)
    -->
     
    // Create our data table out of JSON data loaded from server.
   
    var data = new google.visualization.DataTable();
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
              title: 'Donate Plasma Graph',  
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
  <li><a class="link" href="RequestPlasmaGraph.jsp">Request Plasma Users Statistics</a></li>
  <li><a class="link active" href="">Donate Plasma Users Statistics</a></li> 
  <li><a class="link" href="ContactUs.jsp">Contact us</a></li> 
  <li><a class="link" href="Precautions.jsp">Precautions to be taken</a></li> 
  <li><a class="link" href="FAQ.jsp">FAQs related to Plasma</a></li> 
</ul>
  </div>
  
  <!-- Bar Graph Display -->
  <div>
   <div id="covid-cases" style="width: 500px; height: 500px;padding-left: 100px;"></div>
  </div>
  </div>
</body>
</html>
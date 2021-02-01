<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main menu</title>

<!-- Importing External CSS -->

<link rel="stylesheet" href="Main.css">
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 
 <!-- Script for Graph using GoogleBar -->
 <script type="text/javascript">
google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Month', 'Covid-Cases'],
          ['Aug 28',42],
          ['Sep 04',136],
          ['Sep 11',76],
          ['Sep 18',26],
          ['Sep 25',29],
          ['Oct 02',34],
          ['Oct 09',24],
          ['Oct 16',16],
          ['Oct 25',13],
          ['Oct 30',14],
          ['Nov 06',16],
          ['Nov 13', 42],
          ['Nov 20', 35]

        ]);
      

        var options = {
          bar: { groupWidth: '85%' },
          chart: {
            title: 'Covid-Cases Graph',  
          }
        };

        var chart = new google.charts.Bar(document.getElementById('covid-cases'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
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
  <li><a class="link active" href="">Affected & Recovered Students & Staff Statistics</a></li>
  <li><a class="link" href="RequestPlasmaGraph.jsp">Request Plasma Users Statistics</a></li>
  <li><a class="link" href="DonatePlasmaGraph.jsp">Donate Plasma Users Statistics</a></li> 
  <li><a class="link" href="ContactUs.jsp">Contact us</a></li> 
  <li><a class="link" href="Precautions.jsp">Precautions to be taken</a></li> 
  <li><a class="link" href="FAQ.jsp">FAQs related to Plasma</a></li> 
</ul>
  </div>
  
  <!-- Graph Display -->
 <div>
  <div id="covid-cases" style="width: 1000px; height: 500px;padding-left: 100px;background-color: #F9FBE7 "></div>
 </div>
  </div>
</body>
</html>
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
<title>Donar Plasma List</title>

<!-- Importing External CSS -->

<link rel="stylesheet" type="text/css" href="Admin.css">

<!-- Importing BootStrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>


<!-- Reloading page -->



<!-- Importing header jsp -->
<jsp:include page="MainHeader.jsp" />

<!-- Side Navigation bar -->

<div class="row">
  <div class="column_left">
   <ul>
  <li><a class="link" href="AdminProfilePage.jsp">View Profile Page</a></li>
  <li><a class="link " href="RequestPlasmaList.jsp">View Request Plasma List</a></li>
  <li><a class="link active" href="">View Donate Plasma List</a></li> 
   <li><a class="link" href="UserDetails.jsp">User Details</a></li> 
      <li><a class="link" href="ContactUser.jsp">Contact User</a></li> 
</ul>
  </div>
  
  
  <!-- Configuring Database and retriving data from database and displaying in table -->
  
  <div class="container">
  <%
           
            String driver = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/plasmadonation";
            String userid = "root";
            String password = "root";
            try {
            Class.forName(driver);
            } catch (ClassNotFoundException e) {
                 e.printStackTrace();
            }
             Connection connection = null;
             Statement statement = null;
              ResultSet resultSet = null;
     %>
           <h3>Donar Plasma List</h3>
           <form action="deletedonateplasma" method="post">
          <table class="table table-bordered donar-table">
                 <tr>
                      <th>Select</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Email</th>
                      <th>Gender</th>
                      <th>Blood Group</th>
                      <th>Confirmed Test</th>
                      <th>Symptoms</th>
                      <th>Covid Test</th>
                      <th>Symptoms LastDate</th>
                       <th>CovidTest Before</th>
                  </tr>
                  <%
                     try{
                          connection = DriverManager.getConnection(connectionUrl, userid, password);
                          statement=connection.createStatement();
                          String sql ="select * from donar";
                           resultSet = statement.executeQuery(sql);
                           while(resultSet.next()){
                   %>
                     <tr>
                      <td><input type="checkbox" value="<%=resultSet.getString("email") %>" name="checkboxs"></td>
                        <td><%=resultSet.getString("firstname") %></td>
                        <td><%=resultSet.getString("lastname") %></td>
                        <td><%=resultSet.getString("email") %></td>
                        <td><%=resultSet.getString("gender") %></td>
                        <td><%=resultSet.getString("bloodgroup") %></td>
                        <td><%=resultSet.getString("confirmedtest") %></td>
                        <td><%=resultSet.getString("currentlysymptoms") %></td>
                        <td><%=resultSet.getString("CovidTest") %></td>
                        <td><%=resultSet.getString("LastDayofSymptom") %></td>
                        <td><%=resultSet.getString("lastdayofcovidbefore14days") %></td>
                    </tr>
                  <%
                         }
                         connection.close();
                         } catch (Exception e) {
                         e.printStackTrace();
                         }
                    %>
             </table>
             <div class="text-center">
             <button type="submit" class="btn btn-success">Delete Donate Request</button>
             </div>
             </form>
  
  </div>
  </div>
</body>
</html>
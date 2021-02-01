<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile Page</title>

<!-- Importing css -->
<link rel="stylesheet" type="text/css" href="Admin.css">
</head>
<body>



<!-- Retriving Data from session Object -->

<%
  String firstName = (String) session.getAttribute("firstName");
String lastName = (String) session.getAttribute("lastName");
String email = (String) session.getAttribute("email");
String streetAddress = (String) session.getAttribute("streetAddress");
String password = (String) session.getAttribute("password");
String addressLine1 = (String) session.getAttribute("addressLine1");
String city = (String) session.getAttribute("city");
String province = (String) session.getAttribute("province");
String gender = (String) session.getAttribute("gender");
String postalCode = (String) session.getAttribute("postalCode");
String country = (String) session.getAttribute("country");

%>



<!-- Importing Header JSP -->

 <jsp:include page="Header.jsp" />
 
 
 <!-- Send navigation bar -->
 
 <div class="row">
  <div>
   <ul style="height:600px">
  <li><a class="link active" href="#">View Profile Page</a></li>
  <li><a class="link" href="RequestPlasmaList.jsp">View Request Plasma List</a></li>
  <li><a class="link" href="DonarPlasmaList.jsp">View Donate Plasma List</a></li> 
   <li><a class="link" href="UserDetails.jsp">User Details</a></li> 
    <li><a class="link" href="ContactUser.jsp">Contact User</a></li> 
</ul>
  </div>
  
  <!-- Displaying data in table -->
  
  <div class="column">
  <h3 style="width: 600px !important;margin-left: 200px">Profile Details</h3>
  <form action="updateuser" method="post">
  <table style="width: 600px !important; margin-left: 200px;height: 400px;" class="center text-center">
   
  <tr>
    <th>First Name</th>
    <td><input type="text" class="form-control text-center" name="firstName" value="<%=firstName%>" required="required"></td>
  </tr>
  <tr>
    <th>Last Name</th>
    <td><input type="text" class="form-control text-center" name="lastName" value="<%=lastName %>" required="required"></td>
  </tr>
  <tr>
    <th>Email</th>
    <td><input type="text" class="form-control text-center" name="email" value="<%=email %>" readonly="readonly"></td>
  </tr>
  <tr>
    <th>Password</th>
    <td><input type="password" class="form-control text-center" name="password" value="<%=password %>" required="required" ></td>
  </tr>
   <tr>
    <th>gender</th>
    <td><input type="text" class="form-control text-center" name="gender" value="<%=gender %>" readonly="readonly"></td>
  </tr>
  <tr>
    <th>Street Address</th>
    <td><input type="text" class="form-control text-center" name="streetAddress" value="<%=streetAddress %>" required="required"></td>
  </tr>
 
  <tr>
    <th>Address Line1</th>
    <td><input type="text" class="form-control text-center" name="addressLine1" value="<%=addressLine1 %>" required="required"></td>
  </tr>
  <tr>
    <th>City</th>
    <td><input type="text" class="form-control text-center" name="city" value="<%=city %>" required="required"></td>
  </tr>
  <tr>
    <th>Province</th>
    <td><input type="text" class="form-control text-center" name="province" value="<%=province %>" required="required"></td>
    
  </tr>
  <tr>
    <th>Country</th>
    <td><input type="text"class="form-control text-center" name="country" value="<%=country %>" required="required"></td>
  </tr>
  <tr>
    <th>Postal Code</th>
    <td><input type="text" class="form-control text-center" name="postalCode" value="<%=postalCode %>" required="required"></td>
  </tr>
</table>
<div>
<button type="submit" class="btn btn-success update-btn">Update Profile</button>
</div>
</form>
  </div>
</div>
</body>
</html>
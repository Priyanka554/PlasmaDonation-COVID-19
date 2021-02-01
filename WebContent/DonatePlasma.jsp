v<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DonatePlasma</title>

<!-- Importing Bootstrap via CDN -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!-- Configuring external css -->

<link rel="stylesheet" href="DonatePlasma.css">
</head>
<body>

<!-- Retriving Data from Session Object -->

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

<!-- Importing header jsp -->

<jsp:include page="Header.jsp" />
 
<!-- Side Navigation bar -->
 
 <div class="row">
  <div class="column_left">
   <ul>
  <li><a class="link" href="UserProfilePage.jsp">View Profile Page</a></li>
  <li><a class="link " href="RequestPlasma.jsp">Request Plasma</a></li>
  <li><a class="link active" href="#">Donate Plasma</a></li> 
</ul>
  </div>
  <div> 
  
  
  <!-- Creating Plasma Request Form -->
  
<form action="donar" method="post">
<h3>DonatePlasma Form</h3>
<div class="container form-style">

   <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="firstName">First Name</label>
      <input type="text" class="form-control" id="firstName" name="firstName" value="<%=firstName%>" readonly="readonly">
    </div>
    <div class="col-sm-6 form-group">
     <label for="lastName">Last Name</label>
      <input type="text" id="lastName"class="form-control" name="lastName" value="<%=lastName %>" readonly="readonly">
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="email">Email</label>
      <input type="text" class="form-control" id="email" name="email" value="<%=email %>"  readonly="readonly">
    </div>
    <div class="col-sm-6 form-group">
     <label>Blood Group</label>
      <select name="gender" class="form-control" required="required">
        <option value="O+">O+</option>
         <option value="O-">O-</option>
         <option value="A+">A+</option>
         <option value="A-">A-</option>
         <option value="B+">B+</option>
         <option value="B-">B-</option>
         <option value="AB+">AB+</option>
         <option value="AB-">AB-</option>
      </select>
    </div>
    </div>
  <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="gender">Gender</label>
      <select name="gender" class="form-control" value="<%=gender %>" readonly="readonly">
        <option value="male">Male</option>
         <option value="female">Female</option>
      </select>
    </div>
    <div class="col-sm-6 form-group">
     <label for="country">Country</label>
       <select name="country" class="form-control" value="<%=country %>"   readonly="readonly">
        <option value="UnitedStates">United States</option>
         <option value="Canada">Canada</option>
         <option value="Mexico">Mexico</option>
      </select>
    </div>
  </div>
 <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="streetaddress">Street Address</label>
      <input type="text" class="form-control" id="streetaddress" name="streetAddress" value="<%=streetAddress %>"  readonly="readonly">
    </div>
    <div class="col-sm-6 form-group">
     <label for="addressline2">Address Line2</label>
      <input type="text" id="addressline2"class="form-control" name="addressLine2" value="<%=addressLine1 %>" readonly="readonly">
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-4 form-group ">
    <label for="city">City</label>
      <input type="text" class="form-control" id="city" value="<%=city %>" name="city" placeholder="City" readonly="readonly">
    </div>
    <div class="col-sm-4 form-group">
     <label >Province</label>
      <select name="province" class="form-control" value="<%=province %>" readonly="readonly">
        <option value="Alberta">Alberta</option>
         <option value="BritishColumbia">British Columbia</option>
         <option value="Monitoba">Monitoba</option>
      </select>
    </div>
    <div class="col-sm-4 form-group ">
    <label for="postalcode">Postal Code</label>
      <input type="text" class="form-control" id="postalcode" name="postalCode" value="<%=postalCode %>" readonly="readonly">
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-8 form-group">
     <label>Was your COVID-19 diagnosis confirmed by a lab test?</label>
       <select name="confirmedTest" class="form-control col-sm-9" required="required">
        <option value="I don't know">I don't know</option>
         <option value="yes">Yes</option>
         <option value="no">No</option>
      </select>
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-6 form-group">
     <label>Do you currently have symptoms?</label>
       <select name="currentlySymptoms" class="form-control col-sm-12" required="required">
        <option value="I don't know">I don't know</option>
         <option value="yes">Yes</option>
         <option value="no">No</option>
      </select>
    </div>
  </div>
   <div class="row table">
    <div class="col-sm-10 form-group">
     <label >Has it been at least 14 days since the last day of your symptoms (COVID-19 symptoms include fever, cough and shortness of breath)?</label>
       <select name="lastDayCovidBefore14days" class="form-control col-sm-7" required="required">
         <option value="yes">Yes</option>
         <option value="no">No</option>
      </select>
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-6 form-group">
     <label for="date">Date of last symptom</label>
      <input  class="form-control" type="date" id="date" name="date" required="required"> 
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-12 form-group">
     <label >Have you had a follow up test that was negative for COVID-19 or shows you no longer have COVID-19?</label>
       <select name="covidTest" class="form-control col-sm-6" required="required">
        <option value="I don't know">I don't know</option>
         <option value="yes">Yes</option>
         <option value="no">No</option>
      </select>
    </div>
  </div>  <div class="text-center">
  <button type="submit" class="btn btn-success">Submit</button>
  </div>
 
  </div>
</form>
</div>
</div>
</body>
</html>
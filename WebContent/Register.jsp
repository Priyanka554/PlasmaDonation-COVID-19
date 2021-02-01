<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Importing Bootstrap via CDN -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!-- Importing css file -->

 <link rel="stylesheet" href="Register.css">
 
<title>Register</title>
</head>
<body>

<!-- Register Form -->


<form action="register" method="post">
<h3>Register Form</h3>
<div class="container form-style">

  <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="firstName">FirstName</label>
      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name" required="required">
    </div>
    <div class="col-sm-6 form-group">
     <label for="lastName">LastName</label>
      <input type="text" id="lastName"class="form-control" name="lastName" placeholder="Last name" required="required">
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="email">Email</label>
      <input type="text" class="form-control" id="email" name="email" placeholder="Email" required="required">
    </div>
    <div class="col-sm-6 form-group">
     <label for="password">Password</label>
      <input type="password" id="password"class="form-control" name="password" placeholder="password" required="required">
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="gender">Gender</label>
      <select name="gender" class="form-control" required="required">
        <option  value="male">Male</option>
         <option   value="female">Female</option>
      </select>
    </div>
    <div class="col-sm-6 form-group">
     <label for="country">Country</label>
       <select name="country" class="form-control" required="required">
        <option  value="UnitedStates">United States</option>
         <option  value="Canada">Canada</option>
         <option  value="Mexico">Mexico</option>
      </select>
    </div>
  </div>
 <div class="row table">
    <div class="col-sm-6 form-group ">
    <label for="streetaddress">StreetAddress</label>
      <input type="text" class="form-control" id="streetaddress" name="streetAddress" placeholder="StreetAddress" required="required">
    </div>
    <div class="col-sm-6 form-group">
     <label for="addressline2">AddressLine2</label>
      <input type="text" id="addressline2"class="form-control" name="addressLine2" placeholder="AddressLine2" required="required">
    </div>
  </div>
  <div class="row table">
    <div class="col-sm-4 form-group ">
    <label for="city">City</label>
      <input type="text" class="form-control" id="city" name="city" placeholder="City" required="required">
    </div>
    <div class="col-sm-4 form-group">
     <label for="province">Province</label>
      <select  name="provience" class="form-control" required="required">
        <option  value="Alberta">Alberta</option>
         <option  value="BritishColumbia">British Columbia</option>
         <option  value="Monitoba">Monitoba</option>
      </select>
    </div>
    <div class="col-sm-4 form-group ">
    <label for="postalcode">Postal Code</label>
      <input type="text" class="form-control" id="postalcode" name="postalCode" placeholder="PostalCode" required="required">
    </div>
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-success">Submit</button>
  </div>
 <div class="text-right">
 If you already have an account ?<a href="Login.jsp">Login</a>
  </div>
  </div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">



</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Human Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home">Home</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" href="addCustomer">AddCustomer</a>
        </li>
        
        
          <li class="nav-item">
          <a class="nav-link" href="register">Register</a>
        </li>
        
        
          <li class="nav-item">
          <a class="nav-link" href="login">Login</a>
          
          
                    <li class="nav-item">
          <a class="nav-link" href="addVendor">AddVendor</a>
                    
        </li>
       
      </ul>
    </div>
  </div>
</nav>

<div class="container">
<div class="row">
<div class="col-md-12">
<div class="card">
<div class="card-header text-center ">
<h4> Customer Details</h4>

<c:if test="${not empty msg }">
							<h5 class="text-success">${msg }</h5>
							<c:remove var="msg" />
						</c:if>
</div>
<div class="card-body">
<table class="table">
  <thead>
    <tr>
       <th scope="col">Id</th>
      <th scope="col">Full Name</th>
      <th scope="col">Age</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      <th scope="col">Address</th>   
       <th scope="col">Action</th>   
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${customerList }" var="customer">
    <tr>
    
     <th scope="row">${customer.id}</th>
      <td>${customer.fullName }</td>
      <td>${customer.age }</td>
     <td>${customer.email }</td>
     <td>${customer.phone}</td>
      <td>${customer.address }</td>
      
      <td>
      <a href="editCustomer/${customer.id }" class="btn btn-sm btn-primary">Edit</a> 
      <a href="deleteCustomer/${customer.id }" class="btn btn-sm btn-danger">Delete</a>
      
      
      
      </td>
      
      
    </tr>
      </c:forEach>
    
  </tbody>
</table>

</div>
</div>
</div>
</div>
</div>

<!-- -second vendor table -->

<div class="container">
<div class="row">
<div class="col-md-12">
<div class="card">
<div class="card-header text-center ">
<h4> Vendor Details</h4>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Full Name</th>
      <th scope="col">Age</th>
      <th scope="col">Email</th>
       <th scope="col">Phone</th>
       <th scope="col">Address</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${vendorList }" var="vendor">
    <tr>
      <th scope="row">${vendor.id}</th>
      <td>${vendor.fullName}</td>
        <td>${vendor.age}</td>
         <td>${vendor.email}</td>
         <td>${vendor.phone}</td>
         <td>${vendor.address}</td>
       
        <td>
       <a href="editVendor/${vendor.id}" class="btn btn-sm btn-primary">Edit</a> 
      <a href="deleteVendor/${vendor.id}" class="btn btn-sm btn-danger">Delete</a>
        </td>
       
       
    </tr>
    </c:forEach>
      </tbody>
</table>
</div>
</div>
</div>
</div>
</div>
</body>
</html>
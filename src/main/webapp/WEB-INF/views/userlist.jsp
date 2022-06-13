<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User-List</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
 <div class="topnav">
            <a class="active" href="http://localhost:8081/spotify/songs/list">Home</a>
            <a href="#about">About</a>
            <a href="#contact">Contact</a>
            <div class="search-container">
            <form action="/action_page.php">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
            </div>
        </div>
        <div class="div1  mt-3 p3">
            <div class="header">
                <a class="active" href='add'>+ Add Users</a>
                <h2 > Users</h2>
               
            </div>
        </div>
        <br>
        <br>
<div class="div2  mt-3 p3">
<table  class="table1" border="1" cellspacing="10" cellpadding="10" mt-3 p3">
<tr>
<th class="col-sm-3">Email ID</th><th class="col-sm-3">Name</th><th class="col-sm-3">Gender</th>

</tr>
<!--  data row -->
<c:forEach var="user" items="${users}">
<tr >
<td>${user.email}</td>
<td>${user.name}</td>



<td>
<a href="deleteuser?email=${user.email}">Delete</a>
</td>
<td>
<a href="deleteuser?email=${user.email}" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-trash"></span> 
        </a>
        </td>

</tr>
</c:forEach>
</table>
</div>
</body>
</html>
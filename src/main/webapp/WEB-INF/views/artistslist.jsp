<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
<meta charset="ISO-8859-1">
<title>Artists-List</title>
  <style> 
        .GFG {  background-color: #ddd;  border: 2px solid RosyBrown; color: RosyBrown;  padding: 5px 10px;  text-align: center; 
display: inline-block;  font-size: 20px; margin: 10px 30px;   cursor: pointer; 
 } 
 </style> 
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body style="background-color:#ddd;">

 <div class="topnav">
            <a class="active" href="http://localhost:8081/spotify/songs/list">Home</a>
            <a href="#about">About</a>
            <a href="#contact">Contact</a>
            
        </div>
        <div class="div1  mt-3 p3">
            <div class="header">
                <a class="active" href='showform'>+ Add Artists</a>
                <h2 > Top 10 Artists</h2>
               
            </div>
        </div>
        <br>
        <br>
<div class="div2  mt-3 p3">
<table border="0" cellspacing="10" cellpadding="10" mt-3 p3">
<tr>
<th >Name </th> <th class="col-sm-3"><span class="fa fa-calendar-o"> </span></th> <th class="col-sm-3">Bio</th>

</tr>
<!--  data row -->
<c:forEach var="artists" items="${artists}">
<tr>
<td>${artists.artistname}</td>
<td>${artists.dobb}</td>
<td>${artists.bio}</td>


<td>
<a href="deleteartists/${artists.artistid}" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-trash"></span> 
        </a>

</td>

</tr>

</c:forEach>
</table>

</div>
</body>
</html>
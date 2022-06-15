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
<link th:rel="stylesheet" th:href="@{/webjars/font-awesome/5.11.2/css/all.css} "/>
</head>
<body style="background-color:#ddd;">
<div class="container-fluid spotify-app">
  <div class="row">
    <section class="col-xs-1 side-nav clean-paddings">
      <nav class="navbar">
         <ul class="nav">
           <li class="brand-icon"><a href="#"><span class="fa fa-spotify"></span></a></li>
           <li><a href="#"><span class="fa fa-search"></span>Search</a></li>
           <li><a href="#"><span class="fa fa-headphones"></span>Browse</a></li>
           <li><a href="#"><span class="fa fa-feed"></span>Radio</a></li>
           <li class="active"><a href="#"><span class="fa fa-bars fa-rotate-90"></span>Your Music</a></li>
           <li><a href="#"><span class="fa fa-users"></span>Follow</a></li>
        </ul>
      </nav>
    </section>
    
    
    
    <!-- Delete up of this  -->
    <nav>
    <section class="col-xs-11 clean-paddings">
      <nav>
        <div class="top-nav container-fluid">
          <ul class="nav navbar-nav">
            <li><a href="http://localhost:8081/spotify/">Home</a></li>
            <li class="active"><a href="http://localhost:8081/spotify/songs/list">Songs</a></li>
            <li><a href="http://localhost:8081/spotify/artists/list">Artists</a></li> 
          </ul>
        </div>
      </nav>

        <div class="div1  mt-3 p3">
            <div class="header">
                <a class="active" href='showform'>+ Add Artists</a>
                <h2 > Top 10 Artists</h2>
               
            </div>
        </div>
        <br>
        <br>
<div class="div2  mt-3 p3">
<table border="0" cellspacing="10" cellpadding="10" mt-3 p3>
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
</section>
</body>
</html>
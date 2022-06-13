<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs-List</title>
  <style> 
        .GFG {  background-color: #ddd;  border: 2px solid RosyBrown; color: RosyBrown;  padding: 5px 10px;  text-align: center; 
display: inline-block;  font-size: 20px; margin: 10px 30px;   cursor: pointer; 
 } 
 </style> 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
            <li><a href="http://localhost:8081/spotify/songs/list">Home</a></li>
            <li class="active"><a href="http://localhost:8081/spotify/songs/list">Songs</a></li>
            <li><a href="http://localhost:8081/spotify/artists/list">Artists</a></li> 
          </ul>
        </div>
      </nav>
 <div class="topnav">
            <a class="active" href="http://localhost:8081/spotify/songs/list">Home</a>
            <a class="active" href="http://localhost:8081/spotify/songs/list">Songs</a>
            <a class="active" href="http://localhost:8081/spotify/artists/list">Artists</a>
            <div class="search-container">
            <form action="/action_page.php">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
            </div>
        </div>
        <div class="div1  mt-3 p3">
            <div class="header">
                <a class="active" href='showform'>+ Add Song</a>
                <h2 > Top 10 Songs</h2>
               
            </div>
        </div>
        <br>
        <br>
<div class="div2  mt-3 p3">

<table table table-songs border="0" cellspacing="10" cellpadding="10" mt-3 p3">
<tr>
<th >Name </th> <th class="col-sm-3"> Cover</th> <th class="col-sm-3"><span class="fa fa-calendar-o"> </span></th><th>Artist</th>

</tr>
<!--  data row -->
<c:forEach var="songs" items="${songs}">
<tr>
<td> ${songs.songname}</td>
<td><img class="img-rounded"  height="150" width="150" src="${songs.filename}" /></td>
<td>${songs.dor}</td>

 <td>${songs.artists.artistname}</td>
 
 
<td>
<a href="deletesongs/${songs.songid}" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-trash"></span> 
        </a>
        </td>
</tr>
</c:forEach>
</table>
</div>
</div>
    </div>
</body>
</html>
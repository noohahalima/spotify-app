<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
<!-- <div class="topnav"> -->
<!--             <a class="active" href="http://localhost:8081/spotify/">Home</a> -->
<!--             <a href="#about">About</a> -->
<!--             <a href="#contact">Contact</a> -->
<!--             <div class="search-container"> -->
<!--             <form action="/action_page.php"> -->
<!--                 <input type="text" placeholder="Search.." name="search"> -->
<!--                 <button type="submit"><i class="fa fa-search"></i></button> -->
<!--             </form> -->
<!--             </div> -->
<!--         </div> -->
        <div class="div1  mt-3 p3">
            <div class="header">
                <a class="active" href="http://localhost:8081/spotify/user/add">+ Register</a>
                <h2 > Login</h2>
               
            </div>
        </div>
        <br>
        <br>

<form action="songs/list" method="POST">
<table class="table1" cellspacing="0" cellpadding="10" border="1">

<tr>
<th>Email *</th>
<td><input type="text" name="email" 
id="email" value="" placeholder="Enter email" maxlength="20" required></td>
</tr>
<tr>
<th>Password *</th><td><input type="password" name="password" 
id="password" value="" placeholder="Enter Password" maxlength="20" required></td>
</tr>
<tr>
<td colspan="2">
<font color="red"> ${errormessages}</font>
</td>
<tr>
<td colspan="2">
<button type="submit" class="btn btn-default" input type="submit" value="Submit">Submit</button>
</td>
</tr>
</table>
</form>
</body>
</html>
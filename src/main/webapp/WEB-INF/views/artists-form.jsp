<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add artist</title>
  <style> 
        .GFG {  background-color: Cornsilk;  border: 2px solid RosyBrown; color: RosyBrown;  padding: 5px 10px;  text-align: center; 
display: inline-block;  font-size: 20px; margin: 10px 30px;   cursor: pointer; 
 } 
 .error{color:red}
 </style> 
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link th:rel="stylesheet" th:href="@{/webjars/font-awesome/5.11.2/css/all.css} "/>
</head>
<body style="background-color:#ddd;;">

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
                
                <h2 > Adding a new Artist</h2>
               
            </div>
        </div>
        <br>
        <br>
<h1></h1>
<form:form action="${pageContext.request.contextPath}/artists/save" modelAttribute="artists" method="post" >

	<form:hidden path="artistid"/>
	<div class="div2  mt-3 p3">
<table border="1" cellpadding="10" cellspacing="0">
<tr>
<td>Artist Name :</td><td><form:input path="artistname" />

<form:hidden path="artistid"/>
<form:errors path="artistname" cssClass="error">
</form:errors>
</td>
</tr>

		




<tr>
<td>Date of Birth :</td><td><form:input path="dobb" />
<form:errors path="dobb" cssClass="error">
</form:errors>
</td>
</tr>

<tr>
<td>Bio :</td><td><form:input path="bio" />
<form:errors path="bio" cssClass="error">
</form:errors>
</td>
</tr>


<tr>
<td colspan="2">
<font color="red"> ${errormessages}</font>
</td>
<tr>
<tr>
<td colspan="2"><input type="Submit" value="Submit"></td>
</table>
 </div>
 
</form:form>

</body>
</html>
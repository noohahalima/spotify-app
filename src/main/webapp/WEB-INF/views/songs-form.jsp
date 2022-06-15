<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add song</title>
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
                
                <h2 > Adding a new Song</h2>
               
            </div>
        </div>
        <br>
        <br>
<h1></h1>
<form:form action="${pageContext.request.contextPath}/songs/save" modelAttribute="songs" method="post" enctype="multipart/form-data">
<form:hidden path="filename"/>
	<form:hidden path="songid"/>
	<div class="div2  mt-3 p3">
<table class="table1" border="1" cellpadding="10" cellspacing="0">
<tr>
<th>Name :</th>
<td><form:input path="songname" />
<form:hidden path="songid"/>
<form:errors path="songname" cssClass="error">
</form:errors>
</td>
</tr>

<tr>
<th>
Select photo:</th>
<td> <input type="file" name="photo"/>
</td>
</tr>
		




<tr>
<th>Date of Release :</th>
<td><form:input path="dor" />
<form:errors path="dor" cssClass="error">
</form:errors>
</td>
</tr>

<tr>
<th>Rate :</th>
<td><form:input path="rating" />
<form:errors path="rating" cssClass="error">
</form:errors>
</td>
</tr>





<tr>
		<th>Artists Name </th>
	<%-- 	<td>
 <form:select path="artists.artistid">    
       <option value="-1">Select artist</option>
    
       <c:forEach items="${artists}" var="artistlist">
       <option value="${artists.artistid}"  ${songs.artists.artistid == artists.artistid ? 'selected' : ''}>${artists.artistname}</option>
      	 
       </c:forEach>
      </form:select>
       <a class="active" href="http://localhost:8081/spotify/artists/showform">Add artist</a>
      
</td> --%>
<td>${songs.artists.artistid}</td>
<td><select name="artistid">
<option>Select Artist</option>
<c:forEach var="artist" items="${artistlist}" >
<option value="${artist.artistid}">${artist.artistname}</option>
</c:forEach>
</select>
 		
 </tr>
 <tr>
<%-- <th>Artist Name :</th>
<td><form:select  path="artists.artistid">
<form:option value="">Select Artist</form:option>
<c:forEach var="art" items="${artistlist}">
<form:option value="${art.artistid}">${art.artistid} </form:option>
</c:forEach>
</form:select>  --%>



</td>
</tr>
<tr>
<td colspan="2">
<font color="red"> ${errormessages}</font>
</td>
<tr>



<td colspan="2">
<button type="submit" class="btn btn-default" input type="submit" value="Submit">Submit</button>
</td>
</table>
 </div>
 
</form:form>
</div>

</body>
</html>
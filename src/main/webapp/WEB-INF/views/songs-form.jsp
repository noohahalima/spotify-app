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
 
</head>
<body style="background-color:#ddd;;">

 <div class="topnav">
            <a class="active" href="http://localhost:8081/spotify/songs/list">Home</a>
            <a href="#about">About</a>
            <a href="#contact">Contact</a>
            
        </div>
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
<th>Artist Name :</th>
<td><form:select  path="artists.artistid">
<form:option value="-1">Select Artist</form:option>
<c:forEach var="art" items="${artistlist}">

<form:option value="${art.artistid}">${art.artistname} </form:option>
</c:forEach>
</form:select>

 <a class="active" href="http://localhost:8081/spotify/artists/showform">Add artist</a>
</td>
</tr>
<tr>
<td colspan="2">
<font color="red"> ${errormessages}</font>
</td>
<tr>

<%-- <tr>
		<td>Artist Name </td><td>
 <form:select path="artists.artistid">    
       <option value="1">Select a type</option>
       <c:forEach items="${artistlist}" var="artists">
       <option value="${songs.artists.artistid}"  ${songs.artists.artistid == Artists.artistid ? 'selected' : ''}>${songs.artists.artistname}</option>
      	 
       </c:forEach>
      </form:select>
</td>
 		
 		</tr> --%>

<td colspan="2">
<button type="submit" class="btn btn-default" input type="submit" value="Submit">Submit</button>
</td>
</table>
 </div>
 
</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <style> 
        .GFG {  background-color: Cornsilk;  border: 2px solid RosyBrown; color: RosyBrown;  padding: 5px 10px;  text-align: center; 
display: inline-block;  font-size: 20px; margin: 10px 30px;   cursor: pointer; 
 } 
 </style> 
</head>
<body style="background-color:Linen;">
First Name :${songs.songname}
<br><br>
Last Name :${songs.dor}
<br><br>

<br><br>
<ul>

<h1>Thank you for adding.</h1>
<button class="GFG" 
    onclick="window.location.href = 'http://localhost:8081/spotify/';">   Home  </button> 
</body>
</html>
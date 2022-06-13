<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.error{color:red}
</style>
</head>
<body>
 <div class="topnav">
            <a class="active" href="#home">Home</a>
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
<!--                 <a class="active" href="http://localhost:8081/spotify/user/add">+ Register</a>
 -->                <h2 > Register</h2>
               
            </div>
        </div>
        <br>
        <br>

<form:form action="save" method="post" modelAttribute="user">
<table class="table1" cellspacing="0"  cellpadding="10"> 
<tr>
<th>Name :</th>
<td><form:input path="name" />
<form:errors path="name" cssClass="error"/>
</td>
</tr>

<tr>
<th>Email * :</th><td><form:input  path="Email"/>
<form:errors path="Email" cssClass="error">

</form:errors>
</td>
</tr>
<tr>
<tr>
<th>Password :</th><td><form:password  path="pwd"/>
<form:errors path="pwd" cssClass="error">

</form:errors>
</td>
</tr>


<td colspan="2">
<button type="submit" class="btn btn-default" input type="submit" value="Submit">Submit</button>
</td>
</tr>
</table>
</form:form>
</body>
</html>
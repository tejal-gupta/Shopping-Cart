<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightblue";>
<center><h1><br><br>SHOPBAY</h1></center><br><br>
Hello, <%=session.getAttribute("username")%>
<center><a href="viewproducts.jsp"> View Products</a> </center>
 <center><a href="Logout"> Logout </a></center>
</body>
</html>


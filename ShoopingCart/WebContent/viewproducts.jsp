<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager" %>
    <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.ResultSet" %>
    <%@page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightblue";>
<br><h1><center>PRODUCTS</center></h1>
Hello, <%=session.getAttribute("username")%>
<center><table border="1">
<tr>
<td> Product Id</td>
<td> Product Name</td>
<td> Product Description</td>
<td> Product Price</td>
</tr>
 <%
 try {
		Class.forName("com.mysql.cj.jdbc.Driver");	
	}
	catch(ClassNotFoundException cnfe){ 
		cnfe.printStackTrace();
	}
 	Connection con1=null;
 	Statement stmt=  null;
 	ResultSet r=null;
 	
 try {
		con1 = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
		stmt = con1.createStatement(); 
		String s= "select * from test.products";  
	    r=stmt.executeQuery(s);  
		while(r.next()){
  %>
  <tr>
 <td> <%= r.getString("id") %></td>
  <td><%= r.getString("name") %></td>
  <td><%= r.getString("description") %></td>
  <td><%= r.getString("price") %></td>
  </tr>
  
  <%
  }
  con1.close();
  } catch (Exception ex){
  	ex.printStackTrace();}
  	%>
  	</table>
  	<form action="" method="post">
  	Product Id:<input type="number" name="id"/><br/><br/>
	<input type="submit" value="submit"/>  
  	</form>
  	<br><br><a href="Logout"> Logout </a>
  	</center>
</body>
</html>
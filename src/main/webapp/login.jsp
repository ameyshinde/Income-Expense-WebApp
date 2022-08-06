<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">
<% String lmsg=(String)request.getAttribute("lmsg");
if(lmsg!=null){%>
<h1 style="color:red"><%=lmsg %></h1>
 <%} %>
	<form action="loginServlet" method="post">
<table cellspacing="10" border="1">
		<tr>
		<td>Email</td>
		<td> <input type="email" name ="email" required="required"></td>
		</tr>
		<tr>
		<td>Password</td>
		<td> <input type="password" name ="passw1" required="required"></td>
		</tr>
		<tr>
		<td> <button type="submit" value="login">Login</button></td>
		<td> <button type="button" value="register"><a href="addUser.jsp">Register Here</a></button></td>
		</tr>
</table>
</form>
</div>
</body>
</html>
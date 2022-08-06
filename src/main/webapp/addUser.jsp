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
		<%
		String lmsg = (String) request.getAttribute("lmsg");
		if (lmsg != null) {
		%>
		<h1 style="color: red"><%=lmsg%></h1>
		<%
		}
		%>
		<form action="UserServlet" method="post">
			<input type="hidden" name="action" value="addUser">
			<table cellspacing="10" border="1">
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" required="required"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="cpass" required="required"></td>
				</tr>
				<tr>
					<td><button id="btn" value="Save" type="submit">Save</button>
				<td><button id="btn" value="Reset" type="reset">Reset</button>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>
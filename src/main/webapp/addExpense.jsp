<%@page import="com.inc.dao.UserDao"%>
<%@page import="com.inc.pojo.user"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<user> ulist = new UserDao().getUserList();
	user user =(user)session.getAttribute("user");
	String expmsg = (String) request.getAttribute("expmsg");

	%>
	<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">
	<%	if(expmsg!=null) { %>
		<h1 style="color:red"><%=expmsg %></h1>
	<%} %>
	<form action="expenseServlet" method="post">
	<input type="hidden" name="action" value="addExpense">
	<input type="hidden" name="userId" value=<%=user.getId()%>>
		<table cellspacing="10" border="1">
			<tr>
				<td>expense</td>
				<td><input type="number" name="expense" required="required"></td>
			</tr>
			<tr>
				<td>ExpenseType</td>
				<td><select name="expenseType">
						<option>-------------Select-------------</option>
						<option>Home</option>
						<option>Self</option>
						<option>Family</option>
						<option>EMI</option>
						<option>other</option>
				</select></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><textarea style="resize:none;"rows="10" cols="50" name="description"></textarea>
				</td>
			</tr>

			<tr>
				<td>userName</td>
				<td><input type="text"  value="<%=user.getEmail()%>"></td>
			<tr>
				<td><input type="Submit" value="Save"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
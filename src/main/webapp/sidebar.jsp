<%@page import="com.inc.pojo.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SideBar</title>
<link rel="stylesheet" href="resources/css/app.css">
</head>
<body>
	<%
	user u = (user) session.getAttribute("user");
	%>
	<div id="sidebar">
		<h2>
			<a href="index.jsp">HOME</a>
		</h2><hr>
		<%
		if (u!= null) {
		%>
		<h2>
			<a href="addIncome.jsp">AddIncome</a>
		</h2><hr>
		<h2>
			<a href="addExpense.jsp ">AddExpense</a>
		</h2><hr>
		<h2>
			<a href="incomeServlet">IncomeList</a>
		</h2><hr>
		<h2>
			<a href="expenseServlet ">ExpenseList</a>
		</h2><hr>
		<h2>
			<a href="loginServlet ">Logout</a>
		</h2><hr>
		<h2>
			<a href="updateUser.jsp">EditProfile</a>
		</h2><hr>

		<%
		}
		if (u == null) {
		%>
		<h2>
			<a href="addUser.jsp">Register</a>
		</h2><hr>
		<h2>
			<a href="login.jsp">Login</a>
		</h2><hr>
		<%
		}
		%>

	</div>
</body>
</html>
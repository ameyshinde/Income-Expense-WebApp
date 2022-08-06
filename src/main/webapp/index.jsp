<%@page import="com.inc.dao.IncomeDao"%>
<%@page import="com.inc.pojo.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/app.css">
</head>
<body>
	<%
	user user = (user) session.getAttribute("user");
	%>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div id="main">
	<h1 id ="header">Daily Income Expense Application.</h1>
	<img src= "images/submit-expenses-from-mobile.png" alt="image demo" width="1200%" height="400%">
		<%
		if (user != null) {
			double bal = new IncomeDao().getBalance(user.getId());
		%>
		<h2>
			Welcome: <span style="color:green"><%=user.getEmail()%></span>
		</h2>
		<h2>
			Your Remaining Balance: <span style="color:green"><%=bal%></span>
		</h2>
		<%
		}
		%>
	</div>
</body>
</html>
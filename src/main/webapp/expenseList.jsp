<%@page import="com.inc.pojo.Expense"%>
<%@page import="com.inc.pojo.Income"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/app.css">
</head>
<body>
<%List<Expense> expl = (List<Expense>) session.getAttribute("explist");
int count = 1;
%>
<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">
<br>
<form action="expenseServlet?action=srch" method="post">
<input rows="1" cols="0" name = "search" placeholder="Search Record Here"></input>
<input type="submit" value="Search"></input>
</form>
<br>
<table  border="1" cellspacing="10">
	<tr>
	<th>Id</th>
	<th>EXPENSE </th>
	<th>EXPENSE TYPE</th>
	<th>EXPENSE DATE</th>
	<th>DESCRIPTION</th>
	 
	 <th colspan="4">Action</th>
	 </tr>
<%for(Expense i:expl){ %>
		<tr>
			<td><%=count++ %></td>
			<td><%=i.getExpense()%></td>
			<td><%=i.getExpenseType()%></td>
			<td><%=i.getExpenseDate()%></td>
			<td><%=i.getDescription()%></td>
			<td><a href=" expenseServlet?action=delete&id=<%=i.getId()%>">Delete</a></td>
			<td><a href=" expenseServlet?action=edit&id=<%=i.getId()%>">Edit</a></td>
		</tr>
		<%} %>
</table>
</div>
<div id="rside">
		<h1>
			Sort By Expense
			</h2>
			<ul id="ulist">
				<li>
					<h2>
						<a href="expenseServlet">All</a>
					</h2>
				</li>
				<li>
					<h2>
						<a href="expenseServlet?action=searchByExpType&type=Home">Home</a>
					</h2>
				</li>
				<li>
					<h2>
						<a href="expenseServlet?action=searchByExpType&type=Self">Self</a>
					</h2>
				</li>
				<li>
					<h2>
						<a href="expenseServlet?action=searchByExpType&type=Family">Family</a>
						</h2>
				</li>
				<li>
					<h2>
						<a href="expenseServlet?action=searchByExpType&type=EMI">EMI</a>
						</h2>
				</li>
				<li>
					<h2>
						<a href="expenseServlet?action=searchByExpType&type=other">other</a>
						</h2>
				</li>
			</ul>
	</div>
</body>
</html>
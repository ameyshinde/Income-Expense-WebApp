<%@page import="com.inc.pojo.Income"%>
<%@page import="java.util.List"%>
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
	List<Income> incl = (List<Income>) session.getAttribute("inclist");
	int count = 1;
	%>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div id="main">
		<br>
		<form action="incomeServlet?action=srch" method="post">
			<input rows="1" cols="0" name="search"
				placeholder="Search Record Here"></input> <input type="submit"
				value="Search"></input>
		</form>
		<br>
		<table border="1" cellspacing="10">
			<tr>
				<th>Id</th>
				<th>INCOME</th>
				<th>INCOME TYPE</th>
				<th>INCOME DATE</th>
				<th>DESCRIPTION</th>

				<th colspan="4">Action</th>
			</tr>
			<%
			for (Income i : incl) {
			%>
			<tr>
				<td><%=count++%></td>
				<td><%=i.getIncome()%>
				<td><%=i.getIncomeType()%>
				<td><%=i.getIncomeDate()%>
				<td><%=i.getDescription()%>
				<td><a href="incomeServlet?action=delete&id=<%=i.getId()%> ">Delete</a></td>
				<td><a href="incomeServlet?action=edit&id=<%=i.getId()%> ">Edit</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<div id="rside">
		<h1>
			Sort By Income
			</h2>
			<ul id="ulist">
				<li>
					<h2>
						<a href="incomeServlet">All</a>
					</h2>
				</li>
				<li>
					<h2>
						<a href="incomeServlet?action=searchByIncType&type=salary">Salary</a>
					</h2>
				</li>
				<li>
					<h2>
						<a href="incomeServlet?action=searchByIncType&type=collection">Collection</a>
					</h2>
				</li>
				<li>
					<h2>
						<a href="incomeServlet?action=searchByIncType&type=others">Other</a>
						</h4>
				</li>
			</ul>
	</div>
</body>
</html>
<%@page import="com.inc.pojo.Expense"%>
<%@page import="com.inc.pojo.user"%>
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
	user user = (user) session.getAttribute("user");
	Expense exp = (Expense) session.getAttribute("exp");
	%>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div id="main">
		<h1>Expense Update Form</h1>
		<form action="expenseServlet" method="post">
			<input type="hidden" name="id" value=<%=exp.getId()%>> <input
				type="hidden" name="action" value="updateExpense"> <input
				type="hidden" name="userId" value=<%=user.getId()%>>
			<table cellspacing="10" border="1">
				<tr>
					<td>Expense</td>
					<td><input type="number" name="expense"
						value="<%=exp.getExpense()%>" required="required"></td>
				</tr>
				<tr>
					<td>ExpenseType</td>
					<td><select name="expenseType">
							<option><%=exp.getExpenseType()%></option>
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
					<td><textarea style="resize: none;" rows="10" cols="50"
							name="description"><%=exp.getDescription()%></textarea></td>
				</tr>

				<tr>
					<td>userName</td>
					<td><input type="text" value="<%=user.getEmail()%>"></td>
				<tr>
					<td><button id="btn" value="Update" type="submit">Update</button>
					<td><button id="btn" value="Reset" type="reset">Reset</button>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
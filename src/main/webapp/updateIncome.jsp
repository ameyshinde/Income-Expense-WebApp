<%@page import="com.inc.pojo.Income"%>
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
	Income inc = (Income) session.getAttribute("inc");
	%>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div id="main">
		<h1>Income Update Form</h1>
		<form action="incomeServlet" method="post">
			<input type="hidden" name="id" value="<%=inc.getId()%>"> <input
				type="hidden" name="action" value="updateIncome"> <input
				type="hidden" name="userId" value=<%=user.getId()%>>
			<table cellspacing="10" border="1">
				<tr>
					<td>Income</td>
					<td><input type="number" name="income"
						value="<%=inc.getIncome()%>" required="required"></td>
				</tr>
				<tr>
					<td>Income Type</td>
					<td><select name="incomeType">
							<option><%=inc.getIncomeType()%></option>
							<option>-------------Select-------------</option>
							<option>Salary</option>
							<option>Collection</option>
							<option>others</option>
					</select></td>
				</tr>

				<tr>
					<td>Description</td>
					<td><textarea style="resize: none;" rows="10" cols="50"
							name="description"><%=inc.getDescription()%></textarea></td>
				</tr>

				<tr>
					<td>User Name</td>
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
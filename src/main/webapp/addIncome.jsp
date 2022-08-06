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
	%>
	<jsp:include page="sidebar.jsp"></jsp:include>
<div id="main">
	<form action="incomeServlet" method="post">
	<input type="hidden" name="action" value="addIncome">
	<input type="hidden" name="userId" value=<%=user.getId()%>>
		<table  class="centre" cellspacing="10" border="1">
			<tr>
				<td>Income</td>
				<td><input type="number" name="income" required="required"></td>
			</tr>
			<tr>
				<td>Income Type</td>
				<td><select name="incomeType">
						<option>-------------Select-------------</option>
						<option>Salary</option>
						<option>Collection</option>
						<option>others</option>
				</select></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><textarea style="resize:none;"rows="10" cols="50" name="description"></textarea>
				</td>
			</tr>

			<tr>
				<td>User Name</td>
				<td><input type="text"  value="<%=user.getEmail()%>"></td>
			<tr>
				<td><button id="btn" value="Save" type="submit">Save</button>
				<td><button id="btn" value="Reset" type="reset">Reset</button>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
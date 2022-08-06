package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.ExpenseDao;
import com.inc.dao.IncomeDao;
import com.inc.pojo.Expense;

import com.inc.pojo.user;
@WebServlet("/expenseServlet")
public class ExpenseServlet extends HttpServlet {
	Expense exp = new Expense();  
	ExpenseDao expd= new ExpenseDao();
	IncomeDao incd = new IncomeDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("user");
		
		String action = request.getParameter("action");
		if(action !=null && action.equals("delete"))
		{
			int id =Integer.parseInt(request.getParameter("id")) ;
			boolean b = expd.deleteExpense(id);
			if(b) {
				response.sendRedirect("expenseServlet");
			}
		}
		
		else if(action!=null && action.equals("edit"))
		{
			int id =Integer.parseInt(request.getParameter("id")) ;
			Expense i = expd.getExpense(id);
			session.setAttribute("exp",i);
			response.sendRedirect("updateExpense.jsp");
		}
		
		else if (action!=null && action.equals("searchByExpType"))
		{
			String type = request.getParameter("type");
			List<Expense> explist = expd.getExpenseListByType(user.getId(), type);
			session.setAttribute("explist",explist);
			response.sendRedirect("expenseList.jsp");
		}
		
		else
		{
			List<Expense> explist = expd.getExpenseList(user.getId());
			session.setAttribute("explist",explist);
			response.sendRedirect("expenseList.jsp");
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		user user=(user)session.getAttribute("user");
		String expenseType = request.getParameter("expenseType");
		String description = request.getParameter("description");
		
		
		exp.setExpenseType(expenseType);
		
		exp.setDescription(description);
		
		
		if(action!=null && action.equals("addExpense")) {
			double expense =Double.parseDouble(request.getParameter("expense"));
			exp.setExpense(expense);
			int userid = Integer.parseInt(request.getParameter("userId"));
			exp.setUserId(userid);
			double bal = incd.getBalance(userid);
			if(bal>expense)
			{
		boolean b = expd.addExpense(exp);
		if(b)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("addExpense.jsp");
		}
			}else {
				request.setAttribute("expmsg", "Your Expense is Higher than your Balance Limit Exceeded!");
				RequestDispatcher rd = request.getRequestDispatcher("addExpense.jsp");
				rd.include(request, response);
			}
		}
		else if(action!=null && action.equals("updateExpense")) {
			double expense =Double.parseDouble(request.getParameter("expense"));
			exp.setExpense(expense);
			int userid = Integer.parseInt(request.getParameter("userId"));
			exp.setUserId(userid);
			int id =Integer.parseInt(request.getParameter("id")); 
			exp.setId(id);
			boolean b = expd.updateExpense(exp);
			if(b) {
				response.sendRedirect("expenseServlet");
			}
		}
		else if(action!=null && action.equals("srch")) {
			String search= request.getParameter("search");
			List<Expense> explist = expd.getExpenseListByDescription(user.getId(), search);
			session.setAttribute("explist", explist);
			response.sendRedirect("expenseList.jsp");
		}
	}


}

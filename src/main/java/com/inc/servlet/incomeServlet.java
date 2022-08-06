package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.IncomeDao;
import com.inc.pojo.Income;
import com.inc.pojo.user;
@WebServlet("/incomeServlet")
public class incomeServlet extends HttpServlet {
	Income inc = new Income();  
	IncomeDao incd= new IncomeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("user");
		
		String action = request.getParameter("action");
		if(action !=null && action.equals("delete"))
		{
			int id =Integer.parseInt(request.getParameter("id")) ;
			boolean b = incd.deleteIncome(id);
			if(b) {
				response.sendRedirect("incomeServlet");
			}
		}
		
		else if(action!=null && action.equals("edit"))
		{
			int id =Integer.parseInt(request.getParameter("id")) ;
			Income i = incd.getIncome(id);
			session.setAttribute("inc",i);
			response.sendRedirect("updateIncome.jsp");
		}
		else if(action!=null && action.equals("searchByIncType"))
		{
			String type = request.getParameter("type");
			List<Income> inclist = incd.getIncomeListByType(user.getId(), type);
			session.setAttribute("inclist",inclist);
			response.sendRedirect("incomeList.jsp");
		}
		else
		{
			List<Income> inclist = incd.getIncomeList(user.getId());
			session.setAttribute("inclist",inclist);
			response.sendRedirect("incomeList.jsp");
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		user user=(user)session.getAttribute("user");
		String incomeType = request.getParameter("incomeType");
		String description = request.getParameter("description");
		
		
		inc.setIncomeType(incomeType);
		
		inc.setDescription(description);
		
		
		if(action!=null && action.equals("addIncome")) {
			double income =Double.parseDouble(request.getParameter("income"));
			inc.setIncome(income);
			int userid = Integer.parseInt(request.getParameter("userId"));
			inc.setUserId(userid);
		boolean b = incd.addIncome(inc);
		if(b)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("addIncome.jsp");
		}
		}
		else if(action!=null && action.equals("updateIncome")) {
			double income =Double.parseDouble(request.getParameter("income"));
			inc.setIncome(income);
			int userid = Integer.parseInt(request.getParameter("userId"));
			inc.setUserId(userid);
			int id =Integer.parseInt(request.getParameter("id")); 
			inc.setId(id);
			boolean b = incd.updateIncome(inc);
			if(b) {
				response.sendRedirect("incomeServlet");
			}
		}
		else if(action!=null && action.equals("srch")) {
			String search= request.getParameter("search");
			List<Income> inclist = incd.getIncomeListByDescription(user.getId(), search);
			session.setAttribute("inclist", inclist);
			response.sendRedirect("incomeList.jsp");
		}
	}


}

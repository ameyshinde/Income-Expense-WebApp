package com.inc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inc.dao.IncomeDao;
import com.inc.dao.UserDao;
import com.inc.pojo.user;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet{
	IncomeDao incd = new IncomeDao();
	user u = new user();
	UserDao ud = new UserDao();

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String passw1 = request.getParameter("passw1");
	
		u=ud.userLogin(email, passw1);
		
		if (u!=null && email!=null && u.getEmail().equals(email) && u.getPassword().equals(passw1) ) {
			session.setAttribute("user", u);
			session.setAttribute("bal", incd.getBalance(u.getId()));
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("lmsg", "Username and password is incorret");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
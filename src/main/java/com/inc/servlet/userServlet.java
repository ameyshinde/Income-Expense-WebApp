package com.inc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.inc.dao.UserDao;
import com.inc.pojo.user;

@WebServlet("/UserServlet")
public class userServlet extends HttpServlet {

	UserDao ud = new UserDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession();
		user user = (user)session.getAttribute("user");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		user u = new user();
		String email = request.getParameter("email");
		String password1 = request.getParameter("pass");
		String password2 = request.getParameter("cpass");
		String action = request.getParameter("action");
		if(action!=null && action.equals("addUser")) { 

			if(email!=null && password1.equals(password2))
			{
				boolean b = ud.addUser(email,password1);
				if(b)
				{
					response.sendRedirect("index.jsp");
				}
				else
				{
					request.setAttribute("lmsg","Username Already Exists..");
					RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
					rd.include(request,response);
				}
			}
			else
			{
				request.setAttribute("lmsg","Password and Confirmed Password Does not matched..");
				RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
				rd.include(request,response);
			}
		}
		else if(action!=null && action.equals("updateUser"))
		{
			HttpSession session = request.getSession();
			String name = request.getParameter("name");
			String contact = request.getParameter("contact");
			int id =Integer.parseInt(request.getParameter("id"));
			u.setContact(contact);
			u.setName(name);
			u.setEmail(email);
			u.setId(id);
			u.setPassword(password1);

			boolean b = ud.updateUser(u);
			if(b)
			{
				session.setAttribute("user", u);
				response.sendRedirect("index.jsp");
			}
			else {

			}
		}
	}
}

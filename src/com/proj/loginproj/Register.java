package com.proj.loginproj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/plain");

		PrintWriter out = resp.getWriter();

		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		String phonenumber = req.getParameter("ph_no");
		String email = req.getParameter("email");

		boolean flag = UserDataBase.createOrUpdate(username, firstname,
				lastname, password, phonenumber, email);
		if (flag) {

			// RequestDispatcher dispatcher = getServletContext()
			// .getRequestDispatcher("Welcome.html");
			// dispatcher.forward(req, resp);
			System.out.println("You are sucessfully created ");
			// RequestDispatcher dispatcher =
			// req.getRequestDispatcher("WelcomePage");
			// dispatcher.forward(req,resp);
			resp.sendRedirect("WelcomePage.html");
		} else {
			out.println("You are fAILED created ");
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("signUp.html");
			dispatcher.forward(req, resp);

		}

	}
}

package com.proj.loginproj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;

public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String username = req.getParameter("username");
		String password = req.getParameter("pwd");

		boolean flag = false;
		try {
			flag = UserDataBase.loginUser(username, password);
		} catch (EntityNotFoundException e) {

		}
		if (flag) {

			resp.sendRedirect("WelcomePage.html");

		} else {
			out.println("sorry please enter correctly");

			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);

		}

	}

}

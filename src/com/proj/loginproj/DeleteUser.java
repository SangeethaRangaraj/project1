package com.proj.loginproj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		String user= req.getParameter("delete");
		System.out.println("inside delete");
		UserDataBase.deleteUser(user);
		out.println("user deleted");

	}
}
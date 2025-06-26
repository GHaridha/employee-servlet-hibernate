package com.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class LogoutEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate(); // Destroy session
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body>");
		printWriter.print("<h1> Logged out successfully</h1>");
		printWriter.print("</body></html>");
		req.getRequestDispatcher("index.jsp").include(req, resp);
	}
}

package com.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirecting")
public class RedirectingPage extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {String action = req.getParameter("action");
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	
	int empid = Integer.parseInt(req.getParameter("empid"));
	Employee e = em.find(Employee.class, empid);
	req.setAttribute("employee", e);
	if ("update".equals(action)) {
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	} else if ("delete".equals(action)) {
		req.getRequestDispatcher("delete.jsp").forward(req, resp);
	}
	else if ("fetchAllEmployee".equals(action)) {
		req.getRequestDispatcher("fetchAllEmployee").forward(req, resp);
	} 
	else {
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<h1>Please select an action.</h1>");
		out.print("</body></html>");
	}
}
}

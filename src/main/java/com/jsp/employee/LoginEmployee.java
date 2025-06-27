package com.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginEmployee")
public class LoginEmployee extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Query query = em.createQuery("select e from Employee e where email = ?1 and password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Employee> resultList = query.getResultList();
		if (resultList.isEmpty()) {
		    // No user found
		    PrintWriter out = resp.getWriter();
		    out.print("<html><body><h2 style='color:red;'>Invalid email or password</h2></body></html>");
		    req.getRequestDispatcher("login.html").include(req, resp);
		}
		else {
		    // User authenticated
		    Employee e = resultList.get(0);
		    HttpSession session = req.getSession();
			session.setAttribute("employee", e);
			resp.sendRedirect("employee-detail.jsp");
		}
	}
}

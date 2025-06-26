package com.jsp.employee;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerEmployee")
public class RegisteringEmployee extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		
		Employee employee =new Employee();
		employee.setName(req.getParameter("empname"));
		employee.setAge(Integer.parseInt(req.getParameter("age")));
		employee.setSalary(Double.parseDouble(req.getParameter("salary")));
		employee.setEmail(req.getParameter("email"));
		employee.setPassword(req.getParameter("password"));
		Address address =new Address();
		address.setHouseNumber(req.getParameter("houseNumber"));
		address.setStreet(req.getParameter("street"));
		address.setPincode(Integer.parseInt(req.getParameter("pincode")));
		address.setDistrict(req.getParameter("district"));
		address.setState(req.getParameter("state"));
		address.setCountry(req.getParameter("country"));
		employee.setAddress(address);
		
		et.begin();
		
		em.persist(address);
		em.persist(employee);
		
		et.commit();
	}
}

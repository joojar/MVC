package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpAccess;
import model.EmpBean;

public class EmpServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException, IOException
	{
		String n=req.getParameter("name");
		System.out.println(n);
		EmpAccess ea=new EmpAccess();
		
		try {
			EmpBean eb=ea.getSalary(n);
			System.out.println(eb.getSalary());
			req.setAttribute("myBean", eb);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd=req.getRequestDispatcher("salary.jsp");
		rd.forward(req, rep);
	}
}

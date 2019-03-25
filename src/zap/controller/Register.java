package zap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zap.db.Users;
import zap.model.UsersDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/zap.controller.Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		Users u =new Users();
		u.setName(request.getParameter("Name"));
		u.setDepartment(request.getParameter("Department"));
		u.setDesignation(request.getParameter("Designation"));
		u.setEmail(request.getParameter("Email"));
		u.setPassword(request.getParameter("Password"));
		u.setPhone(request.getParameter("Phone"));
		
		int status=UsersDao.save(u);
		if(status>0)
		{
			out.print("Yes register successfully");
			response.sendRedirect("updating1.html");
		}
		else
			out.print("Error in register");
	}

}

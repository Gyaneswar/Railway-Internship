package zap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zap.db.FpPage;
import zap.db.PpPage;
import zap.model.UsersDao;

/**
 * Servlet implementation class Pp
 */
@WebServlet("/zap.controller.Pp")
public class Pp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String a1,a2,a3,a4;
		int status;
		int count=Integer.parseInt(request.getParameter("itemcount").toString());
		PpPage p= new PpPage();
		for(int i=0;i<count;i++)
		{
			a1=(request.getParameterValues("Item[]"))[i];
			a2=(request.getParameterValues("Quantity[]"))[i];
			a3=(request.getParameterValues("Cumulative[]"))[i];
			a4=(request.getParameterValues("Balance[]"))[i];
			p.setItem(a1);
			p.setQuantity(a2);
			p.setCumulative(a3);
			p.setBalance(a4);
			status=UsersDao.ppSave(p);
			if(status > 0)
			{
				System.out.println("update number= "+i);
				status=0;
			}
			else
				System.out.println("update error number= "+i);	
	 }
		response.sendRedirect("pp.jsp");
	}

}

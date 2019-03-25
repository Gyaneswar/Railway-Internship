package zap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zap.db.FpPage;
import zap.model.UsersDao;

@WebServlet("/zap.controller.Fp")
public class Fp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String a1,a2,a3,a4;
		int status;
		int count=Integer.parseInt(request.getParameter("itemcount").toString());
		FpPage p= new FpPage();
		for(int i=0;i<count;i++)
		{	
			 
			a1=(request.getParameterValues("Invoice[]"))[i];
			a2=(request.getParameterValues("Amount[]"))[i];
			a3=(request.getParameterValues("Cumulative[]"))[i];
			a4=(request.getParameterValues("Balance[]"))[i];
			p.setItem(a1);
			p.setAmount(a2);
			p.setCumulative(a3);
			p.setBalance(a4);
			status=UsersDao.fpPage(p);
			if(status > 0)
			{
				System.out.println("update number= "+i);
				status=0;
			}
			else
				System.out.println("update error number= "+i);	
	 }
		response.sendRedirect("fp.jsp");
		
	}
	}

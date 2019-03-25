package zap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zap.db.BillPage;
import zap.model.UsersDao;

/**
 * Servlet implementation class Bill
 */
@WebServlet("/zap.controller.Bill")
public class Bill extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		BillPage p= new BillPage();
		p.setBill(request.getParameter("Bill"));
		p.setInvoice(request.getParameter("Invoice"));
		p.setItem(request.getParameter("Item"));
		p.setQuantity(request.getParameter("Quantity"));
		p.setRate(request.getParameter("Rate"));
		p.setBillA(request.getParameter("BillA"));
		p.setAllocation(request.getParameter("Allocation"));
		
		int status=UsersDao.billPage(p);
		if(status > 0 )
		{
			response.sendRedirect("updating2.html");
		}
		else
		{
			out.print("Enter details correctly....");
		}
	}
}

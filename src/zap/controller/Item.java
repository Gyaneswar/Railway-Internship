package zap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.SessionsTask;

import zap.db.ItemPage;
import zap.model.UsersDao;
@WebServlet("/zap.controller.Item")
public class Item extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ItemPage p=new ItemPage();
		int count=Integer.parseInt(request.getParameter("itemcount").toString());
		String a1,a2,a3;
		int status;
		for(int i=0;i<count;i++)
		{	
			 
			a1=(request.getParameterValues("Item[]"))[i];
			a2=(request.getParameterValues("Amount[]"))[i];
			a3=(request.getParameterValues("Quantity[]"))[i];
			p.setItem(a1);
			p.setAmount(a2);
			p.setQuantity(a3);
			status=UsersDao.itemSave(p);
			if(status > 0)
			{
				System.out.println("update number= "+i);
				status=0;
			}
			else
				System.out.println("update error number= "+i);	
	 }
		response.sendRedirect("updating3.html");
		
	}

}

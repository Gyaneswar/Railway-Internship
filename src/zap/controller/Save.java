package zap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zap.db.SavePage;
import zap.model.UsersDao;

@WebServlet("/zap.controller.Save")
public class Save extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int status=0;
		String ID =" ";
//		System.out.println("==================");
		HttpSession session=request.getSession();
//		String email=session.getAttribute("Email").toString();
//		System.out.println("got data from session.....");
//		System.out.println("==================");
		
		SavePage s= new SavePage();
		s.setName(request.getParameter("Name"));
		s.setLoa(request.getParameter("Loa"));
		s.setDepartment(request.getParameter("Department"));
		s.setAgree(request.getParameter("Agree"));
		s.setAgency(request.getParameter("Agency"));
		s.setContract(request.getParameter("Contract"));
		s.setCompletion(request.getParameter("Completion"));
		s.setRevenue(request.getParameter("text"));
		status=UsersDao.savePage(s);
		if(status>0)
		{
		if(request.getParameter("Loa").contains("East coast railway") || (request.getParameter("Loa").equalsIgnoreCase("East coast railway")))
			{
				ID=ID+"31";
			}
			if(request.getParameter("Name").contains("Construction") || (request.getParameter("Name").equalsIgnoreCase("Construction")))
			{
				ID=ID+"06";
			}
			ID=ID+"18";		// last two digits of the date	
			String Depart=request.getParameter("Department");
			if(Depart.equalsIgnoreCase("Accounts"))
				ID=ID+"01";
			else if(Depart.equalsIgnoreCase("Audit"))
				ID=ID+"02";
			else if(Depart.equalsIgnoreCase("Gen"))
				ID=ID+"03";
			else if(Depart.equalsIgnoreCase("Commercial"))
				ID=ID+"04";
			else if(Depart.equalsIgnoreCase("Engineering"))
				ID=ID+"05";
			else if(Depart.equalsIgnoreCase("Electrical"))
				ID=ID+"06";
			else if(Depart.equalsIgnoreCase("Mechanical"))
				ID=ID+"07";
			else if(Depart.equalsIgnoreCase("Medical"))
				ID=ID+"08";
			else if(Depart.equalsIgnoreCase("Operating"))
				ID=ID+"09";
			else if(Depart.equalsIgnoreCase("Personnel"))
				ID=ID+"10";
			else if(Depart.equalsIgnoreCase("Snt"))
				ID=ID+"11";
			else if(Depart.equalsIgnoreCase("Stories"))
				ID=ID+"12";
			else if(Depart.equalsIgnoreCase("Securities"))
				ID=ID+"13";
			else if(Depart.equalsIgnoreCase("Snb"))
				ID=ID+"20";
			int i=UsersDao.checkID();
			if(i<10)
				ID=ID+"00"+i;
			else if(i>10 && i<100)
				ID=ID+"0"+i;
			else
				ID=ID+i;
		 session.setAttribute("ID", ID);
		 session.setAttribute("Name", request.getParameter("Name"));
		 session.setAttribute("Contract", request.getParameter("Contract"));
		 out.print("System generated ID :"+ID);
		 out.print("</br>");
		 out.print("<a href='save.jsp'>save again?</a>");
		}
		else
		{
			out.print("Enter details correctly....");
		}
		
	
	}

}

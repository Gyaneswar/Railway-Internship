package zap.model;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.mail.iap.Response;

import zap.db.BillPage;
import zap.db.FpPage;
import zap.db.ItemPage;
import zap.db.PpPage;
import zap.db.Provider;
import zap.db.SavePage;
import zap.db.Users;

public class UsersDao 
{
	public static int save(Users u) 
	{
		int status =0;
		try
		{
			Connection con=Provider.getConnection();
			System.out.println("....................");
			System.out.println("connected with users......");
			String sql="Insert into users values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setString(2, u.getDepartment());
			pst.setString(3, u.getDesignation());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.setString(6, u.getPhone());
			System.out.println("seems everything cool....");
			status=pst.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("users updated.....");
		System.out.println("...................");
		return status;
	}

	public static boolean validate(Users u) 
	{
		boolean result=false;
		try
		{
			System.out.println("................................");
			System.out.println("inside validate()");
			Connection con=Provider.getConnection();
			System.out.println("connected with database.........");
			String sql="select * from users where Email=? and Password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,u.getEmail());
			pst.setString(2,u.getPassword());
			ResultSet rs =pst.executeQuery();
			System.out.println("checking...........");
			if (rs.next()) 
			{
				result=true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("checked.............");
		System.out.println(".....................");
		return result;
	}

	public static void doChangePassword() 
	{
		
	}
	public static int savePage(SavePage s)
	{
		int result=0;
		try {
		Connection con=Provider.getConnection();
		System.out.println(".................................");
		System.out.println("connected to savepage....");
		String sql="insert into savepage values(?,?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, s.getName());
		st.setString(2, s.getLoa());
		st.setString(3, s.getDepartment());
		st.setString(4, s.getAgree());
		st.setString(5, s.getAgency());
		st.setString(6, s.getContract());
		st.setString(7, s.getCompletion());
		st.setString(8, s.getRevenue());
		 result=st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 System.out.println("savepage updated...........");
		System.out.println("...............");
		return result;
	}
	public static String checkDepart(String email)
	{
		String Depart=null;
		try
		{
			Connection con=Provider.getConnection();
			String sql="select department from users where Email=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,email);
			ResultSet status=st.executeQuery();
            while (status.next()) {
            	Depart = status.getString("email");
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Depart;
	}
	public static int checkID()
	{
		int count=0;;
		try
		{
			Connection con=Provider.getConnection();
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM savepage");
			r.next();
			count = r.getInt("rowcount") ;
			r.close() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static int itemSave(ItemPage p)
	{
		int status=0;
		try {
			Connection con=Provider.getConnection();
			System.out.println(".................................");
			System.out.println("connected to itempage....");
			String sql="insert into itempage values(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,p.getItem());
			st.setString(2, p.getAmount());
			st.setString(3, p.getQuantity());
			 status=st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Itempage updated.....");
		System.out.println("......................");
		return status;
	}
	
	public static String forgotPassword(String email)
	{
		String question="";
		String sql="select question from users where email=?";
		
		return question;
	}
	
	public static int billPage(BillPage s)
	{
		int result=0;
		try {
		Connection con=Provider.getConnection();
		System.out.println(".................................");
		System.out.println("connected to billpage....");
		String sql="insert into billpage values(?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, s.getBill());
		st.setString(2, s.getInvoice());
		st.setString(3, s.getItem());
		st.setString(4, s.getQuantity());
		st.setString(5, s.getRate());
		st.setString(6, s.getBillA());
		st.setString(7, s.getAllocation());
		 result=st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 System.out.println("billpage updated...........");
		System.out.println("...............");
		return result;
	}
	public static int fpPage(FpPage f)
	{
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			System.out.println(".................................");
			System.out.println("connected to fppage....");
			String sql="insert into fppage values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, f.getItem());
			st.setString(2, f.getAmount());
			st.setString(3, f.getCumulative());
			st.setString(4, f.getBalance());
			status=st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("updated....");
		return status;
	}
	public static int ppSave(PpPage f)
	{
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			System.out.println(".................................");
			System.out.println("connected to pppage....");
			String sql="insert into fppage values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, f.getItem());
			st.setString(2, f.getQuantity());
			st.setString(3, f.getCumulative());
			st.setString(4, f.getBalance());
			status=st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("updated....");
		return status;
	}
}


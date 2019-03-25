package zap.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Provider 
{
	private static Connection con=null;
	public static Connection getConnection()
	{
		try
		{
			if(con==null)
			{
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sss");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}

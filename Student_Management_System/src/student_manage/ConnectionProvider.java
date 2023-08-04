package student_manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	public static Connection creatConn()
	{
		
		try {
			// 1. load driver
			Class.forName("com.cj.mysql.jdbc.Driver");
			
			//2. create connection
			String user="root";
			String password="1234";
			String url="jdbc:mysql://localhost:3306/student_management_system";
			
			
			con=DriverManager.getConnection(url, user, password);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}

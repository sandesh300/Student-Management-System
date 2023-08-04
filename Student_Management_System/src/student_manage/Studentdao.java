package student_manage;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Studentdao {
	
	public static boolean insertStudentDB(Student st)
	{
		boolean flag=false;
		try {
			//jdbc code

			Connection con = ConnectionProvider.creatConn();
           String q="insert into student(s_name, s_phone, s_city) values(?,?,?)";
           //preparestatement
           PreparedStatement pstmt= con.prepareStatement(q);			
           pstmt.setString(1, st.getstudentName());
           pstmt.setString(2, st.getstudentPhone());
           pstmt.setString(3, st.getstudentCity());
           
           //execute query
           pstmt.executeUpdate();
           flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudentDB(int studenttId) {
		boolean flag=false;
		try {
			//jdbc code

			Connection con = ConnectionProvider.creatConn();
           String q="delete from student where s_id=?";
           // preparedStatement
           PreparedStatement pstmt= con.prepareStatement(q);			
           pstmt.setInt(1, studenttId);
         
           //execute query
           pstmt.executeUpdate();
           flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}

	public static void showAllStudents() {
		
			
		try {
			//jdbc code

			Connection con = ConnectionProvider.creatConn();
           String q="select * from student";
           //preparestatement
         Statement st = con.createStatement();
           //execute query
          ResultSet set= st.executeQuery(q);
          
          while(set.next())
          {
        	  int id=set.getInt(1);
        	  String name=set.getString(2);
        	  String phone = set.getString(3);
        	  String city=set.getString(4);
        	  
        	  System.out.println("ID : "+id);
        	  System.out.println("Name: "+name);
        	  System.out.println("Phone"+phone);
        	  System.out.println("City: "+city);
        	  System.out.println("=======================================================");
        	  
          }
          
          
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

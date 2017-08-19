package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DatabaseConnection {

// Method to connect to the database	
	public void testdb() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
	    //"jdbc:mysql://localhost:port/dbname","username","password");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","samir");
		System.out.println("Connected to MySql DB");
	}
	
	

	//Statement smt= con.createStatement();
//	ResultSet rs= smt.executeQuery("select * from seleniumuser");
//			
//    while(rs.next()){
//    	
//    	String FirstName = rs.getString("firstname");
//    	System.out.println("Database Record is "+ FirstName);
//    	
//    	String EmailAddress = rs.getString("email");
//    	System.out.println("Email Record is "+ EmailAddress);
//    }

}

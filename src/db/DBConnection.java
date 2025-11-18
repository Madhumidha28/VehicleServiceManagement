package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	// database connection code

	public static void main(String[] args) {
		
		try {
			//server details
			String url = "jdbc:mysql://localhost:3306/vehicleservice";
			String user = "root";
			String pass = "1870";
			
			//connection
			Connection con = DriverManager.getConnection(url, user, pass); 
			
			System.out.println("✅ Database Connected Successfully!");

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public static Connection getConnection() {
		 try 
		 {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicleservice", "root", "1870");
		 }
		 catch (Exception e)
		 {
	        e.printStackTrace();
	        return null;
		 }
	}

}

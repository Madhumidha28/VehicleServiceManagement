package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import model.Customer;

public class CustomerDAO {
	Connection con = DBConnection.getConnection();
	
	//create
	public boolean addCustomer(Customer c) throws SQLException {
		PreparedStatement pst = con.prepareStatement("insert into customer (cName, PhoneNo, EmailID) values (?,?,?)");
		pst.setString(1, c.getcName());
		pst.setString(2, c.getPhoneNo());
		pst.setString(3, c.getEmailID());
		
		int rs = pst.executeUpdate();
		
		return rs > 0;
	}
	
	//Read
	public ArrayList<Customer> viewCustomers() throws SQLException {
		ArrayList<Customer> customers = new ArrayList<>();
		PreparedStatement pst = con.prepareStatement("select * from Customer");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			customers.add(c); 
		}
		return customers; 
	}
	
	//Update
	public boolean editCustomer(Customer c) throws SQLException {
		PreparedStatement pst = con.prepareStatement("update Customer set  cName = ?, PhoneNo = ?, EmailID = ? where cID = ?");
		pst.setString(1, c.getcName());
		pst.setString(2, c.getPhoneNo());
		pst.setString(3, c.getEmailID());
		pst.setInt(4, c.getcID());
		
		int rs = pst.executeUpdate();
		
		return rs > 0;
	}
	
	//Specific update
	public boolean updateSpecificField(int id, int choice, String newValue) throws SQLException {
	    String q = "";

	    switch (choice) {
	        case 1:
	        	q = "update Customer set cName = ? where cID = ?";
	        	break;
	        case 2:
	        	q = "update Customer set PhoneNo = ? where cID = ?";
	        	break;
	        case 3:
	        	q = "update Customer set EmailID = ? where cID = ?";
	        	break;
	        default:
	        {
	            System.out.println("Invalid choice!");
	            return false;
	        }
	    }

	    PreparedStatement pst = con.prepareStatement(q);
	    pst.setString(1, newValue);
	    pst.setInt(2, id);
	    
	    return pst.executeUpdate() > 0;
	}

	
	//delete
	public boolean removeCustomer(int cID) throws SQLException {
        String sql = "delete from Customer where cID = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, cID);

        int rs = pst.executeUpdate();
     
        return rs > 0;   
    }
}

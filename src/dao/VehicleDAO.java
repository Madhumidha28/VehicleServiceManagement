package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import model.Vehicle;

public class VehicleDAO {

	    Connection con = DBConnection.getConnection();

	    //create
	    public boolean addVehicle(Vehicle v) throws SQLException { 
	    	PreparedStatement pst = con.prepareStatement("insert into Vehicle (CustomerID, Vehicle_No, Model, Type) values (?,?,?,?)");
			pst.setInt(1, v.getcID());
			pst.setString(2, v.getVehicleNum());
			pst.setString(3, v.getvModel());
			pst.setString(4, v.getvType());
			
			int rs = pst.executeUpdate();
			
			return rs > 0;
	    }
	    
	    //read
	    public ArrayList<Vehicle> viewVehicles() throws SQLException { 
	    	ArrayList<Vehicle> vehicles = new ArrayList<>();
			PreparedStatement pst = con.prepareStatement("select * from Vehicle");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Vehicle v = new Vehicle(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				vehicles.add(v); 
			}
			return vehicles; 
	    }  
	    
	    //update
	    public boolean editVehicle(Vehicle v) throws SQLException { 
	    	PreparedStatement pst = con.prepareStatement("update Vehicle set Model = ?, Type = ? where VehicleID = ?");
			pst.setString(1, v.getvModel());
			pst.setString(2, v.getvType());
			pst.setInt(3, v.getvID());
			
			int rs = pst.executeUpdate();
			 
			return rs > 0;
	    }

	    //delete
	    public boolean removeVehicle(int vID) throws SQLException {
	    	String sql = "delete from Vehicle where VehicleID = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1, vID);

	        int rs = pst.executeUpdate();
	     
	        return rs > 0; 
	    }
	
}

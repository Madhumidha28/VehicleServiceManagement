package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import model.Service;

public class ServiceDAO {
	Connection con = DBConnection.getConnection();
	
	//create
    public boolean addService(Service s) throws SQLException { 
    	PreparedStatement pst = con.prepareStatement("insert into service (VehicleID, ServiceType, ServiceDate, Status, Cost) values (?,?,?,?,?)");
		pst.setInt(1, s.getvID());
		pst.setString(2, s.getsType());
		pst.setString(3, s.getsDate());
		pst.setString(4, s.getsStatus());
		pst.setInt(5, s.getsCost());
		
		int rs = pst.executeUpdate();
		
		return rs > 0;
    }
    
    //read
    public ArrayList<Service> viewServices() throws SQLException { 
    	ArrayList<Service> services = new ArrayList<>();
		PreparedStatement pst = con.prepareStatement("select * from Service");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			Service s = new Service(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			services.add(s); 
		}
		return services; 
    }
    
    //update
    public boolean editService(Service s) throws SQLException { 
    	PreparedStatement pst = con.prepareStatement("update Service set ServiceDate = ?, Status = ? where ServiceID = ?");
		pst.setString(1, s.getsDate());
		pst.setString(2, s.getsStatus());
		pst.setInt(3, s.getsID());
		
		int rs = pst.executeUpdate();
		
		return rs > 0;
    }
    
    //delete
    public boolean removeService(int sID) throws SQLException { 
    	String sql = "delete from Service where ServiceID = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, sID);

        int rs = pst.executeUpdate();
     
        return rs > 0;   
    }
}

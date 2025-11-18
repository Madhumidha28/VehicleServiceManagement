package model;

public class Vehicle {

	private int vID;
	private int cID;
	private String vehicleNum;
	private String vModel;
	private String vType;
	
	public Vehicle(int vID, int cID, String vehicleNum, String vModel, String vType) {
		super();
		this.vID = vID;
		this.cID = cID;
		this.vehicleNum = vehicleNum;
		this.vModel = vModel;
		this.vType = vType;
	}

	public int getvID() {
		return vID;
	}

	public void setvID(int vID) {
		this.vID = vID;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getvModel() {
		return vModel;
	}

	public void setvModel(String vModel) {
		this.vModel = vModel;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}
}

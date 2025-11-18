package model;

public class Service {

	private int sID;
	private int vID;
	private String sType;
	private String sDate;
	private String sStatus;
	private int sCost;
	
	public Service(int sID, int vID, String sType, String sDate, String sStatus, int sCost) {
		super();
		this.sID = sID;
		this.vID = vID;
		this.sType = sType;
		this.sDate = sDate;
		this.sStatus = sStatus;
		this.sCost = sCost;
	}

	public Service(int sID2, String sDate2, String sStatus2) {
		super();
		this.sID = sID2;
		this.sDate = sDate2;
		this.sStatus = sStatus2;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public int getvID() {
		return vID;
	}

	public void setvID(int vID) {
		this.vID = vID;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getsStatus() {
		return sStatus;
	}

	public void setsStatus(String sStatus) {
		this.sStatus = sStatus;
	}

	public int getsCost() {
		return sCost;
	}

	public void setsCost(int sCost) {
		this.sCost = sCost;
	}
	
}

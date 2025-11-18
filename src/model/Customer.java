package model;

public class Customer {
	
		private int cID;
		private String cName;
		private String PhoneNo;
		private String EmailID;
		
		public Customer(int cID, String cName, String PhoneNo, String EmailID) {
			super();
			this.cID = cID;
			this.cName = cName;
			this.PhoneNo = PhoneNo;
			this.EmailID = EmailID;
		} 

		public int getcID() {
			return cID;
		}

		public void setcID(int cID) {
			this.cID = cID;
		}

		public String getcName() {
			return cName;
		}

		public void setcName(String cName) {
			this.cName = cName;
		}

		public String getPhoneNo() {
			return PhoneNo;
		}

		public void setcPhoneNo(String PhoneNo) {
			this.PhoneNo = PhoneNo;
		}

		public String getEmailID() {
			return EmailID;
		}

		public void setcEmailID(String EmailID) {
			this.EmailID = EmailID;
		}
}

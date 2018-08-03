package com.revature.projectone.model;

public class Guest {
	private String guestName;
	private int guestAge;
	private String guestEmail;
	private String guestPassword;
	private int isVIP;
	
	public Guest() {
		super();
	}
	
	public Guest(String guestName, int guestAge, String guestEmail, int isVIP) {
		super();
		this.guestName = guestName;
		this.guestAge = guestAge;
		this.guestEmail = guestEmail;
		this.isVIP = isVIP;
	}
	
	public Guest(String guestName, int guestAge, String guestEmail, String guestPassword, int isVIP) {
		this(guestName, guestAge, guestEmail,isVIP);
		this.guestPassword = guestPassword;
	}
	
	public String getGuestName() {
		return guestName;
	}
	public int getGuestAge() {
		return guestAge;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public String getGuestPassword() {
		return guestPassword;
	}
	public int getIsVIP() {
		return isVIP;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public void setGuestAge(int guestAge) {
		this.guestAge = guestAge;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public void setGuestPassword(String guestPassword) {
		this.guestPassword = guestPassword;
	}

	public void setIsVIP(int isVIP) {
		this.isVIP = isVIP;
	}
	
	@Override
	public String toString() {
		return "Guest [guestName= " + guestName + ", guestAge= " + guestAge + ", guestEmail= " + guestEmail
				+  ", isVIP= " + ((isVIP==1) ? "Yes": "No") + "]\n";
	}
}

package com.revature.projectone.model;

import java.sql.Date;

public class Reservation {
	private String guestEmail;
	private String hostName;
	private int roomNumber;
	private Date dateReserved;
	private Date dateCheckin;

	public Reservation() {
		super();
	}
	
	
	public Reservation(String guestEmail, int roomNumber, Date dateReserved, Date dateCheckin) {
		this();
		this.guestEmail = guestEmail;
		this.roomNumber = roomNumber;
		this.dateReserved = dateReserved;
		this.dateCheckin = dateCheckin;
	}
	
	public Reservation(String guestEmail, String hostName, int roomNumber, Date dateReserved, Date dateCheckin) {
		this(guestEmail, roomNumber, dateReserved, dateCheckin);
		this.hostName = hostName;
	}

	public String getHostName() {
		return hostName;
	}
	
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	public String getGuestEmail() {
		return guestEmail;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public Date getDateReserved() {
		return dateReserved;
	}
	
	public Date getDateCheckin() {
		return dateCheckin;
	}


	@Override
	public String toString() {
		return "Reservation [guestEmail=" + guestEmail + ", hostName=" + hostName + ", roomNumber=" + roomNumber
				+ ", dateReserved=" + dateReserved + ", dateCheckin=" + dateCheckin + "]\n";
	}
	
}

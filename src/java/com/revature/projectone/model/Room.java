package com.revature.projectone.model;

public class Room {
	private int roomNumber;
	private int roomIsOccupied;
	private String roomGuestEmail;
	
	public Room() {
		super();
	}
	
	public Room(int roomNumber, int roomIsOccupied, String GuestEmail) {
		this();
		this.roomNumber = roomNumber;
		this.roomIsOccupied = roomIsOccupied;
		this.roomGuestEmail = GuestEmail;
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	public int getRoomIsOccupied() {
		return roomIsOccupied;
	}
	public String getRoomGuestEmail() {
		return roomGuestEmail;
	}

	@Override
	public String toString() {
		return "Room [roomNumber= " + roomNumber + ", roomIsOccupied= " + ((roomIsOccupied==1)?"Yes":"No") + ", roomGuestName= "
				+ roomGuestEmail + "]\n";
	}
	
	

}

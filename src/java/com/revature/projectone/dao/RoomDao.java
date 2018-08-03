package com.revature.projectone.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.model.Room;
import com.revature.projectone.util.ConnectionUtil;

public class RoomDao {
	private static final String SELECT = "SELECT * from Rooms";
	private static final String INSERT = "INSERT INTO Rooms VALUES(?,?,?,?)";
	private static final String SELECTAVAILABLEROOMS = "SELECT * from Rooms Where Room_IsOccupied = ?";
	
	public static List<Room> getAllRoom() {
		PreparedStatement ps = null;
		Room room = null;
		List<Room> rooms = new ArrayList<>();
		
		
		int roomNumber = 0;
		int roomIsOccupied = 0;
		String roomGuestName = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				roomNumber = rs.getInt("Room_Number");
				roomIsOccupied = rs.getInt("Room_IsOccupied");
				roomGuestName = rs.getString("Room_GuestName");
				
				room = new Room(roomNumber, roomIsOccupied, roomGuestName);
				rooms.add(room);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return rooms;
	}
	
	public static List<Room> getAvailableRooms() {
		PreparedStatement ps = null;
		Room room = null;
		List<Room> rooms = new ArrayList<>();
		
		
		int roomNumber = 0;
		int roomIsOccupied = 0;
		String roomGuestEmail = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTAVAILABLEROOMS);
			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				roomNumber = rs.getInt("Room_Number");
				roomIsOccupied = rs.getInt("Room_IsOccupied");
				roomGuestEmail = rs.getString("Room_GuestName");
				
				room = new Room(roomNumber, roomIsOccupied, roomGuestEmail);
				rooms.add(room);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return rooms;
	}
	
	public static String saveRoom(Room room) {
		String response = null;
		PreparedStatement ps = null;
		
		int roomNumber = room.getRoomNumber();
		int isOccupied = room.getRoomIsOccupied();
		String guestName = room.getRoomGuestEmail();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(INSERT);
			ps.setInt(1, 16);
			ps.setInt(2, roomNumber);
			ps.setInt(3, isOccupied);
			ps.setString(4, guestName);
			ps.executeQuery();
			
			ps.close();
			
			response = "Saved";
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
			response = "Failed";
		}
		
		return response;
	}
}

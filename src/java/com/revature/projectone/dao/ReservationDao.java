package com.revature.projectone.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.model.Reservation;
import com.revature.projectone.util.ConnectionUtil;

public class ReservationDao {
	private static final String SELECT = "SELECT * from Reservations";
	private static final String INSERT = "INSERT INTO Reservations VALUES(?,?,?,?,?,?)";
	private static final String DELETE = "DELETE from  Reservations";
	
	public static List<Reservation> getAllReservations() {
		PreparedStatement ps = null;
		Reservation reservation = null;
		List<Reservation> reservations = new ArrayList<>();
		
		String guestEmail = null;
		String hostName = null;
		int roomNumber = 0;
		Date dateReserve = null;
		Date dateCheckin = null;
		
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				guestEmail = rs.getString("Guest_Email");
				hostName = rs.getString("Host_Name");
				roomNumber = rs.getInt("Room_Number");
				dateReserve = rs.getDate("Date_Reserved");
				dateCheckin = rs.getDate("Date_CheckIn");
				
				reservation = new Reservation(guestEmail, hostName, roomNumber, dateReserve, dateCheckin);
				reservations.add(reservation);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return reservations;
	}
	
	public String makeReservation(Reservation reservation) {
		String response = null;
		PreparedStatement ps = null;
		
		String guestEmail = reservation.getGuestEmail();
		String hostName = reservation.getHostName();
		int roomNumber = reservation.getRoomNumber();
		Date rs = reservation.getDateReserved();
		Date ci = reservation.getDateCheckin();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(INSERT);
			
			ps.setInt(1, 16);
			ps.setString(2, guestEmail);
			ps.setString(3, hostName);
			ps.setInt(4, roomNumber);
			ps.setDate(5, rs);
			ps.setDate(6, ci);
			
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

package com.revature.projectone.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.model.Guest;
import com.revature.projectone.util.ConnectionUtil;

public class GuestDao {
	private static final String SELECT = "SELECT * from HotelGuest";
	private static final String SELECTBYEMAIL = "SELECT * from HotelGuest WHERE guest_email = ?";
	private static final String SELECTBYEMAILANDPASS = "SELECT * from HotelGuest WHERE guest_email = ? and guest_password = ?";
	private static final String INSERT = "INSERT INTO HotelGuest (guest_name, guest_age, guest_email, guest_password, guest_isvIP) VALUES(?,?,?,?,?)";
	private static final String DELETE = "DELETE from HotelGuest";
	
	
	public static List<Guest> getAllGuest() {
		PreparedStatement ps = null;
		Guest guest = null;
		List<Guest> guests = new ArrayList<>();
		
		String guestName = null;
		int guestAge = 0;
		String guestEmail = null;
		int guestIsVIP = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				guestName = rs.getString("Guest_Name");
				guestAge = rs.getInt("Guest_Age");
				guestEmail = rs.getString("Guest_Email");
				guestIsVIP = rs.getInt("Guest_IsVIP");
				
				guest = new Guest(guestName, guestAge, guestEmail, guestIsVIP);
				guests.add(guest);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return guests;
	}
	
	public static String getGuestNameFromEmail(String email) {
		PreparedStatement ps = null;
		
		String guestName = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTBYEMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				guestName = rs.getString("Guest_Name");
			
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return guestName;
	}
	
	public static boolean checkGuestUserFromEmail(String email) {
		PreparedStatement ps = null;
		
		String guestEmail = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTBYEMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				guestEmail = rs.getString("Guest_Email");
			
			}
			
			rs.close();
			ps.close();
		} catch (SQLIntegrityConstraintViolationException ex) {
			ex.printStackTrace();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return (guestEmail.equals(email));
	}
	
	public static boolean checkGuestPassFromUser (String email, String pass) {
	PreparedStatement ps = null;
		
		String guestEmail = null;
		String guestPass = "";
		
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTBYEMAILANDPASS);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				guestEmail = rs.getString("Guest_Email");
				guestPass = rs.getString("Guest_Password");
			
			}
			
			rs.close();
			ps.close();
		} catch (SQLIntegrityConstraintViolationException ex) {
			return false;
		} catch(SQLException | IOException ex) {
			return false;
		}
		
		
		
		
		
		return (guestPass.equals(pass)); //TODO
	}
	
	public static String saveGuest(Guest guest) {
		String response = null;
		PreparedStatement ps = null;
		
		String guestName = guest.getGuestName();
		int guestAge = guest.getGuestAge();
		String guestEmail = guest.getGuestEmail();
		String guestPass = guest.getGuestPassword();
		int guestIsVip = guest.getIsVIP();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, guestName);
			ps.setInt(2, guestAge);
			ps.setString(3, guestEmail);
			ps.setString(4, guestPass);
			ps.setInt(5, guestIsVip);
			ps.executeQuery();
			
			ps.close();
			
			response = "Saved";
		} catch(SQLException | IOException ex) {
			response = "Failed";
		}
		
		return response;
	}
}
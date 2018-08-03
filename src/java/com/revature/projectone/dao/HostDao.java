package com.revature.projectone.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.model.Host;
import com.revature.projectone.util.ConnectionUtil;

public class HostDao {
	private static final String SELECT = "SELECT * from Host";
	private static final String INSERT = "INSERT INTO Host VALUES(?,?,?,?,?)";
	private static final String SELECTBYEMAIL = "SELECT * from Host WHERE host_email = ?";
	private static final String SELECTBYEMAILANDPASS = "SELECT * from Host WHERE host_email = ? and host_password = ?";

	private static final String DELETE = "DELETE from Host";
	
	public List<Host> getAllHost() {
		PreparedStatement ps = null;
		Host host = null;
		List<Host> hosts = new ArrayList<>();
		
		String hostName = null;
		String hostTitle = null;
		String hostEmail = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				hostName = rs.getString("Host_Name");
				hostTitle = rs.getString("Host_Title");
				hostEmail = rs.getString("Host_Email");
				
				host = new Host(hostName, hostTitle, hostEmail);
				hosts.add(host);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return hosts;
	}
	
	public String saveHost(Host host) {
		String response = null;
		PreparedStatement ps = null;
		
		String hostName = host.getHostName();
		String hostTitle = host.getHostTitle();
		String hostEmail = host.getHostEmail();
		String hostPass = host.getHostPassword();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(INSERT);
			ps.setInt(1, 11);
			ps.setString(2, hostName);
			ps.setString(3, hostTitle);
			ps.setString(4, hostEmail);
			ps.setString(5, hostPass);
			ps.executeQuery();
			
			ps.close();
			
			response = "Saved";
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
			response = "Failed";
		}
		
		return response;
	}
	
	public static boolean checkHostUserFromEmail(String email) {
		PreparedStatement ps = null;
		
		String hostEmail = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTBYEMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				hostEmail = rs.getString("Host_Email");
			
			}
			rs.close();
			ps.close();
		} catch (SQLIntegrityConstraintViolationException ex) {
			ex.printStackTrace();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return (hostEmail.equals(email));
	}
	
	public static boolean checkHostPassFromUser (String email, String pass) {
	PreparedStatement ps = null;
		
		String hostEmail = null;
		String hostPass = "";
		
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTBYEMAILANDPASS);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				hostEmail = rs.getString("Host_Email");
				hostPass = rs.getString("Host_Password");
			
			}
			
			rs.close();
			ps.close();
		} catch (SQLIntegrityConstraintViolationException ex) {
			return false;
		} catch(SQLException | IOException ex) {
			return false;
		}
		
		
		
		
		
		return (hostPass.equals(pass)); //TODO
	}
	
	public static String getHostNameFromEmail(String email) {
		PreparedStatement ps = null;
		
		String hostName = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECTBYEMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				hostName = rs.getString("Host_Name");
			
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return hostName;
	}
}

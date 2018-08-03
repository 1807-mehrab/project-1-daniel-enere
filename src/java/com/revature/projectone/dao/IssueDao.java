package com.revature.projectone.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectone.model.Issue;
import com.revature.projectone.util.ConnectionUtil;

public class IssueDao {
	private static final String SELECT = "SELECT * from Issues";
	private static final String INSERT = "INSERT INTO Issues VALUES(?,?,?,?)";
	private static final String DELETE = "DELETE from  Issues";
	
	public static List<Issue> getAllIssues() {
		PreparedStatement ps = null;
		Issue issue = null;
		List<Issue> issues = new ArrayList<>();
		
		Date issueDate = null;
		String issueComment = null;
		String guestEmail = null;
		
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				issueDate = rs.getDate("Issue_Date");
				issueComment = rs.getString("Issue_Comment");
				guestEmail = rs.getString("Guest_Email");
				
				issue = new Issue (issueDate, issueComment, guestEmail);
				issues.add(issue);
			}
			
			rs.close();
			ps.close();
		} catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return issues;
	}
	
	public String saveIssue(Issue issue) {
		String response = null;
		PreparedStatement ps = null;
		
		Date issueDate = issue.getIssueDate();
		String issueComment = issue.getIssueComment();
		String guestEmail = issue.getGuestEmail();
		
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(INSERT);
			
			ps.setInt(1, 4);
			ps.setDate(2, issueDate);
			ps.setString(3, issueComment);
			ps.setString(4, guestEmail);
			
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

package com.revature.projectone.model;

import java.sql.Date;

public class Issue {
	private Date issueDate;
	private String issueComment;
	private String guestEmail;
	
	public Issue() {
		super();
	}
	
	public Issue(Date issueDate, String issueComment, String guestEmail) {
		this();
		this.issueDate = issueDate;
		this.issueComment = issueComment;
		this.guestEmail = guestEmail;
	}
	
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getIssueComment() {
		return issueComment;
	}
	public void setIssueComment(String issueComment) {
		this.issueComment = issueComment;
	}

	@Override
	public String toString() {
		return "{ \"email\": " + "\"" + guestEmail + "\", \"comment\":" + "\"" + issueComment + "\", \"date\":"  + "\"" +  issueDate + "\"}";
	}

	public String getGuestEmail() {
		return guestEmail;
	}
}

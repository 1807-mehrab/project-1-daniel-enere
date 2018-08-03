package com.revature.projectone.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class IssueTest {

	@Test
	public void testGetIssueDate() {
		Date date = new Date(0);
		Issue issue = new Issue(new Date(0), "This is a comment", "MyEmail");
		assertEquals(date, issue.getIssueDate());
	}

	@Test
	public void testSetIssueDate() {
		Date date = new Date(0);
		Issue issue = new Issue();
		issue.setIssueDate(date);
		assertEquals(date, issue.getIssueDate());
	}

	@Test
	public void testGetIssueComment() {
		Issue issue = new Issue(new Date(0), "This is a comment", "MyEmail");
		assertEquals("This is a comment", issue.getIssueComment());
	}

	@Test
	public void testSetIssueComment() {
		Issue issue = new Issue();
		issue.setIssueComment("Test comment");
		assertEquals("Test comment", issue.getIssueComment());
	}

	@Test
	public void testGetGuestEmail() {
		Issue issue = new Issue(new Date(0),"test", "guestEmail");
		assertEquals("guestEmail", issue.getGuestEmail());
	}

}

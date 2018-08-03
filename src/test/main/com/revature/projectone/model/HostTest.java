package com.revature.projectone.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HostTest {

	@Test
	public void testGetHostName() {
		Host host = new Host("Host Name", "Manager", "Email");
		assertEquals("Host Name", host.getHostName());
	}

	@Test
	public void testGetHostTitle() {
		Host host = new Host("Host Name", "Staff", "StaffEmail");
		assertEquals("Staff", host.getHostTitle());
	}

	@Test
	public void testGetHostEmail() {
		Host host = new Host("Test Name", "Test Title", "TestEmail");
		assertEquals("TestEmail", host.getHostEmail());
	}

}

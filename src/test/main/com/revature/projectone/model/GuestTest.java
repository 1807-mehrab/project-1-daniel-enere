package com.revature.projectone.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GuestTest {

	@Test
	public void testGetGuestName() {
		
		Guest guest = new Guest("Daniel", 24, "Email", 1);
		assertEquals("Daniel", guest.getGuestName());
	}

	@Test
	public void testGetGuestAge() {
		Guest guest = new Guest("Daniel", 24, "Email", 1);
		assertEquals(24, guest.getGuestAge());
	}

	@Test
	public void testGetGuestEmail() {
		Guest guest = new Guest("Daniel", 24, "Email", 1);
		assertEquals("Email", guest.getGuestEmail());
	}


	@Test
	public void testGetIsVIP() {
		Guest guest = new Guest("Daniel", 24, "Email", 1);
		assertEquals(1, guest.getIsVIP());
	}

	@Test
	public void testSetGuestName() {
		Guest guest = new Guest();
		guest.setGuestName("Daniel");
		assertEquals("Daniel", guest.getGuestName());
	}

	@Test
	public void testSetGuestAge() {
		Guest guest = new Guest();
		guest.setGuestAge(25);
		assertEquals(25, guest.getGuestAge());
	}

	@Test
	public void testSetGuestEmail() {
		Guest guest = new Guest();
		guest.setGuestEmail("Email");
		assertEquals("Email", guest.getGuestEmail());
	}


	@Test
	public void testSetIsVIP() {
		Guest guest = new Guest();
		guest.setIsVIP(0);
		assertEquals(0, guest.getIsVIP());
	}

}

package com.revature.projectone.service;

import com.revature.projectone.dao.GuestDao;
import com.revature.projectone.dao.HostDao;

public class LoginVerification {
	public static String hostOrGuest(String email, String pass) {
		String response = "Does Not Exist";
		boolean doesHostExist = HostDao.checkHostUserFromEmail(email);
		
		
		
		if(doesHostExist) {
			boolean doesPassExist = HostDao.checkHostPassFromUser(email, pass);
			if(doesPassExist) {
				response = "Host";
			}
		}else if(!doesHostExist) {
			boolean doesUserExist = GuestDao.checkGuestUserFromEmail(email);
			if(doesUserExist) {
				boolean doesPassExist = GuestDao.checkGuestPassFromUser(email, pass);
				if (doesPassExist) {
					response = "Guest";
				} else {
					
					response = "Wrong Pass";
				}
					
			} else {
				response = "No Host or Guest";
			}
		}
		
		return response;
	}
}

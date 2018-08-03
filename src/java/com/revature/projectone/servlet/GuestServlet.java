package com.revature.projectone.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.dao.GuestDao;
import com.revature.projectone.dao.RoomDao;
import com.revature.projectone.model.Guest;
import com.revature.projectone.model.Room;

/**
 * Servlet implementation class GuestServlet
 */
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Guest> guests = GuestDao.getAllGuest();
		ObjectMapper mapper = new ObjectMapper();
		String jsonGuests = mapper.writeValueAsString(guests);
		
		
		PrintWriter pw = response.getWriter();
	
		pw.println(jsonGuests);
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

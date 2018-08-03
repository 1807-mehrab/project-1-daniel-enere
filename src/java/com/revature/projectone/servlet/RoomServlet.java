package com.revature.projectone.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.dao.RoomDao;
import com.revature.projectone.model.Room;

/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

		List<Room> rooms = RoomDao.getAllRoom();
		ObjectMapper mapper = new ObjectMapper();
		String jsonRooms = mapper.writeValueAsString(rooms);
		
		
		PrintWriter pw = res.getWriter();
	
		pw.println(jsonRooms);
		pw.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Room> rooms = RoomDao.getAvailableRooms();
		ObjectMapper mapper = new ObjectMapper();
		String jsonRooms = mapper.writeValueAsString(rooms);
		
		
		PrintWriter pw = res.getWriter();
	
		pw.println(jsonRooms);
		pw.close();
	}

}

package com.revature.projectone.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.dao.ReservationDao;
import com.revature.projectone.model.Reservation;


public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reservation> Reservations = ReservationDao.getAllReservations();
		ObjectMapper mapper = new ObjectMapper();
		String jsonReservations = mapper.writeValueAsString(Reservations);
		
		
		PrintWriter pw = response.getWriter();
	
		pw.println(jsonReservations);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

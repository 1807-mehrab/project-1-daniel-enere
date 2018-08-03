package com.revature.projectone.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.projectone.dao.GuestDao;
import com.revature.projectone.service.LoginVerification;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		
		String response =  LoginVerification.hostOrGuest(email, pass);
		String guestName;
		System.out.println(response);
		
		switch (response) {
		case "Host": RequestDispatcher rdHost = req.getRequestDispatcher("HostPortal");req.setAttribute("email", email); rdHost.forward(req, res); break;
		case "Guest": RequestDispatcher rd = req.getRequestDispatcher("GuestPortal"); guestName = GuestDao.getGuestNameFromEmail(email); req.setAttribute("email", email); rd.forward(req, res); break;
		case "Wrong Pass": res.sendError(HttpServletResponse.SC_BAD_REQUEST); break;
		case "No Host or Guest": res.sendError(HttpServletResponse.SC_BAD_REQUEST); break;
		default: res.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}

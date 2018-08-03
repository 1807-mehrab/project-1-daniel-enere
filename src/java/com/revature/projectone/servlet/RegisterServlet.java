package com.revature.projectone.servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.projectone.dao.GuestDao;
import com.revature.projectone.model.Guest;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static String USER_EXISTS = "User already exists";
	
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("register.html");
		response.sendRedirect("register.html");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String emailToValidate = req.getParameter("email");
		RequestDispatcher rd = req.getRequestDispatcher("Portal");
		PrintWriter pw = res.getWriter();
		
		boolean doesUserExist = GuestDao.checkGuestUserFromEmail(emailToValidate);
		
		if (doesUserExist) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST, USER_EXISTS);
			
		} else {
			Guest newGuest = new Guest();
			newGuest.setGuestEmail(req.getParameter("email"));
			newGuest.setGuestName(req.getParameter("name"));
			newGuest.setGuestAge(Integer.parseInt(req.getParameter("age")));
			newGuest.setGuestPassword(req.getParameter("password"));
			if (req.getParameter("VIP")==null) {
				newGuest.setIsVIP(0);
			} else {
				newGuest.setIsVIP(1);
			}
			
			
			
			pw.println();
			GuestDao.saveGuest(newGuest);
			
			req.setAttribute("email", newGuest.getGuestEmail());
			req.setAttribute("password", newGuest.getGuestPassword());
			rd.forward(req, res);
		}
	}

}

package com.revature.projectone.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.projectone.dao.IssueDao;
import com.revature.projectone.model.Issue;

/**
 * Servlet implementation class IssueServlet
 */
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Issue> Issues = IssueDao.getAllIssues();
		ObjectMapper mapper = new ObjectMapper();
		String jsonIssues = mapper.writeValueAsString(Issues);
		
		
		PrintWriter pw = response.getWriter();
	
		pw.println(jsonIssues);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Object test = mapper.readValue(request.getInputStream(), Issue.class);
		System.out.println(test);
	}

}

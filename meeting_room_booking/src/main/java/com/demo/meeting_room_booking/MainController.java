package com.demo.meeting_room_booking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private RoomBookingDAO roomBookingDAO;
	private UserDAO userDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        //roomBookingDAO = new RoomBookingDAO(jdbcURL, jdbcUsername, jdbcPassword);
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       
	
	}
	 
	 private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		 System.out.println("hi");
		 boolean isValidUser = userDAO.checkLogin(request.getParameter("username"),
				 request.getParameter("password"));
		 RequestDispatcher dispatcher;
		  if(isValidUser) {
			 dispatcher = request.getRequestDispatcher("bookingRoom.jsp");
		  }
		  else
		  {
			  dispatcher = request.getRequestDispatcher("error.jsp");
		  }
		

	        dispatcher.forward(request, response);
	 }

}

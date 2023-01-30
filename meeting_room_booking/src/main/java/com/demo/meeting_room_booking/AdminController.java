package com.demo.meeting_room_booking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        //roomBookingDAO = new RoomBookingDAO(jdbcURL, jdbcUsername, jdbcPassword);
        adminDAO = new AdminDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

			checkLogin(request,response);
		
		
	}
		
		
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 boolean isValidUser = false;
			try {
				isValidUser = adminDAO.checkLogin(request.getParameter("username"),
						 request.getParameter("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch  block
				e.printStackTrace();
			}
			 RequestDispatcher dispatcher;
			  if(isValidUser) {
				 dispatcher = request.getRequestDispatcher("adminpage.jsp");
			  }
			  else
			  {
				  dispatcher = request.getRequestDispatcher("error.jsp");
			  }
			

		        dispatcher.forward(request, response);
		 }
	
		
		 
	
}

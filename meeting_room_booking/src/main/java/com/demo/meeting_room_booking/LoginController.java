package com.demo.meeting_room_booking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private BookingDAO availableDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        availableDAO = new BookingDAO(jdbcURL, jdbcUsername, jdbcPassword);
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

			try {
				checkLogin(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
		
		
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 boolean isValidUser = false;
			try {
				isValidUser = userDAO.checkLogin(request.getParameter("username"),
						 request.getParameter("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch  block
				e.printStackTrace();
			}			
			 RequestDispatcher dispatcher;
			 List<Room> availableRooms = availableDAO.listOfAvailableRooms();
			  if(isValidUser) {
				  request.setAttribute("list",availableRooms );
				  request.setAttribute("username", request.getParameter("username"));
				 dispatcher = request.getRequestDispatcher("availableroom.jsp");
			  }
			  else
			  {
				  dispatcher = request.getRequestDispatcher("error.jsp");
			  }
			

		        dispatcher.forward(request, response);
		 }
	
		
		 
	
}

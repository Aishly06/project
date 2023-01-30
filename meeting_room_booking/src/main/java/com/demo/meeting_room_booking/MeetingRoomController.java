package com.demo.meeting_room_booking;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MeetingRoomController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private RoomBookingDAO roomBookingDAO;
	private BookingDAO bookingDAO;
	private ServletRequest request;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        //roomBookingDAO = new RoomBookingDAO(jdbcURL, jdbcUsername, jdbcPassword);
        bookingDAO = new BookingDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		Booking b = new Booking();
		if (request.getParameter("save") != null) {
			 try {
				 bookingDAO.saveBooking(b);
				 String sql = "INSERT INTO meetingroom.meeting_room_booking (room_id,user_id,date,start_time,end_time,"
			    			+ "created_timestamp) VALUES (?,?,?,?,?,?)";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
		       
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	        switch (action) {
			case "/save":
				try {
					saveBooking(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    break;
			}
	
	}
	 
	 private void listAvailableRoom(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	 
	 private void saveBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println(request.getParameter("date"));
		System.out.println(request.getParameter("start_time"));
		System.out.println(request.getParameter("end_time"));
		 Booking b = new Booking();
		 
		 b.setRoomId(request.getParameter("room_id"));
		 b.setUsername(request.getParameter("username"));
		 b.setDateOfBooking(request.getParameter("date"));
		 b.setStartTime(request.getParameter("start_time"));
		 b.setEndTime(request.getParameter("end_time"));
		 
		 bookingDAO.saveBooking(b);
		 
     
}
		

	

	private void getListOfRooms(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		 System.out.println("hi");
		 List<Room> availableRooms = bookingDAO.listOfAvailableRooms();
		 System.out.print("Aishly"+availableRooms.size());
		 RequestDispatcher dispatcher;
		 
		 request.setAttribute("list",availableRooms );
		 dispatcher = request.getRequestDispatcher("availableroom.jsp");
		

	        
		dispatcher.forward(request, response);
	 }

}

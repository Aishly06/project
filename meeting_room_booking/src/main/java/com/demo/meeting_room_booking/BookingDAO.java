package com.demo.meeting_room_booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDAO {
	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	     
	    public BookingDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL;
	        this.jdbcUsername = jdbcUsername;
	        this.jdbcPassword = jdbcPassword;
	    }
	     
	    protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            jdbcConnection = (Connection) DriverManager.getConnection(
	                                        jdbcURL, jdbcUsername, jdbcPassword);
	        }
	    }
	    
	    public List<Room> listOfAvailableRooms() throws SQLException {
	        
	    	
	        String sql = "SELECT * FROM meetingroom.meeting_room WHERE is_bookable = 1";
	        List<Room> availableRoomsList = new ArrayList<>();
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();
	        while(resultSet.next()) {
	        	Room r = new Room();
	        	r.setId(resultSet.getInt("id"));
	        	r.setName(resultSet.getString("name"));
	        	r.setCapacity(resultSet.getInt("capacity"));
	        	availableRoomsList.add(r);
	        	
	        }
	       
	     return availableRoomsList;    
	       
	    }
	    
	    public boolean saveBooking(Booking bookingDetails) throws SQLException {
	    	
	    	String sql = "INSERT INTO meetingroom.meeting_room_booking (room_id,user_id,date,start_time,end_time,"
	    			+ "created_timestamp) VALUES (?,?,?,?,?,?)";
	    	
	    	 PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    	 statement.setInt(1, Integer.parseInt(bookingDetails.getRoomId()));
	    	 statement.setString(2, (bookingDetails.getUsername()));
	    	 statement.setString(3, bookingDetails.getDateOfBooking());
	    	 statement.setString(4, bookingDetails.getStartTime());
	    	 statement.setString(5, bookingDetails.getEndTime());
	    	 statement.setDate(6, (java.sql.Date) new Date());
	    	 
	    	
            	statement.executeUpdate();
            	System.out.println("booking successfull");
				return false;
				
				
   
	    	
	    }}

		//public List<Room> listAvailableRoom(String name, Integer capacity) {
//			string sql= "SELECT * FROM meeting room WHERE name=? AND capacity=? ";
//			INSERT INTO 
//			//TODO Auto-generated method stub
//			return false;

